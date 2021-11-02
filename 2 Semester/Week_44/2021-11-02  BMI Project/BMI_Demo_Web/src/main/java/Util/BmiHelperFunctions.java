package Util;

public class BmiHelperFunctions {

    public static Double calcBmi(Double height, Double weight) {
        return weight / (height * height) * 100 * 100;
    }

    public static String findCategory(Double bmi) {
        String category = "";
        if (bmi < 18.5) {
            category = "Undervægtig";
        } else if (bmi > 30) {
            category = "Svært overvægtig";
        } else if (bmi < 25) {
            category = "Normal vægtig";
        } else {
            category = "Overvægtig";
        }
        return category;
    }
}
