
import java.util.Scanner;

public class Game {
    Scanner input;
    private Board board;
    private char currentPlayer;

    public Game() {
        this.input = new Scanner(System.in);
        this.board = new Board();
        this.currentPlayer = 'X';
    }

    public char playGame() {
        while(!this.board.isWinner('X') && !this.board.isWinner('O') && !this.board.isTie()) {
            if (this.currentPlayer == 'X') {
                int[][] emptyPlaces = this.board.getEmptycells();
                int place = (int)(Math.random() * (double)emptyPlaces.length);
                int row = emptyPlaces[place][0];
                int col = emptyPlaces[place][1];
                this.board.performMove(row, col, this.currentPlayer);
            } else {
                System.out.print("Enter row (1-3) and col (1-3): ");
                int row = this.input.nextInt() - 1;
                int col = this.input.nextInt() - 1;

                for(boolean valid = this.board.performMove(row, col, this.currentPlayer); !valid; valid = this.board.performMove(row, col, this.currentPlayer)) {
                    System.out.println("This move is not valid. Try again:");
                    row = this.input.nextInt() - 1;
                    col = this.input.nextInt() - 1;
                }
            }

            this.board.printBoard();
            this.currentPlayer = (char)(this.currentPlayer == 'X' ? 79 : 88);
        }

        if (this.board.isWinner('X')) {
            return 'X';
        } else if (this.board.isWinner('O')) {
            return 'O';
        } else if (this.board.isTie()) {
            return 'T';
        } else {
            return this.currentPlayer;
        }
    }
}
