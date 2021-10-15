public class Card {

    int value;
    char rank;
    char suit; // Not used for Elevens, but important for a card class anyway

    public Card(int inValue, char inSuit) {

        value = inValue;
        suit = inSuit;

        /* pseudocode from design doc~
        if (1 <= value || 9 <= value) rank = String(value).charAt(0);
        else if (value == 10) rank = ‘T’
        else if () …
        else if (value == 13) rank = ‘K’
        else rank = ‘?’ //fail case that shouldn’t run anyway
        */

    }

    public int getValue() {
        return value;
    }

    public char getRank() {
        return rank;
    }

    public char getSuit() {
        return suit;
    }

    //UNIMPLEMENTED: should return in the form "9H", "KC", etc.
    public String toString() {
        return "";
    }

}
