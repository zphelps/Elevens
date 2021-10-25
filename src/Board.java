public class Board {

    Deck deck;
    Card[][] board;

    public Board() {
        deck = new Deck();
        deck.shuffle();

        board = new Card[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = deck.getNextCard();
            }
        }
    }

    /**
     * UNIMPLEMENTED
     * Makes a move based on player input.
     * @param input the user's raw input, in the form "29", "1T", "JQK", etc.
     * @return false if the move was invalid and was not made, true otherwise.
     */
    public boolean move (String input) {

        // 3-CARD REMOVAL ---------------------
        if (input.length() == 3) {

        }

        // 2-CARD REMOVAL ---------------------
        if (input.length() == 2) {

        }

        return false;

    }

    /**
     * Returns the number of cards left in the deck.
     * @return the number of cards left in the deck
     */
    public int cardsLeft() {
        return deck.cardsLeft();
    }

    /**
     * Assesses whether valid moves are left on the board.
     * @return true if moves are available; false otherwise
     */
    public boolean areMovesLeft() {

        // Indices for this are off by one from actual values.
        // Be careful when editing.
        int[] found = new int[13];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] != null) {
                    if (board[i][j].value == 10) found[9]++;
                    else if (board[i][j].value == 11) found[10]++;
                    else if (board[i][j].value == 12) found[11]++;
                    else if (board[i][j].value == 13) found[12]++;
                    else found[board[i][j].value-1]++;
                }
            }
        }

        // Two-pair checks
        for (int i = 0; i <= 4; i++) {
            if (found[i] > 0 && found[9-i] > 0) return true;
        }

        // Three-pair checks
        if (found[10] > 0 && found[11] > 0 && found[12] > 0) return true;

        return false;

    }

    /**
     * Returns a string representation of the board.
     * @return string representation of the board
     */
    public String toString() {

        StringBuilder out = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                out.append(board[i][j].rank);
                if (j != 2) out.append(" ");
            }
            if (i != 2) out.append("\n");
        }

        return out.toString();

    }

    /**
     * Resets the board to its initial state with a reshuffled deck.
     */
    public void reset() {
        deck.reset();
        deck.shuffle();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = deck.getNextCard();
            }
        }
    }

}