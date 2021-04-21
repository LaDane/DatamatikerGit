import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PropertyTest {
    Player player1;
    Player player2;
    Board b;

    @Before
    public void setUp() throws Exception {
        Controller.io = new FileReader();
        String[] config = Controller.io.readFieldData("fields.csv");
        player1 = new Player("Hans", 30000);
        player2 = new Player("Grethe", 30000);
        b = new Board(config);
    }

    @Test
    public void getActionTest() {
        Controller.currentPlayer = player1;
        Field fp = b.getField(2);
        Action a = fp.getAction();

        String response= a.getResponseMsg();
        assertEquals("buy",a.getResponseMsg());
        Controller.processesResponse(a,fp);//money transaction and ownership update will happen

        Controller.currentPlayer = player2;
        fp = b.getField(2);
        a = fp.getAction();

        response = a.getResponseMsg();
        assertEquals("pay", response );

        //Player1 hits the field that he already owns, he will get no options to buy (null)");
        Controller.currentPlayer = player1;
        fp = b.getField(2);
        a = fp.getAction();
        response= a.getResponseMsg();
        assertEquals(null,response);
        Controller.processesResponse(a,fp);//money transaction and ownership update will happen
        assertEquals(null, response );

        //Player1 hits the last field he doesn't own in a series");
        fp = b.getField(4);
        a = fp.getAction();
        response = a.getResponseMsg();
        Controller.processesResponse(a,fp);//money transaction and ownership update will happen

       //" Player1 hits a field in a series where he has monopoly");
        fp = b.getField(4);
        a = fp.getAction();
        response = a.getResponseMsg();
        Controller.processesResponse(a,fp);//money transaction and ownership update will happen

        assertEquals("buy house",response);
    }
@After
    public void after(){
    b = null;
    assertNull(b);

}



}