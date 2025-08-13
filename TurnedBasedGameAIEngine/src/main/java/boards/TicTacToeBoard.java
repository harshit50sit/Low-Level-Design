package main.java.boards;

import main.java.gamestate.Board;
import main.java.gamestate.Cell;
import main.java.gamestate.Move;

public class TicTacToeBoard implements Board {
    String cells[][] = new String[3][3];

    public String getCell(int row, int col) {
        return cells[row][col];
    }

    public void setCell(Cell cell, String symbol) {
        // Implementation to set the cell for the player
        if(cells[cell.getRow()][cell.getCol()] == null) {
            cells[cell.getRow()][cell.getCol()] = symbol;
        }else{
            System.out.println(this);
            throw new IllegalArgumentException("Cell is already occupied "+cell.getRow()+ " " +cell.getCol());
        }

    }

    @Override
    public String toString(){
        String result = "";
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                result += (cells[i][j] == null ? "-" : cells[i][j]) + " ";
                }
            result += "\n";
            }
        return result;
    }

    @Override
    public void move(Move move){
        setCell(move.getCell(), move.getPlayer().symbol());
    }

    public String getSymbol(int i, int j) {
        if (cells[i][j] == null) {
            return null;
        }
        return cells[i][j];
    }

    //Prototype design pattern
    @Override
    public TicTacToeBoard copy(){
        TicTacToeBoard ticTacToeBoard = new TicTacToeBoard();
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                ticTacToeBoard.cells[i][j] = cells[i][j];
            }
        }
        return ticTacToeBoard;
    }
}
