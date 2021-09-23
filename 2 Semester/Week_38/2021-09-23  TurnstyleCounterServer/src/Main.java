import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static int port = 8285;

    public static void main(String[] args) {
        boolean invalidTurnstylesAmount = true;
        int expectedTurnstyles = -1;

        while (invalidTurnstylesAmount) {
            String userInput = getUserInput("Input expected clients");
            expectedTurnstyles = parseStringInt(userInput);
            if (expectedTurnstyles > 0) {
                invalidTurnstylesAmount = false;
                break;
            }
            else {
                System.out.println("Invalid number!");
            }
        }
        EchoServer echoServer = new EchoServer(port, expectedTurnstyles);
        try {echoServer.startServer();}
        catch (IOException e) {e.printStackTrace();}
    }

    public static String getUserInput(String msg) {
        System.out.println(msg);
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }

    private static int parseStringInt(String value) {
        int valueInt = -1;
        try {valueInt = Integer.parseInt(value);}
        catch (NumberFormatException e) {return -1;}
        return valueInt;
    }
}
