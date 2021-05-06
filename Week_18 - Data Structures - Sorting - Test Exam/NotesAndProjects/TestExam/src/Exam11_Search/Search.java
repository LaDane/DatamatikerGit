package Exam11_Search;

public class Search {
    public static int search(String[] strArray, String str) {

        boolean strExists = false;
        int index = 0;

        for (int i = 0; i < strArray.length; i++) {
            if (strArray[i].equals(str)) {
                index = i;
                strExists = true;
            }
        }

        if (strExists) {
            return index;
        }
        else {
            // return -1;
            throw new IllegalArgumentException("The string provided does not exist in the sentence!");
        }
    }
}
