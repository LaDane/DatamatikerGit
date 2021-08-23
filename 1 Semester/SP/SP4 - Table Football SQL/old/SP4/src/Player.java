public class Player {
    private int playerID;
    private String playerName;
    private int teamID;

    public Player(int ID,String name, int teamID) {
        this.playerID = ID;
        this.playerName = name;
        this.teamID = teamID;
    }

    public int getPlayerID() {return playerID;}
    public String getPlayerName() {return playerName;}
    public int getTeamID() {return teamID;}
}
