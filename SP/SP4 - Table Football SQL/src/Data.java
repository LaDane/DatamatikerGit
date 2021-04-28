import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Data implements IO{
    public void loadData(String data) {
        if (data.equals("playerData")) {
            File file = new File("playerData.txt");
            Scanner scanner = null;
            try {
                scanner = new Scanner(file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            if (scanner != null) {
                while (scanner.hasNextLine()) {
                    String[] colonSeparatedValues = scanner.nextLine().split(":");
                    int playerID = Integer.parseInt(colonSeparatedValues[0]);
                    String playerName = colonSeparatedValues[1];
                    int teamID = Integer.parseInt(colonSeparatedValues[2]);
                    Main.players.add(new Player(playerID, playerName, teamID));
                }
            }
        }

        if (data.equals("teamsData")) {
            File file = new File("teamsData.txt");
            Scanner scanner = null;
            try {
                scanner = new Scanner(file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            if (scanner != null) {
                while (scanner.hasNextLine()) {
                    String[] colonSeparatedValues = scanner.nextLine().split(":");
                    int teamID = Integer.parseInt(colonSeparatedValues[0]);
                    String teamName = colonSeparatedValues[1];
                    int points = Integer.parseInt(colonSeparatedValues[2]);
                    int pointScore = Integer.parseInt(colonSeparatedValues[3]);
                    int gamesWon= Integer.parseInt(colonSeparatedValues[4]);
                    int gamesPlayed = Integer.parseInt(colonSeparatedValues[5]);
                    boolean knockedOut = Boolean.parseBoolean(colonSeparatedValues[6]);
                    Main.teams.add(new Team(teamID, teamName, points, pointScore, gamesWon, gamesPlayed, knockedOut));
                }
            }
        }
        if (data.equals("tournamentData")) {
            File file = new File("tournamentData.txt");
            Scanner scanner = null;
            try {
                scanner = new Scanner(file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            if (scanner != null) {
                while (scanner.hasNextLine()) {
                    String[] separatedValues = scanner.nextLine().split("\\|");
                    String name = separatedValues[0];

                    String founderName = separatedValues[1];

                    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    LocalDate tournamentStartDate = LocalDate.parse(separatedValues[2], dateFormatter);

                    DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
                    LocalTime tournamentStartTime = LocalTime.parse(separatedValues[3], timeFormatter);

                    LocalDate tournamentDueDate = LocalDate.parse(separatedValues[4], dateFormatter);
                    Tournament newTournament = new Tournament(name, founderName, tournamentStartTime, tournamentStartDate, tournamentDueDate);
                    Main.tournament = newTournament;
                }
            }
        }

        if (data.equals("matchesData")) {
            File file = new File("matchesData.txt");
            Scanner scanner = null;
            try {
                scanner = new Scanner(file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            if (scanner != null) {
                while (scanner.hasNextLine()) {
                    String[] separatedValues = scanner.nextLine().split(",");
                    int id = Integer.parseInt(separatedValues[0]);
                    LocalDate matchStartDate = LocalDate.parse(separatedValues[1]);
                    LocalTime matchStartTime = LocalTime.parse(separatedValues[2]);
                    boolean done = Boolean.parseBoolean(separatedValues[3]);
                    Match newMatch = new Match(id, matchStartTime, matchStartDate,done);
                    Main.matches.add(newMatch);
                }
            }
        }

        if (data.equals("teamMatchesData")) {
            File file = new File("teamMatchesData.txt");
            Scanner scanner = null;
            try {
                scanner = new Scanner(file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            if (scanner != null) {
                while (scanner.hasNextLine()) {
                    String[] colonSeparatedValues = scanner.nextLine().split(":");
                    int id = Integer.parseInt(colonSeparatedValues[0]);
                    int matchID = Integer.parseInt(colonSeparatedValues[1]);
                    int teamID = Integer.parseInt(colonSeparatedValues[2]);
                    int score = Integer.parseInt(colonSeparatedValues[3]);
                    TeamMatches newTeamMatch = new TeamMatches(id, matchID, teamID, score);
                    Main.teamMatches.add(newTeamMatch);
                }
            }
        }
    }

    public void savePlayer(String name, int teamID) {
        int ID = 1;
        int playerArraySize = Main.players.size();
        if (playerArraySize != 0) {
            Player lastPlayerInList = Main.players.get(playerArraySize - 1);
            ID = lastPlayerInList.getPlayerID() + 1;
        }

        StringBuilder playerDataSB = new StringBuilder();
        String playerDataStr = String.format("%d:%s:%d\n",
                ID,
                name,
                teamID);
        playerDataSB.append(playerDataStr);
        try {
            FileWriter writer = new FileWriter("playerData.txt", true);
            writer.write(playerDataStr);
            writer.close();

            Main.players.add(new Player(ID, name, teamID));
        } catch (IOException e) {
            System.out.println("An error occurred while trying to save data!");
            e.printStackTrace();
        }
    }

    public void saveNewTeam(String name) {
        int points=0;
        int pointScore = 0;
        int gamesWon = 0;
        int gamesPlayed = 0;
        boolean knockedOut = false;

        int ID = 1;
        int teamArraySize = Main.teams.size();
        if (teamArraySize != 0) {
            Team lastTeamInList = Main.teams.get(teamArraySize - 1);
            ID = lastTeamInList.getID() + 1;
        }

        StringBuilder teamData = new StringBuilder();
        String teamDataStr = String.format("%d:%s:%d:%d:%d:%d:%b\n",ID, name, points, pointScore, gamesWon, gamesPlayed, false);
        teamData.append(teamDataStr);

        try {
            FileWriter writer = new FileWriter("teamsData.txt", true);
            writer.write(teamDataStr);
            writer.close();

            Main.teams.add(new Team(ID, name, points, pointScore, gamesWon, gamesPlayed, false));
        } catch (IOException e) {
            System.out.println("An error occurred while trying to save data!");
            e.printStackTrace();
        }
    }

    public void saveExistingTeam(int teamID, int points, int pointScore, int gamesWon, int gamesPlayed, boolean knockedOut) {
        File file = new File("teamsData.txt");
        String teamName="";
        String oldTeamData="";
        String newTeamData="";
        Scanner scanner = null;
        for (Team team: Main.teams) {
            if (team.getID() == teamID) {
                teamName = team.getName();
            }
        }
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if (scanner != null) {
            while (scanner.hasNextLine()) {
                String line=scanner.nextLine();
                String[] colonSeparatedValues = line.split(":");
                if (teamID == Integer.parseInt(colonSeparatedValues[0])){
                    oldTeamData = line;
                    newTeamData = String.format("%d:%s:%d:%d:%d:%d:%b",teamID,teamName,points, pointScore,gamesWon,gamesPlayed,knockedOut);
                    modifyFile("teamsData.txt",oldTeamData,newTeamData);
                    break;
                }
            }
            Main.teams.clear();
            loadData("teamsData");
        }
    }

    public void saveTournament(String name, String founderName, LocalTime tournamentStartTime, LocalDate tournamentStartDate, LocalDate tournamentDueDate) {
        StringBuilder tournamentDataSB = new StringBuilder();
        String tournamentDataStr = name + "|" + founderName + "|" + tournamentStartDate + "|" + tournamentStartTime + "|" + tournamentDueDate;
        tournamentDataSB.append(tournamentDataStr);
        try {
            FileWriter writer = new FileWriter("tournamentData.txt", true);
            writer.write(String.valueOf(tournamentDataSB));
            writer.close();
            Tournament newTournament = new Tournament(name, founderName, tournamentStartTime, tournamentStartDate, tournamentDueDate);
            Main.tournament = newTournament;
        } catch (IOException e) {
            System.out.println("An error occurred while trying to save data!");
            e.printStackTrace();
        }
    }

    public void saveNewMatches(LocalTime matchStartTime, LocalDate matchStartDate, boolean done) {
        int ID = 1;
        int matchArraySize = Main.matches.size();
        if (matchArraySize != 0) {
            Match lastMatchesList = Main.matches.get(matchArraySize - 1);
            ID = lastMatchesList.getMatchID() + 1;
        }

        StringBuilder matchData = new StringBuilder();
        String matchDataStr = ID + "," + matchStartDate + "," + matchStartTime + "," + done +"\n";
        matchData.append(matchDataStr);

        try {
            FileWriter writer = new FileWriter("matchesData.txt", true);
            writer.write(matchDataStr);
            writer.close();

            Main.matches.add(new Match(ID, matchStartTime, matchStartDate,done));
        } catch (IOException e) {
            System.out.println("An error occurred while trying to save data!");
            e.printStackTrace();
        }
    }

    public void saveExistingMatches(int matchID, LocalTime matchStartTime, LocalDate matchStartDate, boolean done) {
        File file = new File("matchesData.txt");
        String oldMatchesData="";
        String newMatchesData="";
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if (scanner != null) {
            while (scanner.hasNextLine()) {
                String line=scanner.nextLine();
                String[] separatedValues = line.split(",");
                if (matchID == Integer.parseInt(separatedValues[0])){
                    oldMatchesData = line;
                    newMatchesData = matchID + "," + matchStartDate + "," + matchStartTime + "," + done;
                    modifyFile("matchesData.txt", oldMatchesData, newMatchesData);
                    break;
                }
            }
            Main.matches.clear();
            loadData("matchesData");
        }
    }

    public void saveNewTeamMatches(int matchID, int teamID, int score) {
        int ID = 1;
        int newMatchesArraySize = Main.teamMatches.size();
        if (newMatchesArraySize != 0) {
            TeamMatches lastTeamMatchesInList = Main.teamMatches.get(newMatchesArraySize - 1);
            ID = lastTeamMatchesInList.getID() + 1;
        }

        StringBuilder teamMatchesData = new StringBuilder();
        String teamMatchesDataStr = String.format("%d:%d:%d:%d\n",ID, matchID, teamID, score);
        teamMatchesData.append(teamMatchesDataStr);

        try {
            FileWriter writer = new FileWriter("teamMatchesData.txt", true);
            writer.write(teamMatchesDataStr);
            writer.close();

            Main.teamMatches.add(new TeamMatches(ID,matchID,teamID,score));
        } catch (IOException e) {
            System.out.println("An error occurred while trying to save data!");
            e.printStackTrace();
        }
    }

    public void saveExistingTeamMatches(int teamMatchID, int matchID, int teamID, int score) {
        File file = new File("teamMatchesData.txt");
        String oldTeamMatchesData="";
        String newTeamMatchesData="";
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if (scanner != null) {
            while (scanner.hasNextLine()) {
                String line=scanner.nextLine();
                String[] colonSeparatedValues = line.split(":");
                if (teamMatchID == Integer.parseInt(colonSeparatedValues[0])){
                    oldTeamMatchesData = line;
                    newTeamMatchesData = String.format("%d:%d:%d:%d",teamMatchID,matchID,teamID, score);
                    modifyFile("teamMatchesData.txt",oldTeamMatchesData,newTeamMatchesData);
                    break;
                }
            }
            Main.teamMatches.clear();
            loadData("teamMatchesData");
        }
    }
    static void modifyFile(String filePath, String oldString, String newString)
    {
        File fileToBeModified = new File(filePath);
        String oldContent = "";
        BufferedReader reader = null;
        FileWriter writer = null;
        try
        {
            reader = new BufferedReader(new FileReader(fileToBeModified));
            //Reading all the lines of input text file into oldContent
            String line = reader.readLine();
            while (line != null)
            {
                oldContent = oldContent + line + System.lineSeparator();
                line = reader.readLine();
            }
            //Replacing oldString with newString in the oldContent
            String newContent = oldContent.replaceAll(oldString, newString);
            //Rewriting the input text file with newContent
            writer = new FileWriter(fileToBeModified);
            writer.write(newContent);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                //Closing the resources
                reader.close();
                writer.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}