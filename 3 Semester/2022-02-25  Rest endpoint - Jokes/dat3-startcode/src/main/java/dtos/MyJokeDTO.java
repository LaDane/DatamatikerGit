package dtos;

import java.util.ArrayList;
import java.util.List;

public class MyJokeDTO {

    String id;
    List<String> jokes = new ArrayList<>();

    public MyJokeDTO() {}

    public MyJokeDTO(ChuckDTO cd, DadDTO dd) {
        this.id = cd.getId() + "_" + dd.getId();
        this.jokes.add(cd.getValue());
        this.jokes.add(dd.getJoke());
    }

    @Override
    public String toString() {
        return "MyJokeDTO{" +
                "id='" + id + '\'' +
                ", jokes=" + jokes +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getJokes() {
        return jokes;
    }

    public void setJokes(List<String> jokes) {
        this.jokes = jokes;
    }

    public void addJoke(String joke) {
        this.jokes.add(joke);
    }
}
