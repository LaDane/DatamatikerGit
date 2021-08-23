public class TeamMatches {
    private int ID;
    private int matchID;
    private int teamID;
    private int score;

    public TeamMatches(int ID, int matchID, int teamID, int score) {
        this.ID = ID;
        this.matchID = matchID;
        this.teamID = teamID;
        this.score = score;
    }

    public int getID() {
        return ID;
    }

    public int getMatchID() {
        return matchID;
    }

    public int getTeamID() {
        return teamID;
    }

    public int getScore() {
        return score;
    }
}
