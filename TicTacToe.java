// TIC TAC TOE WITH OLD MAN
import java.util.Scanner;

public class TicTacToe
{
    private final String[][] POS = { {" "," "," "}, {" "," "," "}, {" "," "," "} };
    private int currentPlayer = 1;
    private int userPlayer;
    private final String NPC_NAME;
    Scanner input = new Scanner(System.in);

    /**
     * Constructor for a game of Tic Tac Toe
     * @param npc       NPC that is playing with you
     */
    public TicTacToe(Friendly npc)
    {
        this.NPC_NAME = npc.GetName();
    }

    /**
     * Main method for the game of Tic Tac Toe. Loops until win/tie
     * @return          If the user won and that the game was not tied
     */
    public boolean Game()
    {
        /* DETERMINING WHO GOES FIRST */
        if ( (int)(Math.random() * 2) == 0) {
            this.userPlayer = 1; /* X (user is first) */
            System.out.println("You can go first. (You are X)");
        }
        else {
            this.userPlayer = 0; /* O (user is second) */
            System.out.println("I'll go first. (You are O)");
        }

        /* LOOPING UNTIL A PLAYER WINS OR TIED */
        do {
            // Prints board
            viewBoard();

            // Player or computer chooses a move
            enterMove();

            // Checking if anyone has won
            if (isPlayerWin()) {
                viewBoard(); // Display final board
                System.out.println(getPlayer() + " won!");
            }
            // Checking if game is tied
            else if (isTied())
            {
                viewBoard(); // Display final board
                System.out.println("Game tied!");
            }
            else {
                switchPlayer(); // Switching turns
            }
        } while (!isPlayerWin() && !isTied());

        return (this.currentPlayer == this.userPlayer && !isTied());
    }

    /**
     * Prints the tic tac toe board
     */
    private void viewBoard()
    {
        System.out.println("┌───┬───┬───┐");
        System.out.println("│ " + this.POS[0][0] + " │ " + this.POS[0][1] + " │ " + this.POS[0][2] + " │");
        System.out.println("├───┼───┼───┤");
        System.out.println("│ " + this.POS[1][0] + " │ " + this.POS[1][1] + " │ " + this.POS[1][2] + " │");
        System.out.println("├───┼───┼───┤");
        System.out.println("│ " + this.POS[2][0] + " │ " + this.POS[2][1] + " │ " + this.POS[2][2] + " │");
        System.out.println("└───┴───┴───┘");
    }

    /**
     * Determines who the current player is
     * @return      Name of current player
     */
    private String getPlayer()
    {
        if (this.currentPlayer == this.userPlayer) {
            return "You";
        }
        else {
            return this.NPC_NAME;
        }
    }

    /**
     * Updates the board with a player's move
     * @param x     x coordinate of move
     * @param y     y coordinate of move
     * @return      Validity of move
     */
    private boolean turn(int x, int y)
    {
        String symbol;
        if (this.currentPlayer == 0) {
            symbol = "O"; // O player currently
        }
        else {
            symbol = "X"; // X player currently
        }

        if (" ".equals(this.POS[x-1][y-1])) {
            // update board for player's move
            this.POS[x-1][y-1] = symbol;
            return true;
        }
        else {
            // selected position is already filled
            return false;
        }
    }

    /**
     * Switching turns between NPC and user
     */
    private void switchPlayer()
    {
        if (this.currentPlayer == 0) {
            this.currentPlayer = 1; // X turn
        }
        else {
            this.currentPlayer = 0; // O turn
        }
    }

    /**
     * Checks if a player has won the game
     * @return      If a player won
     */
    private boolean isPlayerWin()
    {
        boolean haveWinner = false; // default value

        // Checking rows
        for(int row = 0; row < 3; row++)
        {
            if( this.POS[row][0].equals(this.POS[row][1]) && this.POS[row][1].equals(this.POS[row][2]) && !" ".equals(this.POS[row][0]))
            {
                haveWinner = true;
                break;
            }
        }
        // Checking columns
        for(int col = 0; col < 3; col++)
        {
            if( this.POS[0][col].equals(this.POS[1][col]) && this.POS[1][col].equals(this.POS[2][col]) && !" ".equals(this.POS[0][col]))
            {
                haveWinner = true;
                break;
            }
        }
        // Checking diagonals
        if( this.POS[0][0].equals(this.POS[1][1]) && this.POS[1][1].equals(this.POS[2][2]) && !" ".equals(this.POS[0][0]))
        {
            haveWinner = true;
        }
        if( this.POS[2][0].equals(this.POS[1][1]) && this.POS[1][1].equals(this.POS[0][2]) && !" ".equals(this.POS[2][0]))
        {
            haveWinner = true;
        }

        return haveWinner;
    }

    /**
     * Checks if a game is tied (all spots are filled)
     * @return      If game is tied
     */
    private boolean isTied()
    {
        int count = 0;
        for (int row = 0; row < 3; row++)
        {
            for (int col = 0; col < 3; col++)
            {
                if (!this.POS[row][col].equals(" ")) {
                    count += 1;
                }
            }
        }
        return (count == 9 && !isPlayerWin());
    }

    /**
     * Making a move, user enters their move and NPC gets randomly
     * generated moves. Also checks that move is valid.
     */
    private void enterMove()
    {
        boolean valid, inRange;
        int x, y;

        do {
            /* PLAYER'S TURN */
            if (this.currentPlayer == this.userPlayer) {
                // user enters numbers for position
                System.out.println("Enter row: ");
                x = input.nextInt();
                System.out.println("Enter column: ");
                y = input.nextInt();
            }
            else /* COMPUTER'S TURN */
            {
                // randomly generate numbers for position
                x = (int)(Math.random() * 3) + 1; /* 1 to 4 */
                y = (int)(Math.random() * 3) + 1; /* 1 to 4 */
            }

            // ensuring that user input is a valid move
            inRange = (x >= 1 && x <= 3) && (y >= 1 && y <= 3);
            if (!inRange) {
                valid = false;
            }
            else {
                // ensuring that entered space is empty
                valid = turn(x,y);
            }
        } while (!valid);
    }
}