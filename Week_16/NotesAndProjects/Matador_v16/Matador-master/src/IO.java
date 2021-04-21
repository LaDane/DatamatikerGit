import java.util.ArrayList;

public interface IO {
    public String[] readFieldData(String path);
    public ArrayList<Player> readGameData();
    public void setOwnershipData(Player p, String data);
    public String[] readCardData(String path);
    public void saveGameData();
    public void deleteSavedGame();
}
