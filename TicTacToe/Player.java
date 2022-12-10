package TicTacToe;

public class Player {

    private String name;
    private char symbol;

    // setter: name of the player
    public void setName(String name) {
        this.name = name;
    }

    // setter: symbol using by player (X,O)

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    // Getter
    public String getName() {
        return this.name;
    }

    // Getter

    public char getSymbol() {
        return this.symbol;
    }

}