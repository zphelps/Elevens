import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class Computer {

    public static String getMove(Board board) {
        ArrayList<String> cardsOnBoard = board.getCardsOnBoard();
        String move = "";
        if(cardsOnBoard.contains("J") && cardsOnBoard.contains("Q") && cardsOnBoard.contains("K")) {
            board.move("JQK");
            return "JQK";
        }
        else {
            cardsOnBoard.removeAll(Collections.singleton("J"));
            cardsOnBoard.removeAll(Collections.singleton("Q"));
            cardsOnBoard.removeAll(Collections.singleton("K"));
            for(int c1 = 0; c1 < cardsOnBoard.size(); c1++) {
                for(int c2 = c1+1; c2 < cardsOnBoard.size(); c2++) {
                    if(board.move("" + cardsOnBoard.get(c1) + "" + cardsOnBoard.get(c2))) {
                        move = "" + cardsOnBoard.get(c1) + cardsOnBoard.get(c2);
                        break;
                    }
                }
                if(!move.equals("")) {
                    break;
                }
            }
        }
        return move;
    }
}
