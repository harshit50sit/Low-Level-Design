import api.GameEngine;
import gamestate.Board;
import gamestate.Cell;
import gamestate.Move;
import gamestate.Player;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // This is the entry point of the application.
        // You can initialize your game here, create players, and start the game loop.
        System.out.println("Welcome to the Tic Tac Toe Game!");

        GameEngine gameEngine = new GameEngine();
        Board board = gameEngine.start("TicTacToe");
        int row,col;
        Scanner scanner = new Scanner(System.in);

        //make moves
        while(!gameEngine.isComplete(board).isOver()) {
            Player computer = new Player("X");
            Player human = new Player("0");
            System.out.println("Make your move!");
            System.out.println(board);
            row = scanner.nextInt();
            col = scanner.nextInt();
            Move oppMove = new Move(new Cell(row,col)); // Example move, replace with actual input logic
            gameEngine.move(board, human, oppMove);
            if(!gameEngine.isComplete(board).isOver()){
                Move computerMove = gameEngine.suggestMove(computer,board);
                gameEngine.move(board, computer, oppMove);
            }

        }
        System.out.println("GameResult: "+gameEngine.isComplete(board));
        System.out.println(board);

        // Initialize board, game state, etc.
        // Start the game loop
    }
}
