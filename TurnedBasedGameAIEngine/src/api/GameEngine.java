package api;

import boards.TicTacToeBoard;
import gamestate.*;

public class GameEngine {

    public Board start(String type) {
        if(type.equals("TicTacToe")){
            return new TicTacToeBoard();
        }else{
            throw new IllegalArgumentException();
        }
    }

    public void move(Board board, Player player, Move move){
        if(board instanceof  TicTacToeBoard){
            TicTacToeBoard board1 = (TicTacToeBoard) board;
            board1. setCell(move.getCell(), player.symbol());
        }else{
            throw new IllegalArgumentException();
        }
    }

    public GameResult isComplete(Board board){
        // Check if the game is complete
        if(board instanceof TicTacToeBoard){
            TicTacToeBoard board1 = (TicTacToeBoard) board;
            String firstCharacter = "-";
            // Check rows, columns, and diagonals for completion
            //row Complete
            boolean rowComplete = true;
            for(int i=0;i<3;i++){
                firstCharacter = board1.getCell(i,0);
                rowComplete = firstCharacter != null;
                if(firstCharacter != null) {
                    for (int j = 1; j < 3; j++) {
                        if (!firstCharacter.equals(board1.getCell(i, j))) {
                            rowComplete = false;
                            break;
                        }
                    }
                }
                if(rowComplete){
                    break;
                }
            }
            if(rowComplete) {
                return new GameResult(true,firstCharacter); // Return the result of the game
            }
            // Check columns
            boolean colComplete = true;
            for(int i=0;i<3;i++){
                //colComplete = true;
                firstCharacter = board1.getCell(0,i);
                colComplete = firstCharacter != null;
                if(firstCharacter != null){
                    for(int j=1; j<3; j++){
                        if(firstCharacter != null && !firstCharacter.equals(board1.getCell(j,i))){
                            colComplete = false;
                            break;
                        }
                    }
                }
                if(colComplete){
                    break;
                }
            }

            if(colComplete) {
                return new GameResult(true,firstCharacter); // Return the result of the game
            }

            // Check diagonals
            firstCharacter = board1.getCell(0,0);
            boolean diagComplete =  firstCharacter !=null;
            for(int i=1;i<3;i++){
                if(firstCharacter != null && !firstCharacter.equals(board1.getCell(i,i))) {
                    diagComplete = false;
                    break;
                }
            }

            if(diagComplete) {
                return new GameResult(true,firstCharacter); // Return the result of the game
            }

            //Check reverse diagonals
            firstCharacter = board1.getCell(0,2);
            boolean revDiagComplete = firstCharacter != null;
            for(int i=1;i<3;i++){
                if(firstCharacter != null && !firstCharacter.equals(board1.getCell(i,2-i))) {
                    revDiagComplete = false;
                    break;
                }
            }

            if(revDiagComplete) {
                return new GameResult(true,firstCharacter); // Return the result of the game
            }

            // If no completion found, return null
            int countOfFilledCells = 0;
            for(int i=0; i<3; i++){
                for(int j=1; j<3; j++){
                    if(board1.getCell(i,j) != null){
                        countOfFilledCells++;
                    }
                }
            }

            if(countOfFilledCells == 9) {
                return new GameResult(true, "-"); // All cells filled, but no winner
            }else{
                return new GameResult(false, "-"); // Game is still ongoing
            }
        }
        else{
            return new GameResult(false,"-");
        }
    }

    public Move suggestMove(Player computer, Board board){
        if(board instanceof TicTacToeBoard) {
            TicTacToeBoard board1 = (TicTacToeBoard) board;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board1.getCell(i, j) == null) {
                        return new Move(new Cell(i, j)); // Suggest the first empty cell
                    }
                }
            }
            throw new IllegalArgumentException();
        }else{
            throw new IllegalArgumentException();
        }
    }
}


