public class Match {
    private String team1;
    private String team2;
    private int matchTime;
    private int dayOfMonth;

    public String getTeam1() {return team1;}
    public String getTeam2() {return team2;}
    public int getMatchTime() {return matchTime;}
    public int getDayOfMonth() {return dayOfMonth;}

    public Match(String team1, String team2, int matchTime, int dayOfMonth) {
        this.team1 = team1;
        this.team2 = team2;
        this.matchTime = matchTime;
        this.dayOfMonth = dayOfMonth;
    }
}