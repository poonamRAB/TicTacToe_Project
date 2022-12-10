package TicTacToe;

public class Board {

    int size;
    char[][] board;

    public Board(int size) {
        this.size = size;

        board = new char[size][size];

        for (int r = 0; r < size; r++) {
            for (int p = 0; p < size; p++) {

                board[r][p] = '-';
            }
        }

    }
}