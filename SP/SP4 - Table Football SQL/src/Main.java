import java.sql.SQLException;
import java.time.*;
import java.util.ArrayList;

public class Main {
    public static Tournament tournament;
    public static ArrayList<Team> teams = new ArrayList<>();
    public static ArrayList<Match> matches = new ArrayList();
    public static ArrayList<Match> matchesNotDone = new ArrayList();
    public static ArrayList<TeamMatches> teamMatches = new ArrayList();
    public static ArrayList<Player> players = new ArrayList();
//    public static IO io;
    public static boolean useSQL = false;
//    public static LocalTime lastMatchTime;
//    public static LocalDate lastMatchDate;

    public static void main(String[] args) throws SQLException {
        UI.welcomeMessage();
        UI.menuMain();
    }

    public static IO getIO() {
        if (useSQL) return new DBConnector();
        else return new Data();
    }
}
























/*
- normally 16 teams
- normally 8 matches

Team class (arraylist)
    team name
    names of players (2 players)
    points (match won = 2 points)
    pointscore (goals scored - goals other team scored) - only used if 2 teams have the same amount of points
    maybe? amount of games won
    maybe? games played


Tournament class
    Tournament name
    Tournament dates
    Tournament due date (cut off)
    Amount of teams signed up

    generateMatch()
    teamWon()
    teamLost()

    runSim()

Tournament Founder class
    showAllTeams()
    showTeamPlacements()
    showMatchDates()


txt file
    contains all of match data

    Tournament name
    Tournament dates
    Tournament due date (cut off)


 */