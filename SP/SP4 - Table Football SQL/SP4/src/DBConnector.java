import java.io.File;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Scanner;
import java.time.*;

public class DBConnector implements IO {
    static final String DB_URL = "jdbc:mysql://localhost/tournament?autoReconnect=true&useSSL=false";
    static final String USER = "root";
    static final String PASS = "Kolort231100"; //ENV :(

    //In case we need a custom query; saveData() and loadData() will be used in most cases.
    public static ResultSet dbQuery(String query, boolean update) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        // Open a connection to the DB
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            if (!update) {
                rs = stmt.executeQuery(query);
            } else {
                stmt.executeUpdate(query);
            }
            return rs;
        } catch (Exception se) {
            se.printStackTrace();
        }
        finally {
        }
        return null;
    }


    public static void loadData(String data) throws SQLException {
        if (data.equals("playerData")) {
            ResultSet rs = dbQuery("SELECT * FROM player", false);
            if (rs != null) {
                while (rs.next()) {
                    //Retrieve by column name
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    int teamID = rs.getInt("team_id");
                    Player newPlayer = new Player(id,name, teamID);
                    Main.players.add(newPlayer);
                   // System.out.println("Player ID : "+ id +"\t Name : "+ name +"\tTeam ID : ");
                }
                try {
                    rs.close();
                } catch (SQLException e) {}
            }
        }

        if (data.equals("teamData")) {
            ResultSet rs = dbQuery("SELECT * FROM team", false);
            if (rs != null) {
                while (rs.next()) {
                    //Retrieve by column name
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    int points = rs.getInt("points");
                    int pointScore = rs.getInt("point_score");
                    int gamesWon = rs.getInt("games_won");
                    int gamesPlayed = rs.getInt("games_played");
                    boolean knockedOut= rs.getBoolean("knocked_out");
                    Team newTeam = new Team(id,name,points,pointScore,gamesWon,gamesPlayed,knockedOut);
                    Main.teams.add(newTeam);
                    //System.out.println("TEAM ID : "+ id +"\t Name : "+ name +"\tPoints : "+points+"");
                }
                try {
                    rs.close();
                } catch (SQLException e) {}
            }
        }

        if (data.equals("tournament")) {
            ResultSet rs = dbQuery("SELECT * FROM tournament_data", false);
            if (rs != null) {
                while (rs.next()) {
                    //Retrieve by column name
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    String founderName = rs.getString("founder_name");
                    LocalDate tournamentStartDate = rs.getDate("start_date").toLocalDate();
                    LocalTime tournamentStartTime = rs.getTime("start_time").toLocalTime();
                    LocalDate tournamentDueDate = rs.getDate("due_date").toLocalDate();
                    Tournament newTournament = new Tournament(name,founderName,tournamentStartTime,tournamentStartDate,tournamentDueDate);
                    Main.tournament =newTournament;
                    System.out.println("Tournament ID : "+ id +"\t Name : "+ name +"\tfounder name : "+founderName+"");
                }
                try {
                    rs.close();
                } catch (SQLException e) {}
            }
        }

        if (data.equals("matches")) {
            ResultSet rs = dbQuery("SELECT * FROM matches", false);
            if (rs != null) {
                while (rs.next()) {
                    int id = rs.getInt("id");
                    LocalDate matchStartDate = rs.getDate("start_date").toLocalDate();
                    LocalTime matchStartTime = rs.getTime("start_time").toLocalTime();
                    Match newMatch = new Match(id, matchStartTime, matchStartDate);
                    System.out.println("Loaded match \tID : "+ id +"\t\tStart Time : "+ matchStartTime +"\t\tStart date : "+ matchStartDate);
                    Main.matches.add(newMatch);
                }
            }
        }

        if (data.equals("teamMatches")) {
            ResultSet rs = dbQuery("SELECT * FROM team_matches", false);
            if (rs != null) {
                while (rs.next()) {
                    int id = rs.getInt("id");
                    int matchID = rs.getInt("match_id");
                    int teamID = rs.getInt("team_id");
                    int score = rs.getInt("score");
                    TeamMatches newTeamMatch = new TeamMatches(id, matchID, teamID, score);
                    System.out.println("Loaded team match \tID : "+ id +"\tMatch ID : "+ matchID +"\tTeam ID : "+ teamID +"\tScore : "+ score);
                    Main.teamMatches.add(newTeamMatch);
                }
            }
        }
    }

    public static int selectMaxID(String tableName) throws SQLException {
        int maxID = 0;
        ResultSet rs = dbQuery("SELECT id FROM "+ tableName +" WHERE id=(SELECT MAX(id) FROM "+ tableName +")", false);
        if (rs != null) {
            while (rs.next()) {
                maxID = rs.getInt("id");
            }
            try {
                rs.close();
            } catch (SQLException e) {}
        }
        return maxID;
    }

    public static void savePlayer(String name, int team_id) throws SQLException {
        int ID = selectMaxID("player") + 1;
        dbQuery("INSERT INTO Player(id, name, team_id) VALUES(" + ID + ",\"" + name + "\"," + team_id + ")", true);
        Player newPlayer = new Player(ID, name, team_id);
        Main.players.add(newPlayer);
    }

    public static void saveNewTeam(String teamName) throws SQLException {
        int ID = selectMaxID("team") + 1;
        dbQuery("INSERT INTO team(id, name) VALUES(" + ID + ",\""+ teamName + "\")", true);
        Team newTeam = new Team(ID, teamName, 0, 0, 0, 0, false);
        Main.teams.add(newTeam);
    }

    public static void saveExistingTeam(int teamID, int points, int pointScore, int gamesWon, int gamesPlayed, boolean knockedOut) {
            String sql = "UPDATE tournament.team SET " +
                    "points = " + points +
                    ",point_score = " + pointScore +
                    ",games_won = " + gamesWon +
                    ",games_played = " + gamesPlayed +
                    ",knocked_out = " + knockedOut +
                    " WHERE id = " + teamID + ";";
            dbQuery(sql, true);
    }

    public static void saveTournament(String name, String founderName, LocalTime tournamentStartTime, LocalDate tournamentStartDate, LocalDate tournamentDueDate) throws SQLException {
        int ID = selectMaxID("tournament_data") + 1;
        String sql = "Insert INTO tournament_data(id, name, founder_name, start_date, start_time, due_date) VALUES(" +
                ID +",\""+
                name +"\",\""+
                founderName +"\",\""+
                tournamentStartDate +"\",\""+
                tournamentStartTime +"\",\""+
                tournamentDueDate +"\")";
        dbQuery(sql, true);
        Tournament newTournament = new Tournament(name, founderName, tournamentStartTime, tournamentStartDate, tournamentDueDate);
        Main.tournament = newTournament;
        // String sql = "INSERT INTO tournament(id, name, founder_name, start_date, start_time, due_date)" + "VALUES(?,?,?,?,?,?)";
    }

    public static void saveMatches(LocalTime matchStartTime, LocalDate matchStartDate) throws SQLException {
        int ID = selectMaxID("matches") + 1;
        String sql = "Insert INTO matches(id, start_time,start_date) VALUES("+ ID +",\"" + matchStartTime + "\",\""+ matchStartDate+"\")";
        dbQuery(sql,true);
        Match newMatch = new Match(ID, matchStartTime, matchStartDate);
        Main.matches.add(newMatch);
    }

    public static void saveTeamMatches(int matchID, int teamID, int score) throws SQLException {
        int ID = selectMaxID("team_matches") + 1;
        String sql = "Insert INTO team_matches(id, match_id, team_id, score) VALUES(" +
                ID +",\""+
                matchID +"\",\""+
                teamID +"\",\""+
                score +"\")";
        dbQuery(sql, true);
        TeamMatches newTeamMatch = new TeamMatches(ID,matchID,teamID,score);
        Main.teamMatches.add(newTeamMatch);
    }
}





