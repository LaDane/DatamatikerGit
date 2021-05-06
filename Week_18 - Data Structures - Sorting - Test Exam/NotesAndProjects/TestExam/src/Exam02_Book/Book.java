package Exam02_Book;

public class Book {
    int ISBN;
    String title;
    int releaseYear;

    public Book(int ISBN, String title, int releaseYear) {
        this.ISBN = ISBN;
        this.title = title;
        this.releaseYear = releaseYear;
    }

    public int getISBN() {return ISBN;}
    public void setISBN(int ISBN) {this.ISBN = ISBN;}

    public String getTitle() {return title;}
    public void setTitle(String title) {this.title = title;}

    public int getReleaseYear() {return releaseYear;}
    public void setReleaseYear(int releaseYear) {this.releaseYear = releaseYear;}

    @Override
    public String toString() {
        return "Book : \n\tISBN: \t\t\t"+ ISBN +"\n\tTitle: \t\t\t"+ title +"\n\tRelease Year: \t"+ releaseYear;
    }

    public boolean compareISBN(int i) {
        if (i == ISBN) {
            return true;
        }
        return false;
    }
}
