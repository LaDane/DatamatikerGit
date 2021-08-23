package Exam01_ArrayList;

import java.util.ArrayList;
import java.util.Collections;

public class ArrLst {
    public static boolean testExam1_ArrayList(ArrayList<String> arrStr, String str) {
        if (arrStr == null || str == null) {
            return false;
        }

        for (String indexStr : arrStr) {
            if (str.equals(indexStr)) {
                return false;
            }
        }

        arrStr.add(str);
        Collections.sort(arrStr, String.CASE_INSENSITIVE_ORDER);
        System.out.println(arrStr);
        return true;
    }
}
