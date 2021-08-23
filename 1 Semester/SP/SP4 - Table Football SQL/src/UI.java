import java.io.File;
import java.time.*;
import java.util.Collections;
import java.util.Scanner;

public class UI {

    // return a users input, takes a string that will be shown in terminal
    public static String getUserInput(String msg){
        System.out.print(msg);
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }

    public static void welcomeMessage() {
        System.out.println("\nWelcome to Table Football tournament manager!\n");

        boolean alwaysTrue = true;
        while(alwaysTrue) {
            String dataTypeMsg = "\nWould you like to use SQL? (y/n) ";
            String dataTypeInput = getUserInput(dataTypeMsg);

            if (dataTypeInput.equalsIgnoreCase("y")) {
                Main.useSQL = true;
                break;
            }
            else if (dataTypeInput.equalsIgnoreCase("n")) {
                Main.useSQL = false;
                break;
            }
            else {
                System.out.println("Invalid input. Try again!");
            }
        }

        while(alwaysTrue) {
            String loadDataMsg = "\nWould you like to load existing data? (y/n) ";
            String loadDataInput = getUserInput(loadDataMsg);

            if (loadDataInput.equalsIgnoreCase("y")) {
                Main.getIO().loadData("playerData");
                Main.getIO().loadData("teamsData");
                Main.getIO().loadData("tournamentData");
                Main.getIO().loadData("matchesData");
                Main.getIO().loadData("teamMatchesData");
                break;
            }
            else if (loadDataInput.equalsIgnoreCase("n")){
                System.out.println("\nData has been wiped and won't be loaded!\n");

                if (Main.useSQL) {
                    DBConnector.wipeSQL();
                }
                else {
                    UIData.deleteDataFile(new File("matchesData.txt"));
                    UIData.deleteDataFile(new File("playerData.txt"));
                    UIData.deleteDataFile(new File("teamMatchesData.txt"));
                    UIData.deleteDataFile(new File("teamsData.txt"));
                    UIData.deleteDataFile(new File("tournamentData.txt"));
                }
                break;
            }
            else {
                System.out.println("Invalid input. Try again!");
            }
        }
    }

    // MENU FUNCTIONS
    public static void menuMain() {
        while (true) {
            String menuMainStr = "\nInput number of what you would like to do\n" +
                    "\n\t1 - Create New Tournament" +
                    "\n\t2 - Add Team" +
                    "\n\t3 - Add Player " +
                    "\n\t4 - Show Statistics" +
                    "\n\t5 - Generate Matches" +
                    "\n\t6 - Start Next Tournament Stage\n";
            String menuMainInput = getUserInput(menuMainStr);
            switch (menuMainInput) {
                case "1" -> checkForExistingTournament();
                case "2" -> UIData.createTeam();
                case "3" -> UIData.createPlayer();
                case "4" -> menuTeamRankings();
                case "5" -> checkForExistingMatches();
                case "6" -> runTournament();
//                case "9" -> debugData();
                default -> System.out.println("Invalid input");
            }
        }
    }

    public static void checkForExistingTournament() {
        if (Main.tournament != null) {
            String tournamentConfirmMsg = "Are you sure you want to create a new tournament while one already exists? (y/n)";
            String tournamentConfirmInput = getUserInput(tournamentConfirmMsg);
            if (tournamentConfirmInput.equalsIgnoreCase("y")) {
                if (Main.useSQL) {
                    DBConnector.wipeSQL();
                } else {
                    UIData.deleteDataFile(new File("matchesData.txt"));
                    UIData.deleteDataFile(new File("playerData.txt"));
                    UIData.deleteDataFile(new File("teamMatchesData.txt"));
                    UIData.deleteDataFile(new File("teamsData.txt"));
                    UIData.deleteDataFile(new File("tournamentData.txt"));
                }
                UIData.createTournament();
            }
            else {
                System.out.println("u are retard");
            }
        } else {
            UIData.createTournament();
        }
    }

    public static void checkForExistingMatches() {
        int incompleteMatches=0;
        for (Match match : Main.matches) {
            if (match.getMatchDone() == false) {
                incompleteMatches++;
            }
        }

        if (incompleteMatches == 0) {
            UIData.createMatches();
        } else {
            String confirmDeleteMatches = "\nYou already have matches! These must be finished first!";
            System.out.println(confirmDeleteMatches);
        }
    }


    public static void menuTeamRankings() {
        while (true) {
            String menuTeamRankingsStr = "\nInput number of what you would like to do\n" +
                    "\n\t1 - Show All Teams" +
                    "\n\t2 - Show Team Placements / Rankings" +
                    "\n\t3 - Show All Matches" +
                    "\n\t4 - Show Next Match Time" +
                    "\n\t0 - Return To Main Menu\n";
            String menuTeamRankingsInput = getUserInput(menuTeamRankingsStr);

            switch (menuTeamRankingsInput) {
                case "1" -> showAllTeams();
                case "2" -> showTeamPlacements();
                case "3" -> showMatches();
                case "4" -> getNextMatchTime();
                case "0" -> {return;}
                default -> {
                    System.out.println("Invalid input");
                    menuTeamRankings();
                }
            }
        }
    }

    // USER FUNCTIONS
    public static void showAllTeams() {
        System.out.println("\nDisplaying all teams");
        for (int i = 0; i < Main.teams.size(); i++) {
            int indexTeamID = Main.teams.get(i).getID();

            StringBuilder indexTeamPlayerNames = new StringBuilder();
            for (Player player : Main.players) {
                if (player.getTeamID() == indexTeamID) {
                    indexTeamPlayerNames.append(" ").append(player.getPlayerName());
                }
            }

            System.out.println("Team "+ (i+1) +": \n"+
                    "\t\tTeam ID : "+ Main.teams.get(i).getID() +
                    "\t\tTeam Name : "+ Main.teams.get(i).getName() +
                    "\t\tPlayers : "+ indexTeamPlayerNames);
        }
    }

    public static void showTeamPlacements() {
        System.out.println("Displaying team placements (Sorted by points)");

        // Sorting first by player points, if same points, then sorts by player point score
        Main.teams.sort(new PointScoreSorter());
        Collections.reverse(Main.teams);

        for (int i = 0; i < Main.teams.size(); i++) {
            System.out.println("\nTeam ID: "+ Main.teams.get(i).getID() +
                    "\n\tTeam Name: "+ Main.teams.get(i).getName() +
                    "\n\tPoints: "+ Main.teams.get(i).getPoints() +
                    "\n\tPointScore: "+ Main.teams.get(i).getPointScore() +
                    "\n\tKnocked out: "+ Main.teams.get(i).getTeamKnockedOut());
        }
    }

    private static int[] getTeamIDsFromMatchID(int indexMatchID) {
        int[] indexTeamsIDs = new int[] {-1, -1};
        for (TeamMatches tm : Main.teamMatches) {
            if (tm.getMatchID() == indexMatchID) {
                if (indexTeamsIDs[0] == -1) {
                    indexTeamsIDs[0] = tm.getTeamID();
                } else {
                    indexTeamsIDs[1] = tm.getTeamID();
                }
            }
        }
        return indexTeamsIDs;
    }

    private static String[] getTeamNamesFromTeamIDs(int[] indexTeamsIDs) {
        String[] indexTeamNames = new String[] {"null", "null"};
        for (Team team : Main.teams) {
            if (team.getID() == indexTeamsIDs[0] && indexTeamNames[0].equals("null")) {
                indexTeamNames[0] = team.getName();
            }
            if (team.getID() == indexTeamsIDs[1] && indexTeamNames[1].equals("null")) {
                indexTeamNames[1] = team.getName();
            }
        }
        return indexTeamNames;
    }

    public static void showMatches() {
        if (Main.matches.size() == 0) {
            System.out.println("\nNo matches to show!\n");
            return;
        }

        for (int i = 0; i < Main.matches.size(); i++) {
            int indexMatchID = Main.matches.get(i).getMatchID();

            int[] indexTeamsIDs = getTeamIDsFromMatchID(indexMatchID);
            String[] indexTeamNames = getTeamNamesFromTeamIDs(indexTeamsIDs);

            String printStr = "Match ID: "+ indexMatchID +"\n\t"+
                    "Starts at: "+ Main.matches.get(i).getMatchStartTime() +
                    " on "+ Main.matches.get(i).getMatchStartDate() +
                    "\n\t"+ indexTeamNames[0] +" vs "+ indexTeamNames[1];

            System.out.println(printStr);
        }
    }

    public static void getNextMatchTime() {
        for (Match match : Main.matches) {
            if (!match.getMatchDone()) {
                Main.matchesNotDone.add(match);
            }
        }
        System.out.println("\nNext match will be at this date: " + Main.matchesNotDone.get(0).getMatchStartDate() + " and this time: " + Main.matchesNotDone.get(0).getMatchStartTime() + "\n");
    }


    // While loop used to make sure a user inputs a correct string that can be parsed to integer
    private static int stringToInt(String stringOutput) {
        int parsedInt = 0;

        while (true) {
            String userInput = UI.getUserInput(stringOutput);
            if (checkParsePossible(userInput)) {
                parsedInt = Integer.parseInt(userInput);
                break;
            } else {
                System.out.println("The input you have given is not recognized by the system! Try again");
            }
        }
        return parsedInt;
    }

    // Checks if the string inputted can be changed to integer, returns true if its possible
    public static boolean checkParsePossible(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch(Exception e) {
            return false;
        }
    }


    public static void runTournament() {
        if (Main.tournament == null) {
            System.out.println("You must create a tournament before starting it!");
        }
        Main.matchesNotDone.clear();
        for (Match match : Main.matches) {
            if (!match.getMatchDone()) {
                Main.matchesNotDone.add(match);
            }
        }

        if (Main.matchesNotDone.size() == 0)
            System.out.println("No matches are available");

        for (Match match : Main.matchesNotDone) {
            if (match.getMatchDone()) {
                System.out.println("Match is done");
                continue;                   // match already finished!
            }
            int indexMatchID = match.getMatchID();
            int[] indexTeamsIDs = getTeamIDsFromMatchID(indexMatchID);
            String[] indexTeamNames = getTeamNamesFromTeamIDs(indexTeamsIDs);
            String indexMatchStr = "\nMatch ID: " + indexMatchID +
                    "\nStarts at: " + match.getMatchStartTime() +
                    " on " + match.getMatchStartDate() +
                    "\t\t\tType -1 to exit Tournament stage" +
                    "\n\t" + indexTeamNames[0] + " vs " + indexTeamNames[1];
            System.out.println(indexMatchStr);


            String team1ScoreMsg = "\n\tInput score for " + indexTeamNames[0] + "\n";
            int team1Goals = stringToInt(team1ScoreMsg);
            if (team1Goals == -1) {
                return;
            }

            String team2ScoreMsg = "" +
                    "\tInput score for " + indexTeamNames[1] + "\n";
            int team2Goals = stringToInt(team2ScoreMsg);
            if (team2Goals == -1) {
                return;
            }

            int winnerTeamID;
            int winnerTeamPoints;
            int winnerTeamPointScore;

            int loserTeamID;
            int loserTeamPoints;
            int loserTeamPointScore;

            if (team1Goals >= team2Goals) {
                winnerTeamID = indexTeamsIDs[0];
                winnerTeamPoints = team1Goals;
                winnerTeamPointScore = team1Goals - team2Goals;

                loserTeamID = indexTeamsIDs[1];
                loserTeamPoints = team2Goals;
                loserTeamPointScore = team2Goals - team1Goals;
            } else {
                winnerTeamID = indexTeamsIDs[1];
                winnerTeamPoints = team2Goals;
                winnerTeamPointScore = team2Goals - team1Goals;

                loserTeamID = indexTeamsIDs[0];
                loserTeamPoints = team1Goals;
                loserTeamPointScore = team1Goals - team2Goals;
            }

            // Save existing team
            Team winnerTeamObject = Main.teams.get(0);      // throws error if not initialized
            Team loserTeamObject = Main.teams.get(0);
            for (Team team : Main.teams) {
                if (team.getID() == winnerTeamID) {
                    winnerTeamObject = team;
                }
                if (team.getID() == loserTeamID) {
                    loserTeamObject = team;
                }
            }

            int newWinnerPoints = winnerTeamObject.getPoints() + 2;
            int newWinnerPointScore = winnerTeamObject.getPointScore() + winnerTeamPointScore;
            int newWinnerGamesWon = winnerTeamObject.getGamesWon() + 1;
            int newWinnerGamesPlayed = winnerTeamObject.getGamesPlayed() + 1;

            int newLoserPoints = loserTeamObject.getPoints();
            int newLoserPointScore = loserTeamObject.getPointScore() + loserTeamPointScore;
            int newLoserGamesWon = loserTeamObject.getGamesWon();
            int newLoserGamesPlayed = loserTeamObject.getGamesPlayed() + 1;

            Main.getIO().saveExistingTeam(winnerTeamID, newWinnerPoints, newWinnerPointScore, newWinnerGamesWon, newWinnerGamesPlayed, false);
            Main.getIO().saveExistingTeam(loserTeamID, newLoserPoints, newLoserPointScore, newLoserGamesWon, newLoserGamesPlayed, true);

            // Save existing team matches
            TeamMatches winnerTeamMatch = Main.teamMatches.get(0);    // throws error if not initialized
            TeamMatches loserTeamMatch = Main.teamMatches.get(0);    // throws error if not initialized
            for (TeamMatches tm : Main.teamMatches) {
                if (tm.getMatchID() == indexMatchID && tm.getTeamID() == winnerTeamID) {
                    winnerTeamMatch = tm;
                }
                if (tm.getMatchID() == indexMatchID && tm.getTeamID() == loserTeamID) {
                    loserTeamMatch = tm;
                }
            }

            int newWinnerTeamMatchID = winnerTeamMatch.getID();
            int newLoserTeamMatchID = loserTeamMatch.getID();

            Main.getIO().saveExistingTeamMatches(newWinnerTeamMatchID, indexMatchID, winnerTeamID, winnerTeamPoints);
            Main.getIO().saveExistingTeamMatches(newLoserTeamMatchID, indexMatchID, loserTeamID, loserTeamPoints);

            // Save existing Match
            LocalTime newMatchStartTime = match.getMatchStartTime();
            LocalDate newMatchStartDate = match.getMatchStartDate();

            Main.getIO().saveExistingMatches(indexMatchID, newMatchStartTime, newMatchStartDate, true);
        }

        System.out.println("\nCurrent stage of tournament done!\n");
        int activeTeams = 0;
        Team remainingTeam = Main.teams.get(0);
        for (Team team : Main.teams) {
            if (team.getTeamKnockedOut() == false) {
                remainingTeam = team;
                activeTeams++;
            }
        }

        if (activeTeams == 1) {
            System.out.println("\uD83C\uDFC6 " + remainingTeam.getName() + " HAS WON THE '"+ Main.tournament.getTournamentName() +" \uD83C\uDFC6");
            String playerWinnerStr = "Congratulations to: \n\t";
            for (Player player : Main.players) {
                if (remainingTeam.getID() == player.getTeamID()) {
                    playerWinnerStr += player.getPlayerName() + " ";
                }
            }
            System.out.println(playerWinnerStr);
        } else {
            UIData.createMatches();
            runTournament();
        }
    }

}

