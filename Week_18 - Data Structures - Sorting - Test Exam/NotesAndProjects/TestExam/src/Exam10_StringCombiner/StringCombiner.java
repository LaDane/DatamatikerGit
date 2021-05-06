package Exam10_StringCombiner;

public class StringCombiner {
    public static String stringCombiner(String str1, String str2, char char1, char char2) {
        String[] strArray = {str1, str2};
        for (String s : strArray) {
            if (s.equals("") || s == null) {
                return "You must provide appropriate strings!";
            }
        }

        StringBuilder strComb = new StringBuilder();
        strComb.append(str1).append(str2);
        String str = strComb.toString();

        str = str.replace(char1, char2);
        return str;
    }
}
