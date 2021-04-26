import java.io.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Collections;
import java.time.*;
import java.time.format.ResolverStyle;
// import java.util.concurrent.ExecutionException;

public class UIData {

    // Check for existing data
//    public static void checkData(String dataType, String fileName) {
//        if (loadDataInterface(dataType, fileName))
//            Data.loadData(fileName);
//        else if (dataType.equals("Tournament"))
//            createTournament();
//        else if (dataType.equals("Team"))
//            createTeam();
////        else if (dataType.equals("Match"))
////            createMatch();
//    }

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



//    public static void loadDataIfExists(String fileName) {
//        File dataFile = new File(fileName);
//        if (dataFile.exists()) {
//            Data.loadData(fileName);
//        } else {
//            System.out.println(fileName + "does not exist!");
//        }
//    }


    // FOUNDER
    // Creates a new founder and returns it + saves to txt file
//    public static void createFounder() {
//        String founderName = "Input the name of the tournament organizer / founder\n";
//        String founderNameInput = UI.getUserInput(founderName);
//        Founder founder = new Founder(founderNameInput);
//        Data.saveData(null, founder, null, null, null);
//        Main.currentFounder = founder;
//    }

    public static boolean isValidDate(String dateInput) {
        boolean valid = false;
        try {
            LocalDate.parse(dateInput,
                    DateTimeFormatter.ofPattern("uuuu-M-d")
                    .withResolverStyle(ResolverStyle.STRICT));
            valid = true;
        }
        catch (DateTimeParseException e) {
            e.printStackTrace();
            valid = false;
        }
        return valid;
    }

    public static boolean isValidTime(String timeInput) {
        boolean valid = false;
        try {
            LocalTime.parse(timeInput);
            valid = true;
        }
        catch (DateTimeParseException e) {
            valid = false;
        }
        return valid;
    }


    // TOURNAMENT
    // Creates a new tournament and returns it + saves to txt file
    public static void createTournament() {
        // Tournament name
        String tournamentNameMsg = "Input name of tournament:\n";
        String tournamentNameInput = UI.getUserInput(tournamentNameMsg);

        String tournamentFounderNameMsg = "Input name of founder:\n";
        String tournamentFounderNameInput = UI.getUserInput(tournamentFounderNameMsg);


        LocalTime tournamentStartTime;
        while (true) {
            String tournamentStartTimeMsg = "Input time of day the tournament shall start\nEx. 18:00\n";
            String userTimeInput = UI.getUserInput(tournamentStartTimeMsg);
            if (isValidTime(userTimeInput)) {
                tournamentStartTime = LocalTime.parse(userTimeInput);
                break;
            } else {
                System.out.println("\nWrong time format! Try again!\n");
            }
        }

        LocalDate tournamentStartDate;
        while (true) {
            String tournamentStartDateMsg = "Input date the tournament shall start\nEx. 2021-01-30\n";
            String userDateInput = UI.getUserInput(tournamentStartDateMsg);
            if (isValidDate(userDateInput)) {
                tournamentStartDate = LocalDate.parse(userDateInput);
                break;
            } else {
                System.out.println("\nWrong date format! Try again!\n");
            }
        }

        LocalDate tournamentDueDate;
        while (true) {
            String tournamentStartDateMsg = "Input date the tournament due date\nEx. 2021-01-30\n";
            String userDateInput = UI.getUserInput(tournamentStartDateMsg);
            if (isValidDate(userDateInput)) {
                tournamentDueDate = LocalDate.parse(userDateInput);
                break;
            } else {
                System.out.println("\nWrong date format! Try again!\n");
            }
        }

        Tournament tournament = new Tournament(tournamentNameInput, tournamentFounderNameInput, tournamentStartTime, tournamentStartDate, tournamentDueDate);

        System.out.println("New tournament created!"+
                "\n\t Tournament Name: \t\t"+ tournamentNameInput +
                "\n\t Tournament Founder: \t\t"+ tournamentFounderNameInput +
                "\n\t Tournament Start Time: \t"+ tournamentStartTime +
                "\n\t Tournament Start Date: \t\t"+ tournamentStartDate +
                "\n\t Tournament Due Date: \t"+ tournamentDueDate);

        // Data.saveData(tournament, null, null, null, null);
        // Main.currentTournament = tournament;
    }

    // Checks if the string inputted can be changed to integer, returns true if its possible
//    public static boolean checkParsePossible(String str) {
//        try {
//            Integer.parseInt(str);
//            return true;
//        } catch(Exception e) {
//            return false;
//        }
//    }


    // TEAM
    // Creates a new team and adds it to Main.currentTeams + saves to txt file
    public static void createTeam()  {
        // Team name
        String teamNameMsg = "Input name of team\n";
        String teamNameInput = UI.getUserInput(teamNameMsg);

        // TODO: GET TEAMID FROM SQL
        //Team team = new Team(-----TEAMID-----, teamNameInput, 0, 0, 0, 0, false);

        //System.out.println("New team created!"+
                //"\n\t Team Name: \t\t"+ teamNameInput);

        //Main.teams.add(team);
        //Data.saveData(null, null, Main.currentTeams, null, null);
    }

    // PLAYER
    public static void createPlayer() {
        if (Main.teams.size() == 0) {
            System.out.println("\nYou must create a team before you can create players!\n");
        }
        else {
            String playerNameMsg = "Input name of player\n";
            String playerNameInput = UI.getUserInput(playerNameMsg);

            for (int i = 0; i < Main.teams.size(); i++) {
                // TODO: ADD AMOUNT OF PLAYERS ON A TEAM
                System.out.println("\n"+ Main.teams.get(i).getID() +"\t - \t"+ Main.teams.get(i).getName() +" = TODO (ADD AMOUNT OF PLAYERS ON TEAM)");
            }
            String joinTeamMsg = "\nInput the ID of the team the player should join\n";
            String joinTeamInput = UI.getUserInput(joinTeamMsg);

            // TODO: CHECK THAT AMOUNT OF PLAYERS ON A TEAM + NEW PLAYER IS LESS THAN OR EQUAL TO 6

            // TODO: CREATE PLAYER - NEEDS PLAYERID FROM SQL AND TEAMID FROM SQL?
            // Player player = new Player(-----PLAYER ID------, playerNameInput, ----TEAM ID---- )
        }

    }

    // MATCH
//    public static void createMatch() {
//        Main.matches.clear();
//
//        if (Main.activeTeams.size() % 2 != 0) {
//            System.out.println("Uneven amount of teams, fix yo shit");
//        }
//        else {
//            Collections.shuffle(Main.activeTeams);     // Sorting teams randomly
//
//            // if tournament starts at 20:00 = there are 4 hours left in day
//            // if there is a total 16 teams = 8 matches
//            if (24 - Main.currentTournament.getTournamentStartTime() <= Main.activeTeams.size() / 2) {
//                System.out.println("Tournament will run over multiple days");
//                Main.currentTournament.setTournamentEndDayOfMonth(Main.currentTournament.getTournamentStartDayOfMonth() + 1);
//            } else {
//                System.out.println("Tournament can be completed in one day");
//                Main.currentTournament.setTournamentEndDayOfMonth(Main.currentTournament.getTournamentStartDayOfMonth());
//            }
//
//            int currentDayOfMonth = Main.currentTournament.getTournamentStartDayOfMonth();
//            int matchTime = Main.currentTournament.getTournamentStartTime() - 1;
//
//            int counter = 0;
//            for (int i = 0; i < Main.activeTeams.size(); i += 2) {
//                // reset match time if time is greater than 24. Than calculate new time based off how many matches are left
//                matchTime++;
//                if (matchTime > 24) {
//                    matchTime = 24 - ((Main.activeTeams.size()/2)- counter);
//                    currentDayOfMonth++;
//                }
//                counter++;
//                int dayOfMonth = currentDayOfMonth;
//
//                Match newMatch = new Match(Main.activeTeams.get(i).getName(), Main.activeTeams.get(i+1).getName(), matchTime, dayOfMonth);
//                Main.matches.add(newMatch);
//            }
//
//            Data.saveData(null, null, null, Main.matches, null);
//        }
//    }
}
