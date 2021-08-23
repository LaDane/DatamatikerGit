import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class WordGameTest {
//    WordGame game = new WordGame();

    @org.junit.jupiter.api.Test
    void repeatWord() {

        ArrayList<String> input = new ArrayList<>();
        input.add("Alphabet");
        input.add("BananaTree");
        input.add("Cars");

        ArrayList<String> output = WordGame.repeatWord(input, 2);

        // Assert
        assertEquals(6, output.size());
        assertEquals("BananaTree", output.get(2));
    }
}