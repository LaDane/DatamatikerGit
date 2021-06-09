package Exam;

import java.util.ArrayList;

public class WateringSystem {

    private int dryDays = 0;
    private int maxDryDays;
    private ArrayList<Integer> rainyDays = new ArrayList<Integer>();

    public WateringSystem(int maxDryDays) {
        this.maxDryDays = maxDryDays;
    }

    public int getDryDays() {
        return dryDays;
    }

    public void registerRain(int rainML) throws IllegalArgumentException{
        if (rainML < 0) {
//            System.out.println("Cant have negative numbers");
            throw new IllegalArgumentException();
        }

        if (rainML < 5) {
            dryDays += 1;
            if (dryDays > 4) {
                turnOn();
            }
        }
        else {
            dryDays = 0;
        }

        rainyDays.add(rainML);
    }

    private void turnOn() {
        dryDays = 0;
        System.out.println("Turning on watering system");
    }
}
