import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    ArrayList<Card> deck;

    public Deck() {
        reset(); // Populates the deck
    }

    public void shuffle() {
        Collections.shuffle(deck);
    }
    
    public void reset() {
        deck = new ArrayList<>();
        for (int i =1; i<=4; i++){
            for (int j = 1; j<=13; j++){
                char suit;
                if (i==1){
                    suit = 'D';
                }
                if (i==2){
                    suit = 'C';
                }
                if (i==3){
                    suit = 'S';
                }
                else{
                    suit = 'H';
                }
                Card c = new Card(j,suit);
                deck.add(c);
            }
        }
    }

    /**
     * Removes the next card from the top of the deck and returns it.
     * @return the next card from the top of the deck
     */
    public Card getNextCard() {
        Card c = deck.get(0);
        deck.remove(0);
        return c;
    }

    /**
     * Returns the number of cards remaining in the deck.
     * @return the number of cards remaining in the deck.
     */
    public int cardsLeft() {
        return deck.size();
    }

}
