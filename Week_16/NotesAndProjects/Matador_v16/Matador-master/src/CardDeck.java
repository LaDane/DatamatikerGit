import java.util.Arrays;

public class CardDeck {
    private Card[] cards;

    public CardDeck( String[] cardStrings) {
        for (int i = 0; i < cardStrings.length; i++) {
            cards[i] = new Card(cardStrings[i]);
        }
        shuffle();
    }

    public Card drawCard() {
        Card card = cards[0];
        cards[0] = null;
        CardUtil.shiftArray(cards);
        cards = Arrays.copyOf(cards, cards.length - 1);
        return card;
    }

    public void putCardInBottomOfDeck(Card card) {
        cards = Arrays.copyOf(cards, cards.length + 1);
        cards[cards.length - 1] = card;
    }


    public void shuffle() {
        Card[] shuffledDeck = new Card[cards.length];
        int[] indices = CardUtil.range(0, cards.length);
        CardUtil.shuffleArray(indices);
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
