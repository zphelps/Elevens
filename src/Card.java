public class Card {

    int value;
    char rank;
    char suit; // Not used for Elevens, but important for a card class anyway

    public Card(int inValue, char inSuit) {

        value = inValue;
        suit = inSuit;

        if (2 <= value && value <= 9) rank = Integer.toString(value).charAt(0);
        else if (value == 10) rank = 'T';
        else if (value == 11) rank = 'J';
        else if (value == 12) rank = 'Q';
        else if (value == 13) rank = 'K';
        else if (value == 1) rank = 'A';
        else rank = '?';

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

    // Returns in the form "9H", "KC", etc.
    public String toString() {
        return "" + rank + suit;
    }

}
