import java.util.Arrays;

public class CardDeck {

    private int TEMP_MAX = 6; // This should be automatic
    private Card[] cards;

    public CardDeck() {
        cards = new Card[TEMP_MAX];
    }

    /**
     * Load a deck of cards from a csv
     */
    public CardDeck(String csvFilePath) {
        cards = loadCardsFromCsv(csvFilePath);
        shuffle();
    }

    public Card drawCard() {
        Card card = cards[0];
        cards[0] = null;
        Util.shiftArray(cards);
        cards = Arrays.copyOf(cards, cards.length - 1);
        return card;
    }

    public void putCardInBottomOfDeck(Card card) {
        cards = Arrays.copyOf(cards, cards.length + 1);
        cards[cards.length - 1] = card;
    }

    public Card[] loadCardsFromCsv(String path) {
        Card[] cards = new Card[TEMP_MAX];
        String[] cardStrings = Util.readCsv(path);
        for (int i = 0; i < cardStrings.length; i++) {
            cards[i] = new Card(cardStrings[i]);
        }
        return cards;
    }

    public void shuffle() {
        Card[] shuffledDeck = new Card[cards.length];
        int[] indices = Util.range(0, cards.length);
        Util.shuffleArray(indices);
        for (int i : indices) {
            shuffledDeck[indices[i]] = cards[i];
        }
        cards = shuffledDeck;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Card c : cards) {
            s.append(c).append("\n");
        }
        return s.toString();
    }

    public int numCards() {
        return cards.length;
    }
}
