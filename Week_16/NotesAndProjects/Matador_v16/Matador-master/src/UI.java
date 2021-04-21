import java.util.ArrayList;
import java.util.Scanner;

public class UI {
    /**
     * Query user for players' names.
     * Get those using getUserInput().
     * @return ArrayList<Player>
     */
    public ArrayList<Player>registerPlayers() {
        final int MAX_PLAYERS = 6;
        System.out.println("Registrering af spillere ");
        // Get names of players
        ArrayList<Player> players = new ArrayList<Player>();
        int count = 0;
        while (players.size() < MAX_PLAYERS) {
            String playerName = getUserInput("Skriv navnet på spiller " + count + ", Q for at afslutte: ");
            if (playerName.toLowerCase().equals("q")) {
                break;
            }
            players.add(new Player(playerName, 30000));
            count++;
        }
        return players;
    }

    public String showActionMessage(Action action) {
        String input = getUserInput(action.getMsg());
        if (input.toUpperCase().equals("Y")) {
            return "Y";
        }
        else if (input.toUpperCase().equals("N")) {
            return "N";
        } else {
            System.out.println("Dit input giver desværre ingen mening.");
            showActionMessage(action);
        }
        return null;
    }

    /**
     * Give a message in System.out.
     * Get input from System.in.
     * @param msg
     * @return String
     */
    public String getUserInput(String msg){
        System.out.print(msg);
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }

    public void promptNewGame() {
        String input = getUserInput("Start nyt spil? Y/N: ").trim();
        if (input.equalsIgnoreCase("y") || input.equals("")) {
            Main.players = registerPlayers();
        }
    }
    public void displayMessage(String msg){
        System.out.println("\n ***************");
        System.out.println(msg);
        System.out.println("***************\n");
    }
 }


