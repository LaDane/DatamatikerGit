import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class UI {

    /**
     * Query user for players' names.
     * Get those using getUserInput().
     * @return ArrayList<Player>
     */
    public ArrayList<Player> createPlayers() {
        final int MAX_PLAYERS = 6;

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
        String input = getUserInput("Would you like to start a new game? Y/n: ").trim();
        if (input.equalsIgnoreCase("y") || input.equals("")) {
            Main.players = createPlayers();
        }
    }

    public void showActionMessage(String msg)
    {
        String input = getUserInput(msg + "Tast Y hvis du er indforstået.");
        while (input.toUpperCase().equals("Y") || input.toUpperCase().equals("N")) {

            if (input.toUpperCase().equals("Y")) {
                System.out.println("Du har købet landet, tillykke!");
                break;
            }
            if (input.toUpperCase().equals("N")) {
                System.out.println("Du har ikke købt landet.");
                break;
            } else {
                System.out.println("Dit input giver desværre ingen mening.");
            }
        }

        /*
        //Scenarie beskeder med udgangspunkt i hvilken TYPE felt man lander på
        // Parametrene i if-cases er en hurtig udgave af at finde ud af hvor vi er.
        if (config.equals(config[0])) {
            System.out.println("Du har landet på start!");
            System.out.println("Du får 4000kr!");
        }
        if (config.equals(config[1]))
        {
            System.out.println("Du er landet på et stykke land");
            System.out.println("Vil du købe det?");

            while (input.toUpperCase().equals("y") || input.toUpperCase().equals("n")) {
                input = getUserInput("tryk 'y' for ja eller 'n' for nej");

                if (input.toUpperCase().equals("Y")) {
                    System.out.println("Du har købet landet, tillykke!");
                    break;
                }
                if (input.toUpperCase().equals("N")) {
                    System.out.println("Du har ikke købt landet.");
                    break;
                } else {
                    System.out.println("Dit input giver desværre ingen mening.");
                }
            }
        }
        if (config.equals(config[2]))
        {
            System.out.println("Du er landet på en joker");
            System.out.println("Du trækker et kort");
        }
        if (config.equals(config[3]))
        {
            System.out.println("Du er landet på et stykke land");
            System.out.println("Vil du købe det?");

            while (input.toUpperCase().equals("y") || input.toUpperCase().equals("n")) {
                input = getUserInput("tryk 'y' for ja eller 'n' for nej");

                if (input.toUpperCase().equals("Y")) {
                    System.out.println("Du har købet landet, tillykke!");
                    break;
                }
                if (input.toUpperCase().equals("N")) {
                    System.out.println("Du har ikke købt landet.");
                    break;
                } else {
                    System.out.println("Dit input giver desværre ingen mening.");
                }
            }
        }
        if (config.equals(config[4]))
        {
            System.out.println("Du er landet på SKAT");
            System.out.println("Du skal betale 4000kr til SKAT");
        }
        if (config.equals(config[5]))
        {
            System.out.println("Du er landet på en shippingline");
            System.out.println("Vil du købe det?");

            while (input.toUpperCase().equals("y") || input.toUpperCase().equals("n")) {
                input = getUserInput("tryk 'y' for ja eller 'n' for nej");

                if (input.toUpperCase().equals("Y")) {
                    System.out.println("Du har købet landet, tillykke!");
                    break;
                }
                if (input.toUpperCase().equals("N")) {
                    System.out.println("Du har ikke købt landet.");
                    break;
                } else {
                    System.out.println("Dit input giver desværre ingen mening.");
                }
            }


        }

         */

    }
}
