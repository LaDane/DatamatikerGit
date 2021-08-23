package Exam04_Square;

public class Square {
    public static void drawSquare(int size, String character) {
        size = Math.abs(size);
        if (size > 50) {
            System.out.println("Number is too large!");
        }
        for (int i = 0; i < size; i++) {
            System.out.println();
            for (int j = 0; j < size; j++) {
                System.out.print(" "+ character +" ");
            }
        }
    }
}
