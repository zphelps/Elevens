public class Card {

    int value;
    char rank;
    char suit; // Not used for Elevens, but important for a card class anyway

    public Card(int inValue, char inSuit) {

        value = inValue;
        suit = inSuit;


        if (2 <= value || 9 <= value) rank = (char)value;
        else if (value == 10) rank = 'T';
        else if (value == 11) rank = 'J';
        else if (value == 12) rank = 'Q';
        else if (value == 13) rank = 'K';
        else rank = 'A';
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
        String s = rank + suit + "";
        return s;
    }

}
