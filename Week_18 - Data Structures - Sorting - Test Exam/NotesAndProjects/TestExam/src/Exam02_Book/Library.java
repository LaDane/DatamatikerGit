package Exam02_Book;

import java.util.ArrayList;

public class Library {
    public static ArrayList<Book> books = new ArrayList<Book>();

    public static boolean bookInLibrary(Book book) {
        for (Book indexBook : books) {
            if (book.getISBN() == indexBook.getISBN()) {
                return true;
            }
        }
        return false;
    }
}
