import java.io.File;
import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;

public class UI {

    public static void welcomeMessage() {
        System.out.println("\nWelcome to Table Football tournament manager!\n");
    }

    // return a users input, takes a string that will be shown in terminal
    public static String getUserInput(String msg){
        System.out.print(msg);
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }

    // MENU FUNCTIONS
    public static void menuMain() {
        while (true) {
            String menuMainStr = "\nInput number of what you would like to do\n" +
                    "\n\t1 - Load Data" +
                    "\n\t2 - Create New Tournament" +
                    "\n\t3 - Generate Matches" +
                    "\n\t4 - Add Team" +
                    "\n\t5 - Show Teams/Rankings" +
                    "\n\t6 - Start Tournament\n";
            String menuMainInput = getUserInput(menuMainStr);
            switch (menuMainInput) {
                case "1" -> menuLoadData();
                case "2" -> menuTournament();
                case "3" -> UIData.checkData("Match", "matchesData.txt");
                case "4" -> UIData.createTeam();
                case "5" -> menuTeamRankings();
                case "6" -> runTournament();
                case "9" -> debugData();
                default -> System.out.println("Invalid input");
            }
        }
    }

    public static void menuLoadData() {

        while (true) {
            String menuLoadDataStr = "\nInput number of what you would like to do\n" +
                    "\n\t1 - Load All Existing Data" +
                    "\n\t2 - Load Founder Data" +
                    "\n\t3 - Load Tournament Data" +
                    "\n\t4 - Load Team Data" +
                    "\n\t5 - Load Match Data" +
                    "\n\t6 - Load Old Match Data" +
                    "\n\t0 - Return To Main Menu\n";
            String menuLoadDataInput = getUserInput(menuLoadDataStr);

            switch (menuLoadDataInput) {
                case "1" -> {
                    UIData.loadDataIfExists("founderData.txt");
                    UIData.loadDataIfExists("tournamentData.txt");
                    UIData.loadDataIfExists("teamsData.txt");
                    UIData.loadDataIfExists("matchesData.txt");
                    UIData.loadDataIfExists("oldMatchesData.txt");
                    return;
                }
                case "2" -> UIData.loadDataIfExists("founderData.txt");
                case "3" -> UIData.loadDataIfExists("tournamentData.txt");
                case "4" -> UIData.loadDataIfExists("teamsData.txt");
                case "5" -> UIData.loadDataIfExists("matchesData.txt");
                case "6" -> UIData.loadDataIfExists("oldMatchesData.txt");
                case "0" -> {return;}
                default -> System.out.println("Invalid input");
            }
        }
    }

    public static void menuTournament() {
        UIData.createFounder();
        UIData.createTournament();
        System.out.println("New founder and tournament created successfully!");
    }

    public static void menuTeamRankings() {
        while (true) {
            String menuTeamRankingsStr = "\nInput number of what you would like to do\n" +
                    "\n\t1 - Show All Teams" +
                    "\n\t2 - Show Team Placements / Rankings" +
                    "\n\t3 - Show All Matches" +
                    "\n\t4 - Show Old Matches" +
                    "\n\t5 - Show Next Match Time" +
                    "\n\t0 - Return To Main Menu\n";
            String menuTeamRankingsInput = getUserInput(menuTeamRankingsStr);

            switch (menuTeamRankingsInput) {
                case "1" -> showAllTeams();
                case "2" -> showTeamPlacements();
                case "3" -> showMatches(Main.matches);
                case "4" -> showMatches(Main.oldMatches);
                case "5" -> getNextMatchTime();
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
        System.out.println("Displaying all teams");
        for (int i = 0; i < Main.currentTeams.size(); i++) {
            System.out.println("Team "+ (i+1) +": \n"+
                    "\t\tTeam Name: "+ Main.currentTeams.get(i).getName() +
                    "\t\tPlayer 1: "+ Main.currentTeams.get(i).getPlayer1() +
                    "\t\tPlayer 2: "+ Main.currentTeams.get(i).getPlayer2() +
                    "\t\tKnocked Out: "+ Main.currentTeams.get(i).getTeamKnockedOut());
        }
    }

    public static void showTeamPlacements() {
        System.out.println("Displaying team placements (Sorted by points)");

        // Sorting first by player points, if same points, then sorts by player point score
        Main.currentTeams.sort(new PointScoreSorter());
        Collections.reverse(Main.currentTeams);

        for (int i = 0; i < Main.currentTeams.size(); i++) {
            System.out.println("\nTeam "+ (i+1) +": "+
                    "\n\tTeam Name: "+ Main.currentTeams.get(i).getName() +
                    "\n\tPlayer 1: "+ Main.currentTeams.get(i).getPlayer1() +
                    "\n\tPlayer 2: "+ Main.currentTeams.get(i).getPlayer2() +
                    "\n\tPoints: "+ Main.currentTeams.get(i).getPoints() +
                    "\n\tPointScore: "+ Main.currentTeams.get(i).getPointScore() +
                    "\n\tKnocked out: "+ Main.currentTeams.get(i).getTeamKnockedOut());
        }
    }

    public static void showMatches(ArrayList<Match> matchesToShow) {
        if (matchesToShow.size() == 0)
            System.out.println("\nNo matches to show!\n");

        for (int i = 0; i < matchesToShow.size(); i++) {
            System.out.println("Match #"+ (i+1) +"\n\t"+
                    "Starts at: "+ matchesToShow.get(i).getMatchTime() + ":00 " +
                    matchesToShow.get(i).getDayOfMonth() +"-"+
                    Main.currentTournament.getTournamentMonth() +"-"+
                    Main.currentTournament.getTournamentYear() +
                    "\n\t"+ matchesToShow.get(i).getTeam1() +" vs "+ matchesToShow.get(i).getTeam2());
        }
    }

    public static void getNextMatchTime() {
        System.out.println("\nNext match will be at: " + Main.matches.get(0).getMatchTime() + ":00\n");
    }

    public static void runTournament() {
        if (Main.matches.size() == 0) {
            System.out.println("No matches are available");
        }

        Main.activeTeams.clear();

        while (Main.matches.size() > 0) {
            Match currentMatch = Main.matches.get(0);

            Team team1 = findTeam(currentMatch.getTeam1());
            int team1GoalsInt = 0;
            Team team2 = findTeam(currentMatch.getTeam2());
            int team2GoalsInt = 0;

            // WINNER TEAM GOALS INPUT
            if (team1 != null) {
                String Team1Goals = "Input the amount of goals " + team1.getName() + " got: \n";
                team1GoalsInt = UIData.stringToInt(Team1Goals);
            }
            if (team2 != null) {
                String Team2Goals = "Input the amount of goals " + team2.getName() + " got: \n";
                team2GoalsInt = UIData.stringToInt(Team2Goals);
            }

            Team winnerTeam;
            int winnerTeamGoalsInt;
            Team loserTeam;
            int loserTeamGoalsInt;

            if (team1GoalsInt >= team2GoalsInt) {
                winnerTeam = team1;
                winnerTeamGoalsInt = team1GoalsInt;
                loserTeam = team2;
                loserTeamGoalsInt = team2GoalsInt;
            }
            else {
                winnerTeam = team2;
                winnerTeamGoalsInt = team2GoalsInt;
                loserTeam = team1;
                loserTeamGoalsInt = team1GoalsInt;
            }

            matchDone(winnerTeam,loserTeam,winnerTeamGoalsInt,loserTeamGoalsInt);
            Main.matches.remove(currentMatch);
            Main.oldMatches.add(currentMatch);
            Data.saveData(null, null, null, Main.matches, Main.oldMatches);
        }
        UIData.deleteDataFile("Matches", new File("matchesData.txt"));
        UIData.deleteDataFile("Teams", new File("teamsData.txt"));
        Data.saveData(null, null, Main.currentTeams, null, null);


        System.out.println("\nCURRENT STAGE OF TOURNAMENT DONE!\n");
        if (Main.activeTeams.size() == 1) {
            System.out.println("\uD83C\uDFC6 " +  Main.activeTeams.get(0).getName() +" HAS WON THE TOURNAMENT \uD83C\uDFC6");
        }
    }

    public static void matchDone(Team winnerTeam, Team loserTeam, int winnerGoals, int loserGoals) {
        // Increase games played and games won
        winnerTeam.setGamesPlayed(winnerTeam.getGamesPlayed() + 1);
        winnerTeam.setGamesWon(winnerTeam.getGamesWon() + 1);
        loserTeam.setGamesPlayed(loserTeam.getGamesPlayed() + 1);

        // Add points to teams
        winnerTeam.setPoints(winnerTeam.getPoints() + 2);
        winnerTeam.setPointScore(winnerTeam.getPointScore() + winnerGoals - loserGoals);
        loserTeam.setPointScore(loserTeam.getPointScore() + loserGoals - winnerGoals);

        // Knock loser out of tournament
        loserTeam.teamHasBeenKnockedOut();
        Main.activeTeams.add(winnerTeam);
    }

    public static Team findTeam(String name) {
        Team teamFound;
        for (int i = 0; i < Main.currentTeams.size(); i++) {
            if (Main.currentTeams.get(i).getName().equals(name)) {
                teamFound = Main.currentTeams.get(i);
                return teamFound;
            }
        }
        return null;
    }

    public static void debugData() {
        System.out.println("\nCURRENT TEAMS\n");
        for (int i = 0; i < Main.currentTeams.size(); i++) {
            System.out.println(Main.currentTeams.get(i).getName());
        }
        System.out.println("================");

        System.out.println("\nACTIVE TEAMS\n");
        for (int i = 0; i < Main.activeTeams.size(); i++) {
            System.out.println(Main.activeTeams.get(i).getName());
        }
        System.out.println("================");

        System.out.println("\nMATCHES\n");
        for (int i = 0; i < Main.matches.size(); i++) {
            System.out.println(Main.matches.get(i).getTeam1() + Main.matches.get(i).getTeam2());
        }
        System.out.println("================");

        System.out.println("\nOLD MATCHES\n");
        for (int i = 0; i < Main.oldMatches.size(); i++) {
            System.out.println(Main.oldMatches.get(i).getTeam1() + " vs " + Main.oldMatches.get(i).getTeam2());
        }
    }
}

