package facades;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.ChuckDTO;
import dtos.DadDTO;
import dtos.MyJokeDTO;
import dtos.RenameMeDTO;
import entities.RenameMe;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

//import errorhandling.RenameMeNotFoundException;
import utils.EMF_Creator;

/**
 *
 * Rename Class to a relevant name Add add relevant facade methods
 */
public class FacadeExample {

    private static FacadeExample instance;
    private static EntityManagerFactory emf;
    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    
    //Private Constructor to ensure Singleton
    private FacadeExample() {}

    public static FacadeExample getFacadeExample(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new FacadeExample();
        }
        return instance;
    }

    public String readJoke(String urlString) {
        String jsonStr = "";
        try {
            URL url = new URL(urlString);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Accept", "application/json");
            con.setRequestProperty("User-Agent", "Poopsicle");
            try (Scanner scan = new Scanner(con.getInputStream())) {
                while (scan.hasNext()) {
                    jsonStr += scan.nextLine();
                }
            }
        } catch (IOException ioex) {
            System.out.println("Error: " + ioex.getMessage());
        }
        return jsonStr;
    }

    public ChuckDTO getChuckJoke() {
        String urlChuck = "https://api.chucknorris.io/jokes/random";
        return gson.fromJson(readJoke(urlChuck), ChuckDTO.class);
    }

    public DadDTO getDadJoke() {
        String urlDad = "https://icanhazdadjoke.com";
        return gson.fromJson(readJoke(urlDad), DadDTO.class);
    }

    public MyJokeDTO getMyJoke() {
        ChuckDTO cd = getChuckJoke();
        DadDTO dd = getDadJoke();
        return new MyJokeDTO(cd, dd);
    }

    public static void main(String[] args) {
        String url1 = "https://api.chucknorris.io/jokes/random";
        String url2 = "https://icanhazdadjoke.com";

        FacadeExample facade = getFacadeExample(EMF_Creator.createEntityManagerFactory());
        ChuckDTO chuckDTO = facade.getChuckJoke();
        System.out.println("\n" + chuckDTO.getValue());

        DadDTO dadDTO = facade.getDadJoke();
        System.out.println("\n" + dadDTO.getJoke());

        MyJokeDTO mjd = facade.getMyJoke();
        System.out.println("\n" + mjd.getJokes());
    }
}
