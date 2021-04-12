public class Tournament {
    private String tournamentName;
    private int tournamentStartTime;
    private int tournamentStartDayOfMonth;
    private int tournamentEndDayOfMonth;
    private int tournamentMonth;
    private int tournamentYear;
    private String tournamentDueDate;       // the last date a team can sign up for tournament

    public Tournament(String tournamentName, int tournamentStartTime, int tournamentStartDayOfMonth, int tournamentMonth,
                      int tournamentYear, String tournamentDueDate, int amountOfTeams) {
        this.tournamentName = tournamentName;
        this.tournamentStartTime = tournamentStartTime;
        this.tournamentStartDayOfMonth = tournamentStartDayOfMonth;
        this.tournamentMonth = tournamentMonth;
        this.tournamentYear = tournamentYear;
        this.tournamentDueDate = tournamentDueDate;
    }

    public String getTournamentName() {return tournamentName;}
    public int getTournamentStartTime() {return tournamentStartTime;}
    public void setTournamentStartTime(int date) {this.tournamentStartTime = date;}
    public int getTournamentStartDayOfMonth() {return tournamentStartDayOfMonth;}
    public int getTournamentEndDayOfMonth() {return tournamentEndDayOfMonth;}
    public void setTournamentEndDayOfMonth(int date) {
        this.tournamentEndDayOfMonth = date;
    }
    public int getTournamentMonth() {return tournamentMonth; }
    public int getTournamentYear() {return tournamentYear;}
    public String getTournamentDueDate() {return tournamentDueDate;}
    public int getAmountOfTeams() {return Main.currentTeams.size();}

    private void runSim() {

    }
}
