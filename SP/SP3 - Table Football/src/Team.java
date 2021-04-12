public class Team {
    private String name;
    private String player1;
    private String player2;
    private int points;
    private int pointScore;
    private int gamesWon;
    private int gamesPlayed;
    private boolean knockedOut;

    public Team(String name, String player1, String player2, int points, int pointScore, int gamesWon, int gamesPlayed, boolean knockedOut) {
        this.name = name;
        this.player1 = player1;
        this.player2 = player2;
        this.points = points;
        this.pointScore = pointScore;
        this.gamesWon = gamesWon;
        this.gamesPlayed = gamesPlayed;
        this.knockedOut = knockedOut;
    }

    public String getName() {return name;}
    public String getPlayer1() {return player1;}
    public String getPlayer2() {return player2;}

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