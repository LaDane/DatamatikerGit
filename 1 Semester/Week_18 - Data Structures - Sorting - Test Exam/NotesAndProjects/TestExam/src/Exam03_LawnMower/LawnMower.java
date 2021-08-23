package Exam03_LawnMower;

import java.util.Scanner;

public class LawnMower {
    public static float grassGrowsPerDay = 0.8f;

    public static String whenToCutGrass() {
        float grassCurrent;
        float grassMax;

        while (true) {
            String grassCurrentLengthMsg = "\nHow tall is the grass now?\n";
            String grassCurrentLengthInput = getUserInput(grassCurrentLengthMsg);
            try {
                grassCurrent = Float.parseFloat(grassCurrentLengthInput);
                break;
            } catch (Exception e) {
                System.out.println("\nCannot convert input to decimal! Try again!\n");
            }
        }
        while (true) {
            String grassMaxLengthMsg = "\nWhat is the max length you want the grass to be?\n";
            String grassMaxLengthInput = getUserInput(grassMaxLengthMsg);
            try {
                grassMax = Float.parseFloat(grassMaxLengthInput);
                break;
            } catch (Exception e) {
                System.out.println("\nCannot convert input to decimal! Try again!\n");
            }
        }

        return grassCalculator(grassCurrent, grassMax);
    }

    public static String getUserInput(String msg){
        System.out.print(msg);
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }

    public static String grassCalculator(float currentLength, float maxLength) {
        float difference = maxLength - currentLength;
        float floatDays = difference / grassGrowsPerDay;
        int intDays = (int)Math.ceil(floatDays);

        String returnString = intDays +" days left until lawn has to be mowed!";
        return returnString;
    }
}
