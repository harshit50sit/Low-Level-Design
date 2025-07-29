package main.java.api;

import main.java.api.boards.TicTacToeBoard;
import main.java.api.gamestate.*;

public class GameEngine {

    public Board start(String type) {
        if(type.equals("TicTacToe")){
            return new TicTacToeBoard();
        }else{
            throw new IllegalArgumentException();
        }
    }

    public void move(Board board , Move move){
        if(board instanceof  TicTacToeBoard){
            board.move(move);
        }else{
            throw new IllegalArgumentException();
        }
    }


}


