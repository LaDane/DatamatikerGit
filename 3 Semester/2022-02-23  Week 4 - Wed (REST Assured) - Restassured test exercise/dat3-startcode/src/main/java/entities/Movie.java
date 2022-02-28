package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;


@Entity
@Table(name = "movie")
@NamedQueries({
        @NamedQuery(name = "Movie.deleteAllRows", query = "DELETE from Movie"),
        @NamedQuery(name = "Movie.getAll", query = "SELECT m FROM Movie m"),
        @NamedQuery(name = "Movie.getByTitle", query = "SELECT m FROM Movie m WHERE m.title LIKE :title")
})
public class Movie implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "year")
    private int year;

    @Column(name = "title")
    private String title;

    @ElementCollection
    private List<String> actors;
//    private String[] actors; //

    public Movie() {

    }

    public Movie(int year, String title, List<String> actors) {
        this.year = year;
        this.title = title;
        this.actors = actors;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", year=" + year +
                ", title='" + title + '\'' +
                ", actors=" + actors +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getActors() {
        return actors;
    }

    public void setActors(List<String> actors) {
        this.actors = actors;
    }

    public void addActor(String actor) {
        this.actors.add(actor);
    }
}


//
//@Entity
//@NamedQuery(name = "RenameMe.deleteAllRows", query = "DELETE from Movie")
//public class Movie implements Serializable {
//
//    private static final long serialVersionUID = 1L;
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    public Movie() {
//    }
//
//    // TODO, delete this class, or rename to an Entity class that makes sense for what you are about to do
//    // Delete EVERYTHING below if you decide to use this class, it's dummy data used for the initial demo
//    private String dummyStr1;
//    private String dummyStr2;
//
//    public Movie(String dummyStr1, String dummyStr2) {
//        this.dummyStr1 = dummyStr1;
//        this.dummyStr2 = dummyStr2;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getDummyStr1() {
//        return dummyStr1;
//    }
//
//    public void setDummyStr1(String dummyStr1) {
//        this.dummyStr1 = dummyStr1;
//    }
//
//    public String getDummyStr2() {
//        return dummyStr2;
//    }
//
//    public void setDummyStr2(String dummyStr2) {
//        this.dummyStr2 = dummyStr2;
//    }
//}
