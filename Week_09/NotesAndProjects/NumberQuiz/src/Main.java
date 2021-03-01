import java.util.*;

public class Main {

    public static int number1;
    public static int number2;
    public static int answer;

    public static String userInput;
    public static int userAnswerInt;

    public static void main(String[] args) {
        startQuiz();
    }

    public static void startQuiz() {
        System.out.println("\nStarting quiz!");
        generateNumbers();
        sortNumbers();
        printExercise();
        readAnswer();
        calculateCorrectAnswer();
        evaluate();
    }

    public static void generateNumbers() {
        Random ran = new Random();

        number1 = ran.nextInt(10) + 1;
        number2 = ran.nextInt(10) + 1;
    }

    public static void sortNumbers() {
        if (number1 < number2) {
            int tmp = number1;
            number1 = number2;
            number2 = tmp;
        }
    }

    public static void printExercise() {
        System.out.println("What is "+ number1 +" - "+ number2 +"?");
    }

    public static void readAnswer() {
        Scanner scan = new Scanner(System.in);
        userInput = scan.nextLine();
    }

    public static void calculateCorrectAnswer() {
        answer = number1 - number2;
    }

    public static void evaluate() {
        try{
            userAnswerInt = Integer.parseInt(userInput);
        } catch (Exception e) {
            System.out.println("Input must be a number! Try again!");
            startQuiz();
            return;
        }

        if (answer == userAnswerInt)    System.out.println("Your answer is correct!");
        else    System.out.println("Your answer is wrong, the correct answer is: "+ answer);

        try     {Thread.sleep(2000);}
        catch (InterruptedException ex)     {Thread.currentThread().interrupt();}

        startQuiz();
    }
}
