package main.java.api;

import main.java.api.AIEngine;
import main.java.api.GameEngine;
import main.java.api.RuleEngine;
import main.java.api.gamestate.Board;
import main.java.api.gamestate.Cell;
import main.java.api.gamestate.Move;
import main.java.api.gamestate.Player;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // This is the entry point of the application.
        // You can initialize your game here, create players, and start the game loop.
        System.out.println("Welcome to the Tic Tac Toe Game!");

        GameEngine gameEngine = new GameEngine();
        AIEngine aiEngine = new AIEngine();
        RuleEngine ruleEngine = new RuleEngine();
        Board board = gameEngine.start("TicTacToe");
        int row,col;
        Scanner scanner = new Scanner(System.in);

        //make moves
        while(!ruleEngine.getState(board).isOver()) {
            Player computer = new Player("X");
            Player human = new Player("0");
            System.out.println("Make your move!");
            System.out.println(board);
            row = scanner.nextInt();
            col = scanner.nextInt();
            Move oppMove = new Move(new Cell(row,col), human); // Example move, replace with actual input logic
            gameEngine.move(board,oppMove);
            if(!ruleEngine.getState(board).isOver()){
                Move computerMove = aiEngine.suggestMove(computer,board);
                gameEngine.move(board, oppMove);
            }

        }
        System.out.println("GameResult: "+ruleEngine.getState(board));
        System.out.println(board);

        // Initialize board, game state, etc.
        // Start the game loop
    }
}
