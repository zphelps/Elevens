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

        // 3-CARD REMOVAL ----------------------------------------------------------------------------------------------
        if (input.length() == 3) {

            // Input check ---------------------------------------------------------------------------------------------
            boolean jFound = false;
            boolean qFound = false;
            boolean kFound = false;

            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) == 'J') jFound = true;
                if (input.charAt(i)  == 'Q') qFound = true;
                if (input.charAt(i)  == 'K') kFound = true;
            }

            if (!(jFound && qFound && kFound)) return false;

            jFound = false;
            qFound = false;
            kFound = false;
            int[] jCoords = new int[]{-1, -1};
            int[] qCoords = new int[]{-1, -1};
            int[] kCoords = new int[]{-1, -1};

            // Search for cards ----------------------------------------------------------------------------------------
            // Using x and y to avoid confusion with different meanings of j
            for (int x = 0; x < 3; x++) {
                for (int y = 0; y < 3; y++) {
                    if (board[x][y] != null) {
                        if (board[x][y].rank == 'J') {
                            jCoords[0] = x;
                            jCoords[1] = y;
                            jFound = true;
                        }
                        if (board[x][y].rank == 'Q') {
                            qCoords[0] = x;
                            qCoords[1] = y;
                            qFound = true;
                        }
                        if (board[x][y].rank == 'K') {
                            kCoords[0] = x;
                            kCoords[1] = y;
                            kFound = true;
                        }
                    }
                }
            }

            if (!(jFound && qFound && kFound)) return false;

            // Make the move -------------------------------------------------------------------------------------------
            if (deck.cardsLeft() > 0) board[jCoords[0]][jCoords[1]] = deck.getNextCard();
            else board[jCoords[0]][jCoords[1]] = null;

            if (deck.cardsLeft() > 0) board[qCoords[0]][qCoords[1]] = deck.getNextCard();
            else board[qCoords[0]][qCoords[1]] = null;

            if (deck.cardsLeft() > 0) board[kCoords[0]][kCoords[1]] = deck.getNextCard();
            else board[kCoords[0]][kCoords[1]] = null;

            return true;

        }

        // 2-CARD REMOVAL ----------------------------------------------------------------------------------------------
        if (input.length() == 2) {
            // Input check ---------------------------------------------------------------------------------------------
            // Currently unsafe, should probably make it safe later!
            int value1 = -1;
            int value2 = -1;

            if (input.charAt(0) == 'T') value1 = 10;
            else if (input.charAt(0) == 'A') value1 = 1;
            else value1 = Integer.parseInt(input.substring(0, 1));

            if (input.charAt(1) == 'T') value2 = 10;
            else if (input.charAt(1) == 'A') value2 = 1;
            else value2 = Integer.parseInt(input.substring(1, 2));

            if (value1 + value2 != 11) return false;

            // Search for cards ----------------------------------------------------------------------------------------
            // Using x and y to avoid confusion with different meanings of j

            boolean v1Found = false;
            int[] v1Coords = new int[]{-1, -1};

            boolean v2Found = false;
            int[] v2Coords = new int[]{-1, -1};

            for (int x = 0; x < 3; x++) {
                for (int y = 0; y < 3; y++) {
                    if (board[x][y].value == value1) {
                        v1Coords[0] = x;
                        v1Coords[1] = y;
                        v1Found = true;
                    }
                    if (board[x][y].value == value2) {
                        v2Coords[0] = x;
                        v2Coords[1] = y;
                        v2Found = true;
                    }
                }
            }

            if (!v1Found || !v2Found) return false;

            // Make the move -------------------------------------------------------------------------------------------
            if (deck.cardsLeft() > 0) board[v1Coords[0]][v1Coords[1]] = deck.getNextCard();
            else board[v1Coords[0]][v1Coords[1]] = null;

            if (deck.cardsLeft() > 0) board[v2Coords[0]][v2Coords[1]] = deck.getNextCard();
            else board[v2Coords[0]][v2Coords[1]] = null;

            return true;

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
                if (board[i][j] != null) out.append(board[i][j].rank);
                else out.append("-");
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