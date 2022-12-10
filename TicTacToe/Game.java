package TicTacToe;

import java.util.*;

public class Game {

    Player[] players;
    Board board;
    int turn;
    int noOfMoves;
    boolean gameOver;
    String zero;
    String cross;

    public Game(Player[] players, Board board) {

        this.players = players;
        this.board = board;
        this.turn = 0;
        this.noOfMoves = 0;
        this.gameOver = false;

        StringBuilder str1 = new StringBuilder();
        StringBuilder str2 = new StringBuilder();

        for (int t = 0; t < board.size; t++) {
            str1.append('O');
            str2.append('X');

        }

        zero = str1.toString();
        cross = str2.toString();

    }

    public void printBoard() {
        for (int p = 0; p < board.size; p++) {
            for (int r = 0; r < board.size; r++) {
                System.out.print(board.board[p][r] + " ");
            }
            System.out.println();
        }
    }

    public void play() {
        printBoard();
        int n = board.size;

        while (!gameOver) {
            noOfMoves++;
            int vidx = getIndex();
            int row = vidx / n;
            int col = vidx % n;

            board.board[row][col] = players[turn].getSymbol();

            if (noOfMoves >= n * n) {
                System.out.println("Game Draw");
                return;
            }

            if (noOfMoves >= 2 * n - 1 && checkMoveCombinations() == true) {
                gameOver = true;
                printBoard();
                System.out.println("Winner is : " + players[turn].getName());
                return;
            }

            turn = (turn + 1) % players.length;
            printBoard();
        }
    }

    public int getIndex() {

        while (true) {
            System.out.println("Player: " + players[turn].getName() + " give one position");
            Scanner in = new Scanner(System.in);

            int position = in.nextInt() - 1;
            int n = board.size;
            int row = position / n;
            int col = position % n;

            if (row < 0 || col < 0 || row >= n || col >= n) {
                System.out.println("Invalid Position. Please try again!");
                continue;
            }

            if (board.board[row][col] != '-') {
                System.out.println("Position has already taken. Please try again");
                continue;
            }

            return position;
        }

    }

    public boolean checkMoveCombinations() {

        int n = board.size;

        // check row wise
        for (int r = 0; r < n; r++) {
            StringBuilder sb = new StringBuilder();
            for (int p = 0; p < n; p++) {
                sb.append(board.board[r][p]);
            }

            String pattern = sb.toString();

            if (pattern.equals(zero) || pattern.equals(cross)) {
                return true;
            }

        }

        // check column wise

        for (int r = 0; r < n; r++) {
            StringBuilder sb = new StringBuilder();
            for (int p = 0; p < n; p++) {
                sb.append(board.board[p][r]);
           }

            String pattern = sb.toString();

            if (pattern.equals(zero) || pattern.equals(cross)) {
                return true;
            }
        }

        // check diagonals

        StringBuilder sb = new StringBuilder();

        int r = 0;
        int p = 0;
        while (r < n) {
            sb.append(board.board[r][p]);
            r++;
            p++;
        }

        String pattern = sb.toString();

        if (pattern.equals(zero) || pattern.equals(cross)) {
            return true;
        }

        // check anti diagonals

        sb = new StringBuilder();

        r = 0;
        p = n - 1;
        while (r < n) {
            sb.append(board.board[r][p]);
            r++;
            p--;
        }

        pattern = sb.toString();

        if (pattern.equals(zero) || pattern.equals(cross)) {
            return true;
        }

        return false;
    }

}
