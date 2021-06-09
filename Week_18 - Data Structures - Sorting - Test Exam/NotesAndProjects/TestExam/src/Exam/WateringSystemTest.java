package Exam;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WateringSystemTest {

    @Test
    void registerRain() {
        WateringSystem system = new WateringSystem();

        system.registerRain(6);
        system.registerRain(7);

        assertEquals(0, system.getDryDays());
    }

    @Test
    void registerRain2() {
        WateringSystem system = new WateringSystem();

        system.registerRain(1);
        system.registerRain(2);
        system.registerRain(1);
        system.registerRain(1);

        assertEquals(4, system.getDryDays());
    }
}