import java.util.ArrayList;

class Controller{
    public static Player currentPlayer;
    public static UI UI;
    //todo: change Filereader datatype to IO interface
    public static IO io;
    public static Board board;
    public static int playerCount=0;
    //ENUM
    enum Datasource{
        DATABASE,
        CSVFILE
    }
    private static Datasource src = Datasource.DATABASE;
    private static String path;
    //todo: make enum for various data sources


    public static void loadData(){
        io = getIO();// new FileReader();// todo: use a getIO() method to instiate the reader/connector dynamically

        UI = new UI();
        String[] fields_data = io.readFieldData(path);
        board = new Board(fields_data);
        //  String[] cards_data = io.readCardData(null);
        //  board.setCards(cards_data);
       // Main.players = io.readGameData();

    }

    public static IO getIO() {
        if(src == Datasource.DATABASE){
            path = null;
            return new DBConnector();
        }else if (src == Datasource.CSVFILE){
            path = "fields.csv";
            return new FileReader();
        }
        return null;
    }


    /**
     * The actual game runs here, until the user exits.
     * Everything will go in the update() method for now,
     * so that graphics can go in draw() later.
     */
    public static void runGameLoop() {
        //boolean exit = false;
        String input="";

        while (!input.toUpperCase().equals("N")) {
            if(playerCount == Main.players.size()) {
                playerCount=0;
            }
            currentPlayer = Main.players.get(playerCount);

            System.out.println(currentPlayer.getName() + "'s tur");
            doTurn(currentPlayer);
            input = UI.getUserInput("Klar til næste runde? Y/N: ");
            playerCount++;
        }

        // User has chosen to exit the program
        System.out.println("Afslutter spillet. Tak for denne gang! ");
        io.saveGameData();
    }

    public static void doTurn(Player player){
        Dice d = new Dice();
        int sum = d.throwDice();
        UI.displayMessage(currentPlayer.getName() + (" slog " + sum));
        int currentPosition = player.updatePosition(sum);
        Field f = board.getField(currentPosition);
        Action a = f.getAction();
        String response = UI.showActionMessage(a);
        if(response != "N"){
            processesResponse(a, f);
        }
    }

    public static void processesResponse(Action a, Field f) {
        if (f instanceof Property) {
            Property fp = (Property)f;
            if(a.getResponseMsg() != null){
                if(a.getResponseMsg().equals("buy")){
                    // Der er blevet sagt ja til at købe grunden/forretningen
                    fp.updateOwnership(currentPlayer);
                    //Evt prompt med option to buy houses her - tjek reglerne om man må det det i samme runde som  man opnår monopol.
                    currentPlayer.doTransaction(null, -fp.getCost());


                }else if(a.getResponseMsg().equals("pay")){
                    // Der er blevet sagt ok til at betale udgift til en grund/forretning
                    currentPlayer.doTransaction(fp.getOwner(), fp.getIncome());
                }
            }
        } else if(f instanceof Tax){
            Tax ft = (Tax) f;
            if(a.getResponseMsg().equals("pay set amount")){
                currentPlayer.doTransaction(null, -ft.getCost());
            }
        }/*else if(f instanceof Start) {
         Start sf = (Start)f;
         a = sf.getAction();
     }else if (f instanceof Land){
         Land lf = (Land)f;
         a = lf.getAction();
     } else if (f instanceof Event) {
         Event ef = (Event)f;
         a = ef.getAction();
     }*/
        UI.displayMessage(currentPlayer.getName()+"'s saldo: "+currentPlayer.getBalance());
    }
    //todo make getIO method to instaintiate the right datasource connector/reader

}