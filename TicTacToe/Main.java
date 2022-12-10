package TicTacToe;

public class Main {

    public static void main(String[] args) {
        Player player1 = new Player();
        player1.setName("A");
        player1.setSymbol('O');

        Player player2 = new Player();
        player2.setName("B");
        player2.setSymbol('X');

        Board board = new Board(3);

        Game game = new Game(new Player[] { player1,player2 }, board);

        game.play();
    }

}