import java.util.*;

public class Main {
    public static void main(String[] args) {

        int[] inputArray = {2, 7, 9, 15, 6, 3, 10, 14, 13, 1, 4, 5, 12, 8};

        //bubbleSort(inputArray);
        //insertionSort(inputArray);
        //selectionSort(inputArray);
        quickSort(inputArray, 0, inputArray.length -1);
        System.out.println(Arrays.toString(inputArray));
    }

    private static void bubbleSort(int[] inputArray) {
        while(true) {
            boolean swapped = false;
            for (int i = 0; i < inputArray.length - 1; i++) {
                if (inputArray[i] > inputArray[i + 1]) {
                    int tempInt = inputArray[i];

                    inputArray[i] = inputArray[i + 1];
                    inputArray[i + 1] = tempInt;
                    swapped = true;
                }
            }
            if (swapped == false) {
                for (int i : inputArray) {
                    System.out.println(i);
                }
                break;
            }
        }
    }

    private static void insertionSort(int[] inputArray) {
        int holePosition;
        int valueToInsert;

        for (int i = 0; i < inputArray.length; i++){
            valueToInsert = inputArray[i];
            holePosition = i;

            while (holePosition > 0 && inputArray[holePosition - 1] > valueToInsert) {
                inputArray[holePosition] = inputArray[holePosition - 1];
                holePosition = holePosition - 1;
            }

            inputArray[holePosition] = valueToInsert;
        }
        for (int i : inputArray) {
            System.out.println(i);
        }
    }

    private static void selectionSort(int[] inputArray) {
        int inputSize = inputArray.length;

        for (int i = 0; i < inputSize - 1; i++) {
            int min = i;

            for (int j = i + 1; j < inputSize; j++) {
                if (inputArray[j] < inputArray[min]) {
                    min = j;
                }
            }

            if (min != i) {
                int tempInt = inputArray[i];

                inputArray[i] = inputArray[min];
                inputArray[min] = tempInt;
            }
        }
        for (int i : inputArray) {
            System.out.println(i);
        }
    }

    private static void quickSort(int[] arr, int start, int end){

        int partition = partition(arr, start, end);

        if(partition-1>start) {
            quickSort(arr, start, partition - 1);
        }
        if(partition+1<end) {
            quickSort(arr, partition + 1, end);
        }
    }

    private static int partition(int[] arr, int start, int end){
        int pivot = arr[end];

        for(int i=start; i<end; i++){
            if(arr[i]<pivot){
                int temp= arr[start];
                arr[start]=arr[i];
                arr[i]=temp;
                start++;
            }
        }

        int temp = arr[start];
        arr[start] = pivot;
        arr[end] = temp;

        return start;
    }
}
