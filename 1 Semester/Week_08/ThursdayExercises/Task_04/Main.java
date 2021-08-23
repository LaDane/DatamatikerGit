import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        int[] intArray = {3, 2, 7};
        String[] strArray = {"Hej", "med", "dig"};
        boolean[] boolArray = {true, false, true};

        printStrArray(strArray);
        System.out.println();

        sumArray(intArray);
        System.out.println();

        averageArray(intArray);
        System.out.println();

        sortedArray(intArray);
    }


    public static void printStrArray(String[] sArray) {
        for (int i = 0; i < sArray.length; i++) {
            System.out.println("String array element #"+ i + ":\t"+ sArray[i]);
        }
    }

    
    public static void sumArray(int[] iArray) {
        int total = 0;
        for (int i = 0; i < iArray.length; i++) {
            total += iArray[i];
        }
        System.out.println("Sum of int array: \t\t"+ total);
    }


    public static void averageArray(int[] iArray) {
        int total = 0;
        for (int i = 0; i < iArray.length; i++) {
            total += iArray[i];
        }
        total /= iArray.length;
        System.out.println("Average of int array: \t\t"+ total);        
    }


    public static void sortedArray(int[] iArray) {
        Arrays.sort(iArray);
        System.out.println("Sorted int array:");   

        for (int i = 0; i < iArray.length; i++) {
            System.out.println("Int array element #"+ i + ":\t\t"+ iArray[i]);
        }
    }
}