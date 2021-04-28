import java.time.*;

public class Match {
    private int matchID;
    private LocalTime matchStartTime;
    private LocalDate matchStartDate;
    private boolean done = false;

    public Match(int matchID, LocalTime matchStartTime, LocalDate matchStartDate, boolean done) {
        this.matchID = matchID;
        this.matchStartTime = matchStartTime;
        this.matchStartDate = matchStartDate;
        this.done=done;
    }

    public int getMatchID() {return matchID;}
    public LocalTime getMatchStartTime() {return matchStartTime;}
    public LocalDate getMatchStartDate() {return matchStartDate;}
    public boolean getMatchDone() {return done;}
    public void setMatchDone() {this.done = true;}
}