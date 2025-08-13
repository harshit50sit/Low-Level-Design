package main.java.api;

import main.java.gamestate.Board;
import main.java.boards.TicTacToeBoard;
import main.java.gamestate.*;

public class AIEngine {


    public Move suggestMove(Player computer, Board board){
        if(board instanceof TicTacToeBoard) {
            TicTacToeBoard board1 = (TicTacToeBoard) board;
            Move suggestion;
            int thredhold = 3; // Define the threshold for starting moves
            if(countMoves(board1) < thredhold){
               suggestion = getBasicMove(computer, board1);
            }else{
                suggestion = getSmartMove(computer, board1);
            }
            if(suggestion != null) {
                return suggestion;
            }
            throw new IllegalArgumentException();
        }else{
            throw new IllegalArgumentException();
        }
    }

    private Move getSmartMove(Player player, TicTacToeBoard board){
        RuleEngine ruleEngine = new RuleEngine();

        //victorias move
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board.getSymbol(i, j) != null) {
                    Move move = new Move(new Cell(i, j), player);
                    TicTacToeBoard boardCopy = board.copy();// Create a copy of the board to avoid modifying the original(Protoype design pattern)
                    boardCopy.move(move);
                    if(ruleEngine.getState(boardCopy).isOver()) {
                        return move;// Return the winning move
                    }
                }
            }
        }

        //Defensive move
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board.getSymbol(i, j) != null) {
                    Move move = new Move(new Cell(i, j), player.flip());
                    board.move(move);
                    if(ruleEngine.getState(board).isOver()) {
                        return new Move(new Cell(i,j),player);// Return the winning move
                    }
                }
            }
        }
        return getBasicMove(player, board); // If no winning or defensive move, suggest a basic move
    }

    private int countMoves(TicTacToeBoard board) {
        int count=0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board.getCell(i, j) != null) {
                    count++; // Found a move, so there are at least two moves
                }
            }
        }
        return count;
    }

    private static Move getBasicMove(Player computer, TicTacToeBoard board) {
            TicTacToeBoard board1 = (TicTacToeBoard) board;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board1.getCell(i, j) == null) {
                        return new Move(new Cell(i, j), computer); // Suggest the first empty cell
                    }
                }
            }
            return null;
        }
}
