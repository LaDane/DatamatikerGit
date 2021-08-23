import java.util.ArrayList;
import java.util.Collections;

//Packages
import Exam01_ArrayList.*;
import Exam02_Book.*;
import Exam03_LawnMower.*;
import Exam04_Square.*;
import Exam05_Menu.*;
import Exam06_ProperCase.*;
import Exam07_Calculator.*;
import Exam08_Sorting.*;
import Exam09_LargeLetter.*;
import Exam10_StringCombiner.*;
import Exam11_Search.*;

public class Main {
    public static void main(String[] args) {

        // Proper Case took the longest to finish

        // 1 - ArrayList
//        ArrayList<String> arrStr = new ArrayList<String>();
//        arrStr.add("Bob");
//        arrStr.add("Timmy");
//        arrStr.add("Carl");
//        System.out.println(ArrLst.testExam1_ArrayList(arrStr, "Timmy"));

        // 2 - Books
//        Book b1 = new Book(5555, "Long John Silver", 1850);
//        Book b2 = new Book(8723, "Blue Whales", 1950);
//        Book b3 = new Book(2943, "Seven Years", 1970);
//        Library.books.add(b1);
//        Library.books.add(b2);
//        Library.books.add(b3);
//        System.out.println(Library.bookInLibrary(b3));

        // 3 - Lawn Mower
//        System.out.println(LawnMower.whenToCutGrass());

        // 4 - Square
//        Square.drawSquare(3, "[]");

        // 5 - Menu
//        System.out.println(MenuChoice.menuChoise());

        // 6 - Proper Case
//        System.out.println(ProperCase.properCase("I used to have SIX elephants in my room but THREE are gone now"));

        // 7 - Calculator
//        Calculator.calculate(10,5);

        // 8 - Sorting
//        Sorting.sorting();

        // 9 - Large Letter
//        LargeLetter.largeLetter();

        // 10 - String Combiner
//        String str1 = "There are five cars parked in my garage. ";
//        String str2 = "Three of them got stolen the other day";
//        System.out.println(StringCombiner.stringCombiner(str1, str2, 'a', 'e'));

        // 11 - Search
        String[] strArray = {"There", "used", "to", "be", "a", "little", "lamb"};
        System.out.println(Search.search(strArray, "lamb"));
    }
}


