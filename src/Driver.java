import java.util.Locale;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {

        Scanner s1 = new Scanner(System.in);
        Board b1 = new Board();

        System.out.print("Enter game mode (1 = human, 2 = computer): ");
        int gameMode = s1.nextInt();
        s1.nextLine();

        if (gameMode==1) {
            while (true) {
                while (b1.cardsLeft() > 0 && b1.areMovesLeft()) {
                    System.out.println(b1);

                    String move = "";

                    while (true) {
                        System.out.print("Move? ");
                        move = s1.nextLine().toUpperCase();

                        if (!b1.move(move)) {
                            System.out.print("Illegal move, try again. ");
                        } else {
                            break;
                        }
                    }
                }

                if (b1.cardsLeft() == 0) {
                    System.out.println("Congratulations, you won!");
                } else if (!b1.areMovesLeft()) {
                    System.out.println(b1);
                    System.out.println("Sorry, there are no moves left.");
                }

                System.out.println("Play again? (y/N)");
                String playAgain = s1.nextLine().toUpperCase();

                if (playAgain.equals("N")) {
                    break;
                }
                b1.reset();
            }
        }
        else if (gameMode==2){
            while (true) {
                while (b1.cardsLeft() > 0 && b1.areMovesLeft()) {
                    System.out.println(b1);

                    //Computer Moves
                    //Implement method to get possible move in Board
                    //Return as a string

                }

                if (b1.cardsLeft() == 0) {
                    System.out.println("The Computer won!");
                } else if (!b1.areMovesLeft()) {
                    System.out.println(b1);
                    System.out.println("Sorry, there are no moves left.");
                }

                System.out.println("Play again? (y/N)");
                String playAgain = s1.nextLine().toUpperCase();

                if (playAgain.equals("N")) {
                    break;
                }
                b1.reset();
            }
        }

    }
}
