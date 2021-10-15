import java.util.ArrayList;

public class Deck {

    ArrayList<Card> deck;

    public Deck() {
        reset(); // Populates the deck
    }

    /**
     * UNIMPLEMENTED
     * Shuffles the deck.
     */
    public void shuffle() {

    }

    /**
     * UNIMPLEMENTED
     * Resets and populates the deck.
     */
    public void reset() {
        deck = new ArrayList<>();
        // Populate deck
    }

    /**
     * UNIMPLEMENTED
     * Removes the next card from the top of the deck and returns it.
     * @return the next card from the top of the deck
     */
    public Card getNextCard() {
        return null;
    }

    /**
     * UNIMPLEMENTED
     * Returns the number of cards remaining in the deck.
     * @return the number of cards remaining in the deck.
     */
    public int cardsLeft() {
        return -1;
    }

}
