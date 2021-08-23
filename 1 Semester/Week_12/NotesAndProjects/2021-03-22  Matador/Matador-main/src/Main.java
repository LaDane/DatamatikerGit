import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;
import java.util.Scanner;

// Billede af matador: https://i.ebayimg.com/images/g/rXMAAOSwtVde57gz/s-l1600.jpg
public class Main {
    public static ArrayList<Player> players;
    public static UI ui;
    public static Board board;

    public static void main(String[] args) {

        // deleteSavedGame();

        startOrContinueGame();
        printWelcomeToPlayers();

        board = new Board();

        runGameLoop();
    }

    /**
     * The actual game runs here, until the user exits.
     * Everything will go in the update() method for now,
     * so that graphics can go in draw() later.
     */
    private static void runGameLoop() {
        boolean exit = false;

        while (!exit) {
            exit = update(); // Game logic
            draw();          // Graphics
        }

        // User has chosen to exit the program
        saveGameData();
        dispose();
    }

    private static void doTurn(int playerID) {
        Dice dice = new Dice();
        Player player = players.get(playerID);
        player.updatePosition(dice.throwDice());
        Start start = (Start)board.getField(player.getPosition());
        Action action = start.getAction();
        ui.showActionMessage(action.getMsg());
        player.doTransaction(action.getAmount());
    }

    /**
     * Update the state.
     * @return true if program should exit
     */
    private static boolean update() {
        boolean exit = false;
        String input = ui.getUserInput("\nType some input, or \"exit\" to exit: ");
        if (input.equalsIgnoreCase("exit")) {
            exit = true;
        }
        // Update the game state here:
        System.out.println("You typed: " + input);
        return exit;
    }

    /**
     * Draw the state to the screen.
     */
    private static void draw() {

    }

    /**
     * Shut down all relevant resources. Mostly applicable to graphics objects.
     */
    private static void dispose() {
        System.out.println("\nSaving and exitting.");
        System.exit(0); // Error code 0 == no errors
    }

    public static void startOrContinueGame() {
        ui = new UI();
        players = readGameData();
        if (players.size() == 0) {
            players = ui.createPlayers();
        } else {
            ui.promptNewGame();
        }
    }

    public static void saveGameData() {
        FileWriter writer = null;
        try {
            writer = new FileWriter("data.txt");
            writer.write(getGameDataFromSession());
        } catch (IOException e) {
            System.out.println("Couldn't instantiate the FileWriter in saveGameData()");
            e.printStackTrace();
        } finally {
            try {
                writer.close();
            } catch (NullPointerException | IOException e) {
                System.out.println("Couldn't close the FileWriter in saveGameData()");
                e.printStackTrace();
            }
        }
    }

    /**
     * Fill the players arraylist with players from data.txt.
     * @return ArrayList<Player>
     */
    public static ArrayList<Player> readGameData() {
        ArrayList<Player> playerList = new ArrayList<Player>();
        Player.counter = 0; // Just to be safe

        File file = new File("data.txt");
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if (scanner != null) {
            while (scanner.hasNextLine()) {
                String[] colonSeperatedValues = scanner.nextLine().split(":");
                String name = colonSeperatedValues[0];
                int balance = Integer.parseInt(colonSeperatedValues[1]);
                playerList.add(new Player(name, balance));
            }
        }

        return playerList;
    }

    public static void deleteSavedGame() {
        FileWriter writer = null;
        try {
            writer = new FileWriter("data.txt");
            writer.write("");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                writer.close();
            } catch (NullPointerException | IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static String getGameDataFromSession() {
        StringBuilder gameData = new StringBuilder();
        for (Player p : players) {
            // name:balance
            String playerData = String.format("%s:%d\n", p.getName(), p.getBankAccount().getBalance());
            gameData.append(playerData);
        }
        return gameData.toString();
    }

    public static void printPlayers() {
        for (int i = 0; i < players.size(); i++) {
            System.out.println(players.get(i));
        }
    }

    public static Player getPlayerByID(int id) {
        for (Player p : players) {
            if (p.getId() == id) {
                return p;
            }
        }
        System.out.println("There is no player with ID " + id);
        return null;
    }

    public static Player getPlayerByName(String name) {
        for (Player p : players) {
            if (p.getName().equals(name)) {
                return p;
            }
        }
        System.out.println("There is no player with the name " + name);
        return null;
    }

    private static void printWelcomeToPlayers() {
        int lastIndex = players.size() - 1;

        for (int i = 0; i < players.size(); i++) {
            String name = players.get(i).getName();

            if (i != 0 && i != lastIndex) {
                System.out.printf(", %s", name);
            } else if (i == lastIndex && i != 0) {
                System.out.printf(" and %s.", name);
                return;
            } else {
                System.out.printf("\nWelcome, %s", name);
            }
        }
    }
}
