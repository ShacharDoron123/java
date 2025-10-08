
public class Board {
    private char[][] bord = new char[3][3];

    public Board() {
        for(int i = 0; i < 3; ++i) {
            for(int j = 0; j < 3; ++j) {
                this.bord[i][j] = ' ';
            }
        }

    }

    public void printBoard() {
        System.out.println("  1   2   3");

        for(int i = 0; i < 3; ++i) {
            System.out.println("-------------");
            System.out.print(i + 1);

            for(int j = 0; j < 3; ++j) {
                System.out.print("| " + this.bord[i][j] + " ");
            }

            System.out.println("|");
        }

        System.out.println("-------------");
        System.out.println(" ");
        System.out.println(" ");
    }

    public boolean isMoveValid(int row, int col) {
        return this.bord[row][col] == ' ';
    }

    public boolean performMove(int row, int col, char player) {
        if (this.bord[row][col] == ' ') {
            this.bord[row][col] = player;
            return true;
        } else {
            return false;
        }
    }

    public boolean isWinner(char player) {
        for(int i = 0; i < 3; ++i) {
            if (this.bord[i][0] == player && this.bord[i][1] == player && this.bord[i][2] == player) {
                return true;
            }

            if (this.bord[0][i] == player && this.bord[1][i] == player && this.bord[2][i] == player) {
                return true;
            }
        }

        if (this.bord[0][0] == player && this.bord[1][1] == player && this.bord[2][2] == player) {
            return true;
        } else if (this.bord[0][2] == player && this.bord[1][1] == player && this.bord[2][0] == player) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isFull() {
        for(int i = 0; i < 3; ++i) {
            for(int j = 0; j < 3; ++j) {
                if (this.bord[i][j] == ' ') {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean isTie() {
        return this.isFull() && !this.isWinner('X') && !this.isWinner('O');
    }

    public int[][] getEmptycells() {
        int count = 0;

        for(int row = 0; row < 3; ++row) {
            for(int col = 0; col < 3; ++col) {
                if (this.bord[row][col] == ' ') {
                    ++count;
                }
            }
        }

        int[][] emptyCells = new int[count][2];
        int index = 0;

        for(int row = 0; row < 3; ++row) {
            for(int col = 0; col < 3; ++col) {
                if (this.bord[row][col] == ' ') {
                    emptyCells[index][0] = row;
                    emptyCells[index][1] = col;
                    ++index;
                }
            }
        }

        return emptyCells;
    }
}
