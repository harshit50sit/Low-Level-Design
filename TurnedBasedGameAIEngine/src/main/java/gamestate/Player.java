package main.java.gamestate;

public class Player {
    private String playerSymbol;

    public Player(String playerSymbol){
        this.playerSymbol = playerSymbol;
    }

    public String symbol(){
        return playerSymbol;
    }
}
