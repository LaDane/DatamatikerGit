import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {
    Player player1 = new Player("Hans", 30000);

    @Test
    public void doPlayerTransaction() {
        player1 = new Player("Hans", 30000);
        player1.doTransaction(null, -1200);
        int actual = player1.getBankAccount().getBalance();
        assertEquals(28800, actual);
    }
}