import java.time.LocalDate;
import java.time.LocalTime;

public interface IO {
    public void loadData(String data);
    public void savePlayer(String name, int teamID);
    public void saveNewTeam(String teamName);
    public void saveExistingTeam(int teamID, int points, int pointScore, int gamesWon, int gamesPlayed, boolean knockedOut);
    public void saveTournament(String name, String founderName, LocalTime tournamentStartTime, LocalDate tournamentStartDate, LocalDate tournamentDueDate);
    public void saveNewMatches(LocalTime matchStartTime, LocalDate matchStartDate, boolean done);
    public void saveExistingMatches(int matchID, LocalTime matchStartTime, LocalDate matchStartDate, boolean done);
    public void saveNewTeamMatches(int matchID, int teamID, int score);
    public void saveExistingTeamMatches(int teamMatchID, int matchID, int teamID, int score);
}
