import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


/**
 *  Tester at alle 40 Felter er blevet initialiserert
 */
public class BoardTest {
    Board b;
    Controller c;

    @Before
  public void setUp(){
        Controller.io = Controller.getIO();
        String[] config = Controller.io.readFieldData("fields.csv");
        b = new Board(config);
  }
    @Test
    public void getField() {
      for(int i = 0; i < Board.fields.length; i++){
           Field f = b.getField(i+1);
           assertEquals(i+1,f.id);
        }
    }
    @Test
    public void testReadingOfOwnerShipData(){
        c = new Controller();//instantierer her controlleren fordi jeg skal teste om gamedata bliver læst rigtigt
        Property f =(Property) Controller.board.getField(7);
        assertEquals(f.owner.getName(),"Tess");
    }
    @Test
    public void testSingleFieldData(){
       Property f =(Property)b.getField(10);
       assertEquals(f.getCost(),2400);

    }
    @After
    public void tearDown() throws Exception {
        b = null;
        c= null;
        assertNull(b);
        assertNull(c);
    }
}