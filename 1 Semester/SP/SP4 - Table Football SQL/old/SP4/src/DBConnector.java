import java.sql.*;
import java.time.*;

public class DBConnector implements IO {
    static final String DB_URL = "jdbc:mysql://localhost/tournament?autoReconnect=true&useSSL=false";
    static final String USER = "root";
    static final String PASS = "Datamatiker123"; //ENV :(

    //In case we need a custom query; saveData() and loadData() will be used in most cases.
    public ResultSet dbQuery(String query, boolean update) {
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
        return null;
    }


    public void loadData(String data) {
        try {
            if (data.equals("playerData")) {

                ResultSet rs = dbQuery("SELECT * FROM player", false);
                if (rs != null) {
                    while (rs.next()) {
                        //Retrieve by column name
                        int id = rs.getInt("id");
                        String name = rs.getString("name");
                        int teamID = rs.getInt("team_id");
                        Player newPlayer = new Player(id, name, teamID);
                        Main.players.add(newPlayer);
                    }
                    try {
                        rs.close();
                    } catch (SQLException e) {}
                }
            }



            if (data.equals("teamsData")) {
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
                        boolean knockedOut = rs.getBoolean("knocked_out");
                        Team newTeam = new Team(id, name, points, pointScore, gamesWon, gamesPlayed, knockedOut);
                        Main.teams.add(newTeam);
                    }
                    try {
                        rs.close();
                    } catch (SQLException e) {
                    }
                }
            }

            if (data.equals("tournamentData")) {
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
                        Tournament newTournament = new Tournament(name, founderName, tournamentStartTime, tournamentStartDate, tournamentDueDate);
                        Main.tournament = newTournament;
                    }
                    try {
                        rs.close();
                    } catch (SQLException e) {
                    }
                }
            }

            if (data.equals("matchesData")) {
                ResultSet rs = dbQuery("SELECT * FROM matches", false);
                if (rs != null) {
                    while (rs.next()) {
                        int id = rs.getInt("id");
                        LocalDate matchStartDate = rs.getDate("start_date").toLocalDate();
                        LocalTime matchStartTime = rs.getTime("start_time").toLocalTime();
                        boolean done = rs.getBoolean("done");
                        Match newMatch = new Match(id, matchStartTime, matchStartDate,done);
                        Main.matches.add(newMatch);
                    }
                }
            }

            if (data.equals("teamMatchesData")) {
                ResultSet rs = dbQuery("SELECT * FROM team_matches", false);
                if (rs != null) {
                    while (rs.next()) {
                        int id = rs.getInt("id");
                        int matchID = rs.getInt("match_id");
                        int teamID = rs.getInt("team_id");
                        int score = rs.getInt("score");
                        TeamMatches newTeamMatch = new TeamMatches(id, matchID, teamID, score);
                        Main.teamMatches.add(newTeamMatch);
                    }
                }
            }
        } catch (SQLException e) {}
    }

    public int selectMaxID(String tableName) throws SQLException {
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

    public void savePlayer(String name, int team_id) {
        int ID = 0;
        try {ID = selectMaxID("player") + 1;}
        catch (SQLException e) {}

        dbQuery("INSERT INTO Player(id, name, team_id) VALUES(" + ID + ",\"" + name + "\"," + team_id + ")", true);
        Player newPlayer = new Player(ID, name, team_id);
        Main.players.add(newPlayer);
    }

    public void saveNewTeam(String teamName) {
        int ID = 0;
        try {ID = selectMaxID("team") + 1;}
        catch (SQLException e) {}

        dbQuery("INSERT INTO team(id, name) VALUES(" + ID + ",\""+ teamName + "\")", true);
        Team newTeam = new Team(ID, teamName, 0, 0, 0, 0, false);
        Main.teams.add(newTeam);
    }

    public void saveExistingTeam(int teamID, int points, int pointScore, int gamesWon, int gamesPlayed, boolean knockedOut) {
        String sql = "UPDATE tournament.team SET " +
                    "points = " + points +
                    ",point_score = " + pointScore +
                    ",games_won = " + gamesWon +
                    ",games_played = " + gamesPlayed +
                    ",knocked_out = " + knockedOut +
                    " WHERE id = " + teamID + ";";
        dbQuery(sql, true);
        Main.teams.clear();
        loadData("teamsData");
    }

    public void saveTournament(String name, String founderName, LocalTime tournamentStartTime, LocalDate tournamentStartDate, LocalDate tournamentDueDate) {
        int ID = 0;
        try {ID = selectMaxID("tournament_data") + 1;}
        catch (SQLException e) {}

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
    }

    public void saveNewMatches(LocalTime matchStartTime, LocalDate matchStartDate, boolean done) {
        int ID = 0;
        try {ID = selectMaxID("matches") + 1;}
        catch (SQLException e) {}

        String sql = "Insert INTO matches(id, start_time,start_date) VALUES("+ ID +",\"" + matchStartTime + "\",\""+ matchStartDate+"\")";
        dbQuery(sql,true);
        Match newMatch = new Match(ID, matchStartTime, matchStartDate,done);
        Main.matches.add(newMatch);
    }

    @Override
    public void saveExistingMatches(int matchID, LocalTime matchStartTime, LocalDate matchStartDate, boolean done) {
        int matchDone=0;
        if (done){
            matchDone=1;
        }
        String sql = "UPDATE tournament.matches SET " +
                "done = " + matchDone +
                " WHERE id = " + matchID + ";";
        dbQuery(sql, true);
        Main.matches.clear();
        loadData("matchesData");
    }

    public void saveNewTeamMatches(int matchID, int teamID, int score) {
        int ID = 0;
        try {ID = selectMaxID("team_matches") + 1;}
        catch (SQLException e) {}
        String sql = "Insert INTO team_matches(id, match_id, team_id, score) VALUES(" +
                ID +",\""+
                matchID +"\",\""+
                teamID +"\",\""+
                score +"\")";
        dbQuery(sql, true);
        TeamMatches newTeamMatch = new TeamMatches(ID,matchID,teamID,score);
        Main.teamMatches.add(newTeamMatch);
    }

    public void saveExistingTeamMatches(int teamMatchID, int matchID, int teamID, int score) {
        String sql = "UPDATE tournament.team_matches SET " +
                "match_id = " + matchID +
                ",team_id = " + teamID +
                ",score = " + score +
                " WHERE id = " + teamMatchID + ";";
        dbQuery(sql, true);
        Main.teamMatches.clear();
        loadData("teamMatchesData");
    }

    public static void wipeSQL() {
        dbQueryTruncate("DELETE FROM team_matches;");
        dbQueryTruncate("DELETE FROM player;");
        dbQueryTruncate("DELETE FROM tournament_data;");
        dbQueryTruncate("DELETE FROM team;");
        dbQueryTruncate("DELETE FROM matches;");
        System.out.println("Data have been deleted");
    }

    //Custom function for truncating (static issue)
    public static void dbQueryTruncate(String query) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        // Open a connection to the DB
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            stmt.executeUpdate(query);
        } catch (Exception se) {
            se.printStackTrace();
        }
        return;
    }
}





