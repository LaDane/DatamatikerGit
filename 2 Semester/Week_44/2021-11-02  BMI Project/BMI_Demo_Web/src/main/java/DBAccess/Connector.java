package DBAccess;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

/**
 The purpose of Connector is to...

 @author kasper
 */
public class Connector {

    private static String URL;
    private static String USERNAME;
    private static String PASSWORD;

    private static Connection singleton;

    public static void setConnection( Connection con ) {
        singleton = con;
    }

    public static Connection connection() throws ClassNotFoundException, SQLException {
        if ((singleton == null) || singleton.isClosed()) {
            setDBCredentials();
            Class.forName( "com.mysql.cj.jdbc.Driver" );
            singleton = DriverManager.getConnection( URL, USERNAME, PASSWORD );
        }
        return singleton;
    }

    public static void setDBCredentials() {
        String deployed = System.getenv("DEPLOYED");
        if (deployed != null){
            // Prod: hent variabler fra setenv.sh i Tomcats bin folder
            URL = System.getenv("JDBC_CONNECTION_STRING");
            USERNAME = System.getenv("JDBC_USER");
            PASSWORD = System.getenv("JDBC_PASSWORD");
        } else {
            // Localhost
            URL = "jdbc:mysql://localhost:3306/useradmin?serverTimezone=CET&useSSL=false";
            USERNAME = "root";
            PASSWORD = getSecret();
        }
    }

    private static String getSecret() {
        String secretWord = "file not found";
        try {
            Scanner scanner = new Scanner(new File("D:\\Skole\\Datamatiker\\DatamatikerGit\\2 Semester\\Week_44\\2021-11-02  BMI Project\\BMI_Demo_Web\\src\\main\\java\\DBAccess\\password.secret"));
            secretWord = scanner.nextLine();
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return secretWord;
    }

}
