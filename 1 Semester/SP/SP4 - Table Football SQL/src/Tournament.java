import java.time.*;

public class Tournament {
    // Names
    private String tournamentName;
    private String founderName;
    // Time & Date
    private LocalTime tournamentStartTime;
    private LocalDate tournamentStartDate;
    private LocalDate tournamentDueDate;            // the last date a team can sign up for tournament


    public Tournament(String tournamentName, String founderName, LocalTime tournamentStartTime, LocalDate tournamentStartDate, LocalDate tournamentDueDate) {
        this.tournamentName = tournamentName;
        this.founderName = founderName;
        this.tournamentStartTime = tournamentStartTime;
        this.tournamentStartDate = tournamentStartDate;
        this.tournamentDueDate = tournamentDueDate;
    }

    public String getTournamentName() {return tournamentName;}
    public String getFounderName() {return founderName;}
    public LocalTime getTournamentStartTime() {return tournamentStartTime;}
    public LocalDate getTournamentStartDate() {return tournamentStartDate;}
    public LocalDate getTournamentDueDate() {return tournamentDueDate;}
}
