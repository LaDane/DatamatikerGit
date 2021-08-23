import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class    Data {

    public static void saveData(Tournament tournament, Founder founder, ArrayList<Team> teams, ArrayList<Match> matches, ArrayList<Match> oldMatches) {
        //FileWriter writer = null;
        try {
            String dataType = "";
            String fileName = "";
            String gottenData = "";
            if (tournament != null) {
                dataType = "Tournament";
                fileName = "tournamentData.txt";
                gottenData = getTournamentData(tournament);
            }
            if (founder != null) {
                dataType = "Founder";
                fileName = "founderData.txt";
                gottenData = getFounderData(founder);
            }
            if (teams != null) {
                dataType = "Teams";
                fileName = "teamsData.txt";
                gottenData = getTeamData(teams);
            }
            if (matches != null) {
                dataType = "Matches";
                fileName = "matchesData.txt";
                gottenData = getMatchData(matches);
            }
            if (oldMatches != null) {
                dataType = "Old Matches";
                fileName = "oldMatchesData.txt";
                gottenData = getMatchData(oldMatches);
            }

            FileWriter writer = new FileWriter(fileName);
            writer.write(gottenData);
            writer.close();
            System.out.println("Saved "+ dataType +" Data!");

        } catch (IOException e) {
            System.out.println("An error occurred while trying to save data!");
            e.printStackTrace();
        }
    }

    public static void loadData(String dataFile) {
        if (dataFile.equals("tournamentData.txt")) {
            File file = new File("tournamentData.txt");
            Scanner scanner = null;
            try {
                scanner = new Scanner(file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            if (scanner != null) {
                while (scanner.hasNextLine()) {
                    String[] colonSeparatedValues = scanner.nextLine().split(":");
                    String tournamentName = colonSeparatedValues[0];
                    int tournamentStartTime = Integer.parseInt(colonSeparatedValues[1]);
                    int tournamentStartDayOfMonth = Integer.parseInt(colonSeparatedValues[2]);
                    int tournamentMonth = Integer.parseInt(colonSeparatedValues[3]);
                    int tournamentYear = Integer.parseInt(colonSeparatedValues[4]);
                    String tournamentDueDate = colonSeparatedValues[5];
                    int amountOfTeams = Integer.parseInt(colonSeparatedValues[6]);
                    Main.currentTournament = new Tournament(tournamentName, tournamentStartTime, tournamentStartDayOfMonth, tournamentMonth, tournamentYear, tournamentDueDate, amountOfTeams);
                }
            }
            System.out.println("Tournament Data Successfully Loaded!");
        }

        if (dataFile.equals("founderData.txt")) {
            File file = new File("founderData.txt");
            Scanner scanner = null;
            try {
                scanner = new Scanner(file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            if (scanner != null) {
                while (scanner.hasNextLine()) {
                    String[] colonSeparatedValues = scanner.nextLine().split(":");
                    String founderName = colonSeparatedValues[0];
                    Main.currentFounder = new Founder(founderName);
                }
            }
            System.out.println("Founder Data Successfully Loaded!");
        }

        if (dataFile.equals("teamsData.txt")) {
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
                    String teamNameInput = colonSeparatedValues[0];
                    String player1 = colonSeparatedValues[1];
                    String player2 = colonSeparatedValues[2];
                    int points = Integer.parseInt(colonSeparatedValues[3]);
                    int pointScore = Integer.parseInt(colonSeparatedValues[4]);
                    int gamesWon = Integer.parseInt(colonSeparatedValues[5]);
                    int gamesPlayed = Integer.parseInt(colonSeparatedValues[6]);
                    boolean knockedOut = Boolean.parseBoolean(colonSeparatedValues[7]);
                    Main.currentTeams.add(new Team(teamNameInput, player1,player2, points, pointScore, gamesWon, gamesPlayed, knockedOut));
                    if (knockedOut==false){
                        Main.activeTeams.add(new Team(teamNameInput, player1,player2, points, pointScore, gamesWon, gamesPlayed, false));
                    }
                }
            }
            System.out.println("Teams Data Successfully Loaded!");
        }


        if (dataFile.equals("matchesData.txt") || dataFile.equals("oldMatchesData.txt")) {
            File file = new File("");
            if (dataFile.equals("matchesData.txt"))
                file = new File("matchesData.txt");

            if (dataFile.equals("oldMatchesData.txt"))
                file = new File("oldMatchesData.txt");

            Scanner scanner = null;
            try {
                scanner = new Scanner(file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            if (scanner != null) {
                while (scanner.hasNextLine()) {
                    String[] colonSeparatedValues = scanner.nextLine().split(":");
                    String team1 = colonSeparatedValues[0];
                    String team2 = colonSeparatedValues[1];
                    int matchTime = Integer.parseInt(colonSeparatedValues[2]);
                    int matchDayOfMonth = Integer.parseInt(colonSeparatedValues[3]);

                    if (dataFile.equals("matchesData.txt"))
                        Main.matches.add(new Match(team1,team2,matchTime,matchDayOfMonth));
                    if (dataFile.equals("oldMatchesData.txt"))
                        Main.oldMatches.add(new Match(team1,team2,matchTime,matchDayOfMonth));
                }
            }
            if (dataFile.equals("matchesData.txt"))
                System.out.println("Matches Data Successfully Loaded!");
            if (dataFile.equals("oldMatchesData.txt"))
                System.out.println("Old Matches Data Successfully Loaded!");
        }
    }

    public static String getTournamentData(Tournament tournament) {
        StringBuilder tData = new StringBuilder();

        String currentTournament = String.format("%s:%d:%d:%d:%d:%s:%d\n",
                tournament.getTournamentName(),
                tournament.getTournamentStartTime(),
                tournament.getTournamentStartDayOfMonth(),
                tournament.getTournamentEndDayOfMonth(),
                tournament.getTournamentYear(),
                tournament.getTournamentDueDate(),
                tournament.getAmountOfTeams());

        tData.append(currentTournament);
        return tData.toString();
    }

    public static String getFounderData(Founder founder) {
        StringBuilder fData = new StringBuilder();
        String currentFounder = String.format("%s\n", founder.getName());

        fData.append(currentFounder);
        return fData.toString();
    }

    public static String getTeamData(ArrayList<Team> teams) {
        StringBuilder tData = new StringBuilder();
        for (Team t : teams) {
            String teamData = String.format("%s:%s:%s:%d:%d:%d:%d:%b\n",
                    t.getName(),
                    t.getPlayer1(),
                    t.getPlayer2(),
                    t.getPoints(),
                    t.getPointScore(),
                    t.getGamesWon(),
                    t.getGamesPlayed(),
                    t.getTeamKnockedOut());
            tData.append(teamData);
        }
        return tData.toString();
    }

    public static String getMatchData(ArrayList<Match> matches) {
        StringBuilder mData = new StringBuilder();
        for (Match m : matches) {
            String matchData = String.format("%s:%s:%d:%d\n",
                    m.getTeam1(),
                    m.getTeam2(),
                    m.getMatchTime(),
                    m.getDayOfMonth());
            mData.append(matchData);
        }
        return mData.toString();
    }
}

