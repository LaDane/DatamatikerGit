import java.sql.SQLException;
import java.time.*;
import java.util.ArrayList;

public class Main {
    public static UIData uiData;
    public static Tournament tournament;
    public static Match match;

    public static ArrayList<Team> teams = new ArrayList<>();
//    public static ArrayList<Team> currentTeams = new ArrayList();
//    public static ArrayList<Team> activeTeams = new ArrayList();
    public static ArrayList<Match> matches = new ArrayList();
    public static ArrayList<TeamMatches> teamMatches = new ArrayList();
    public static ArrayList<Player> players = new ArrayList();
//    public static ArrayList<Match> oldMatches = new ArrayList();


    public static void main(String[] args) throws SQLException {
        DBConnector.saveNewTeam("Team Lort");
        int lorteIndex = teams.get(0).getID();
        DBConnector.saveExistingTeam(lorteIndex, 5, 4, 2, 5,false);
        DBConnector.savePlayer("TestLort1",1);
        DBConnector.savePlayer("TestLort2",1);
        DBConnector.savePlayer("TestLort3",1);

        String startD = "2021-10-23";
        LocalDate startDate = LocalDate.parse(startD);
        String startT = "18:00";
        LocalTime startTime = LocalTime.parse(startT);
        DBConnector.saveTournament("TournamentName","TournamentFounder",startTime,startDate,startDate);
        DBConnector.saveMatches(startTime,startDate);
        DBConnector.saveTeamMatches(1,1,0);
        DBConnector.loadData("teamMatches");

       // DBConnector.saveData("playerData");
       // // DBConnector.loadData("playerData");
//        UI.welcomeMessage();
//        UI.menuMain();
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