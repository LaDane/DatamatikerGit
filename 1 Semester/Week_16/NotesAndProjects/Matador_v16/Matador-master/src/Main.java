import java.util.ArrayList;

public class Main {

    public static ArrayList<Player> players = new ArrayList<Player>();

    public static void main(String[] args) {

        Controller.loadData();runGameLoop
        startOrContinueGame();
        printWelcomeToPlayers();
        Controller.runGameLoop();

        // deleteSavedGame();
    }


 public static void startOrContinueGame() {
     if (players.size() == 0) {
         players = Controller.UI.registerPlayers();
     } else {

         Controller.UI.promptNewGame();
     }
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
                System.out.printf(" and %s", name +".\n");
                return;
            } else {
                System.out.printf("\nWelcome, %s", name);
            }
        }
        System.out.println();
    }


}
