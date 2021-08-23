package Exam;

import java.util.ArrayList;
import java.util.Random;

public class ExamMain {
    public static void main(String[] args) {
        ArrayList<WateringSystem> allSystems = new ArrayList<>();
        WateringSystem system = new WateringSystem(7);
        WateringSystem system2 = new WateringSystem(4);
        WaterChild waterChild = new WaterChild(5);

        allSystems.add(system);
        allSystems.add(system2);

        int amountOfDays = 11;
        int max = 20;
        int min = 1;

        Random r = new Random();
        for(int i = 1; i < amountOfDays; i++) {
            int randomInt = r.nextInt((max - min) + 1) + min;
            int randomInt2 = r.nextInt((max - min) + 1) + min;

            newDay(system, i, randomInt);
            newDay(system2, i, randomInt2);
        }

        waterChild.registerRain(2);
    }

    public static void newDay(WateringSystem system, int day, int rainML) {
        System.out.println("Day "+ day +"\t\train = "+ rainML +"\t\tDry days = "+ system.getDryDays());
        
        try {
            system.registerRain(rainML);
        }
        catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
