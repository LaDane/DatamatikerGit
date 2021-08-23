package Exam07_Calculator;

public class Calculator {
    public static void calculate(int num1, int num2) {
        int[] intArray = {num1, num2};
        for (int i : intArray) {
            if (i < 1 || i > 50) {
                throw new IllegalArgumentException("Numbers are not in range (1 - 50)!");
            }
        }
        System.out.println("Inputted numbers are:\t"+ num1 +"\t&\t"+ num2);

        // Addition
        int sum = num1 + num2;
        System.out.println("\n\tAddition = \t\t\t"+ sum);

        // Subtraction
        int subtraction = num1 - num2;
        System.out.println("\tSubtraction = \t\t"+ subtraction);

        // Division
        int division = num1 / num2;
        System.out.println("\tDivision = \t\t\t"+ division);

        // Multiplication
        int multiplication = num1 * num2;
        System.out.println("\tMultiplication = \t"+ multiplication);
    }
}
