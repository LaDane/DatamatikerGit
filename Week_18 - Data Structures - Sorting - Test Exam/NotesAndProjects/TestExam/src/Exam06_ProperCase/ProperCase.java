package Exam06_ProperCase;

public class ProperCase {
    public static String properCase(String str) {
        String[] strArray = str.split(" ");

        StringBuilder returnStr = new StringBuilder();

        for (String s : strArray) {
            char[] charArray = s.toCharArray();

            // Checking if word is upper case
            boolean wordIsUpperCase = true;
            for (int i = 0; i < charArray.length; i++) {
                if (!Character.isUpperCase(charArray[i]))
                    wordIsUpperCase = false;
            }
            if (wordIsUpperCase) {
                returnStr.append(s).append(" ");
            }

            // Checking if word is longer than 3 letters
            if (s.length() > 3 && !wordIsUpperCase) {
                StringBuilder longerWord = new StringBuilder();
                for (int i = 0; i < charArray.length; i++) {
                    if (i == 0) {
                        char firstLetter = Character.toUpperCase(charArray[i]);
                        longerWord.append(firstLetter);
                    }
                    else {
                        longerWord.append(charArray[i]);
                    }
                }
                returnStr.append(longerWord).append(" ");
            }

            // Checking if word is less than 3 letters
            if (s.length() <= 3 && !wordIsUpperCase) {
                StringBuilder shorterWord = new StringBuilder();
                for (char c : charArray) {
                    char indexLetter = Character.toLowerCase(c);
                    shorterWord.append(indexLetter);
                }
                returnStr.append(shorterWord).append(" ");
            }
        }
        return returnStr.toString();
    }
}
