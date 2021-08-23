public class Team {
    private int teamID;
    private String name;
    private int points;
    private int pointScore;
    private int gamesWon;
    private int gamesPlayed;
    private boolean knockedOut;

    public Team(int teamID, String name, int points, int pointScore, int gamesWon, int gamesPlayed, boolean knockedOut) {
        this.teamID = teamID;
        this.name = name;
        this.points = points;
        this.pointScore = pointScore;
        this.gamesWon = gamesWon;
        this.gamesPlayed = gamesPlayed;
        this.knockedOut = knockedOut;
    }

    public int getID() {return teamID;}
    public String getName() {return name;}

    public int getPoints() {return points; }
    public void setPoints(int points) {this.points = points;}

    public int getPointScore() {return pointScore;}
    public void setPointScore(int pointScore) {this.pointScore = pointScore; }

    public int getGamesWon() {return gamesWon;}
    public void setGamesWon(int gamesWon) {this.gamesWon = gamesWon;}

    public int getGamesPlayed() {return gamesPlayed;}
    public void setGamesPlayed(int gamesPlayed) {this.gamesPlayed = gamesPlayed;}

    public void teamHasBeenKnockedOut() {this.knockedOut = true;}
    public boolean getTeamKnockedOut() {return knockedOut;}
}