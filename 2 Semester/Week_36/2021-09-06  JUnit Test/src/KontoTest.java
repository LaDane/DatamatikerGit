import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KontoTest {

    Konto konto = new Konto("Nick", 100);

    @org.junit.jupiter.api.Test
    void getName() {
        assertEquals("Nick", konto.getName());
    }

    @org.junit.jupiter.api.Test
    void getBalance() {
        assertEquals(100, konto.getBalance());
    }

    @Test
    void name() {
        assertEquals(113, konto.insert(13));
    }

    @Test
    void testForNegativeNumber() {
        assertEquals(0, konto.insert(-1000));
    }

    @Test
    void testWithdraw() {
        assertEquals(0, konto.withdraw(100));
    }
}