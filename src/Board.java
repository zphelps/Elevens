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
        return false; // dummy
    }

    /**
     * Returns the number of cards left in the deck.
     * @return the number of cards left in the deck
     */
    public int cardsLeft() {
        return deck.cardsLeft();
    }

    /**
     * UNIMPLEMENTED
     * Assesses whether valid moves are left on the board.
     * @return true if moves are available; false otherwise
     */
    public boolean areMovesLeft() {
        return false; // dummy
    }

    /**
     * UNIMPLEMENTED
     * Returns a string representation of the board.
     * @return string representation of the board
     */
    public String toString() {
        return "dummy";
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