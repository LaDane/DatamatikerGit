import java.io.*;
import java.util.Collections;
import java.util.concurrent.ExecutionException;

public class UIData {

    // Check for existing data
    public static void checkData(String dataType, String fileName) {
        if (loadDataInterface(dataType, fileName))
            Data.loadData(fileName);
        else if (dataType.equals("Founder"))
            createFounder();
        else if (dataType.equals("Tournament"))
            createTournament();
        else if (dataType.equals("Team"))
            createTeam();
        else if (dataType.equals("Match"))
            createMatch();
    }

    // Checks if data of inputted type and filename exists, returns true if user would like to load existing data
    public static boolean loadDataInterface(String dataType, String fileName) {
        File dataFile = new File(fileName);
        while (true) {
            if(new File(fileName).length() > 0) {
                String dataExists = "Previous "+ dataType +" data already exists.\nWould you like to load this "+
                        dataType +" data?\ny/n\n";
                String dataExistsInput = UI.getUserInput(dataExists);

                if (dataExistsInput.equals("y")) {
                    // User would like to load existing data
                    return true;
                }
                else if (dataExistsInput.equals("n")) {
                    // Existing data exists, but user would like to create new
                    deleteDataFile(dataType, dataFile);
                    return false;
                }
                else {
                    System.out.println("Response not recognized by system\n");
                }
            }
            else {
                // System found no data to load
                System.out.println("No "+ dataType +"data available to load!\n");
                return false;
            }
        }
    }

    // Deletes old txt files
    public static void deleteDataFile(String dataType, File dataFile) {
        try {
            FileWriter writer = new FileWriter(dataFile);
            writer.write("");
            writer.close();
            System.out.println("Deleted previous "+ dataType +" data");
        } catch (IOException e) {
            System.out.println("Failed to delete previous "+ dataType +" data");
        }
    }



    public static void loadDataIfExists(String fileName) {
        File dataFile = new File(fileName);
        if (dataFile.exists()) {
            Data.loadData(fileName);
        } else {
            System.out.println(fileName + "does not exist!");
        }
    }


    // FOUNDER
    // Creates a new founder and returns it + saves to txt file
    public static void createFounder() {
        String founderName = "Input the name of the tournament organizer / founder\n";
        String founderNameInput = UI.getUserInput(founderName);
        Founder founder = new Founder(founderNameInput);
        Data.saveData(null, founder, null, null, null);
        Main.currentFounder = founder;
    }


    // TOURNAMENT
    // Creates a new tournament and returns it + saves to txt file
    public static void createTournament() {
        // Tournament name
        String tournamentNameMsg = "Input name of tournament:\n";
        String tournamentNameInput = UI.getUserInput(tournamentNameMsg);

        // Tournament start time
        String tournamentStartTimeMsg = "Input time of day the tournament shall start\nEx. 18:\n";
        int tournamentStartTimeInt = stringToInt(tournamentStartTimeMsg);

        // Tournament day of month
        String tournamentDayOfMonthMsg = "Input which date of the month the tournament shall start\nEx. 28:\n";
        int tournamentDayOfMonthInt = stringToInt(tournamentDayOfMonthMsg);

        // Tournament month
        String tournamentMonthMsg = "Input which date of month the tournament will be held\nEx. 12:\n";
        int tournamentMonthInt = stringToInt(tournamentMonthMsg);

        // Tournament year
        String tournamentYearMsg = "Input which year the tournament will be held\nEx. 2021:\n";
        int tournamentYearInt = stringToInt(tournamentYearMsg);

        // Tournament due date
        String tournamentDueDateMsg = "Input date of which teams must have signed up\nEx. 08-04-2021:\n";
        String tournamentDueDateInput = UI.getUserInput(tournamentDueDateMsg);

        Tournament tournament = new Tournament(tournamentNameInput, tournamentStartTimeInt, tournamentDayOfMonthInt, tournamentMonthInt, tournamentYearInt, tournamentDueDateInput, 0);

        System.out.println("New tournament created!"+
                "\n\t Tournament Name: \t\t"+ tournamentNameInput +
                "\n\t Tournament StartTime: \t"+ tournamentStartTimeInt +
                "\n\t Tournament Date: \t\t"+ tournamentDayOfMonthInt +"-"+ tournamentMonthInt +"-"+ tournamentYearInt +
                "\n\t Tournament Due Date: \t"+ tournamentDueDateInput);

        Data.saveData(tournament, null, null, null, null);
        Main.currentTournament = tournament;
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

    // While loop used to make sure a user inputs a correct string that can be parsed to integer
    public static int stringToInt(String stringOutput) {
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

    // TEAM
    // Creates a new team and adds it to Main.currentTeams + saves to txt file
    public static void createTeam()  {
        // Team name
        String teamNameMsg = "Input name of team\n";
        String teamNameInput = UI.getUserInput(teamNameMsg);

        // Team player 1 name
        String player1NameMsg = "Input name of player 1 on team"+ teamNameInput +"\n";
        String player1NameInput = UI.getUserInput(player1NameMsg);

        // Team player 2 name
        String player2NameMsg = "Input name of player 2 on team"+ teamNameInput +"\n";
        String player2NameInput = UI.getUserInput(player2NameMsg);

        Team team = new Team(teamNameInput, player1NameInput, player2NameInput, 0, 0, 0, 0, false);

        System.out.println("New team created!"+
                "\n\t Team Name: \t\t"+ teamNameInput +
                "\n\t Team Player 1: \t"+ player1NameInput +
                "\n\t Team Player 2: \t"+ player2NameInput);

        Main.currentTeams.add(team);
        Main.activeTeams.add(team);
        Data.saveData(null, null, Main.currentTeams, null, null);
    }

    // MATCH
    public static void createMatch() {
        Main.matches.clear();

        if (Main.activeTeams.size() % 2 != 0) {
            System.out.println("Uneven amount of teams, fix yo shit");
        }
        else {
            Collections.shuffle(Main.activeTeams);     // Sorting teams randomly

            // if tournament starts at 20:00 = there are 4 hours left in day
            // if there is a total 16 teams = 8 matches
            if (24 - Main.currentTournament.getTournamentStartTime() <= Main.activeTeams.size() / 2) {
                System.out.println("Tournament will run over multiple days");
                Main.currentTournament.setTournamentEndDayOfMonth(Main.currentTournament.getTournamentStartDayOfMonth() + 1);
            } else {
                System.out.println("Tournament can be completed in one day");
                Main.currentTournament.setTournamentEndDayOfMonth(Main.currentTournament.getTournamentStartDayOfMonth());
            }

            int currentDayOfMonth = Main.currentTournament.getTournamentStartDayOfMonth();
            int matchTime = Main.currentTournament.getTournamentStartTime() - 1;

            int counter = 0;
            for (int i = 0; i < Main.activeTeams.size(); i += 2) {
                // reset match time if time is greater than 24. Than calculate new time based off how many matches are left
                matchTime++;
                if (matchTime > 24) {
                    matchTime = 24 - ((Main.activeTeams.size()/2)- counter);
                    currentDayOfMonth++;
                }
                counter++;
                int dayOfMonth = currentDayOfMonth;

                Match newMatch = new Match(Main.activeTeams.get(i).getName(), Main.activeTeams.get(i+1).getName(), matchTime, dayOfMonth);
                Main.matches.add(newMatch);
            }

            Data.saveData(null, null, null, Main.matches, null);
        }
    }
}
