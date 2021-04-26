import java.time.*;

public class Match {
    private int matchID;
    private LocalTime matchStartTime;
    private LocalDate matchStartDate;

    public Match(int matchID, LocalTime matchStartTime, LocalDate matchStartDate) {
        this.matchID = matchID;
        this.matchStartTime = matchStartTime;
        this.matchStartDate = matchStartDate;
    }

    public LocalTime getMatchStartTime() {return matchStartTime;}
    public LocalDate getMatchStartDate() {return matchStartDate;}
}