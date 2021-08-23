import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReader implements IO {

    public String[] readFieldData(String path) {
        String[] contents = new String[40];
        File file = new File(path);
        Scanner scanner;
        try {
            scanner = new Scanner( file);
            String headerline = scanner.nextLine();//bruges kun til at ignorere headeren
            int i = 0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                contents[i] =line;
                i++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("Couldn't load CSV");
            e.printStackTrace();
        }
        return contents;
    }

    /**
     * Fill the players arraylist with players from data.txt.
     * @return ArrayList<Player>
     */
    public ArrayList<Player> readGameData() {
        ArrayList<Player> playerList = new ArrayList<Player>();

        File file = new File("data.txt");
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
            String headerline = scanner.nextLine();//bruges kun til at ignorere headeren
            while (scanner.hasNextLine()) {
                String[] colonSeperatedValues = scanner.nextLine().split(",");
                String name = colonSeperatedValues[0];
                int balance = Integer.parseInt(colonSeperatedValues[1]);
                Player p = new Player(name, balance);
                playerList.add(p);

                if(colonSeperatedValues.length > 2) {
//NB! This mechanism will not scale, and calls for different data structore - database or Json
                    setOwnershipData(p, colonSeperatedValues[2]);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return playerList;
    }

    public void setOwnershipData(Player p, String data) {
        //NB! This mechanism will not scale, and calls for different data structore - database or Json

        String trimmed_data = data.substring(1,data.length() -1) ;//Fjerner første og sidste tegn i strengen [2,4] bliver til 2,4
        String[] ownerships = trimmed_data.split(":"); //placerer hhv 2 og 4 i et array på hvert sit index
        for (String s:ownerships) {
            int propertyfield_id = Integer.parseInt(s);
            Property f = (Property) Controller.board.getField(propertyfield_id);
            f.updateOwnership(p);
        }
    }
    public String[] readCardData(String path) {return new String[6];}
    public void saveGameData() {
        StringBuilder gameData = new StringBuilder();
        for (Player p : Main.players) {
            String playerData = String.format("%s:%d\n", p.getName(), p.getBalance());
            gameData.append(playerData);
        }

        FileWriter writer = null;
        try {
            writer = new FileWriter("data.txt");
            writer.write(String.valueOf(gameData));
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
    public void deleteSavedGame() {
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


}
