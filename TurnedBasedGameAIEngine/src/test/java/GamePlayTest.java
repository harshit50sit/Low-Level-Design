package test.java;

import main.java.api.AIEngine;
import main.java.api.GameEngine;
import main.java.api.RuleEngine;
import main.java.gamestate.Board;
import main.java.gamestate.Cell;
import main.java.gamestate.Move;
import main.java.gamestate.Player;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

public class GamePlayTest {

    GameEngine gameEngine;
    AIEngine aiEngine;
    RuleEngine ruleEngine;

    @BeforeEach
    public void Setup(){
       gameEngine = new GameEngine();
       aiEngine = new AIEngine();
       ruleEngine = new RuleEngine();
    }

    @Test
    public void checkForRowWin(){
        Board board = gameEngine.start("TicTacToe");
        int moves[][] = new int[][]{{1,0},{1,1},{1,2}};
        playGame(board, moves);
        //make moves
        Assert.assertTrue(ruleEngine.getState(board).isOver());
        Assert.assertEquals(ruleEngine.getState(board).getWinner(), "X");
    }

    @Test
    public void checkForColWin(){
        Board board = gameEngine.start("TicTacToe");
        int moves[][] = new int[][]{{0,0},{1,0},{2,0}};
        playGame(board, moves);
        Scanner scanner = new Scanner(System.in);
        Assert.assertTrue(ruleEngine.getState(board).isOver());
        Assert.assertEquals(ruleEngine.getState(board).getWinner(), "X");

    }

    @Test
    public void checkForDiagWin(){
        Board board = gameEngine.start("TicTacToe");
        int moves[][] = new int[][]{{0,0},{1,1},{2,2}};
        playGame(board, moves);
        Scanner scanner = new Scanner(System.in);
        Assert.assertTrue(ruleEngine.getState(board).isOver());
        Assert.assertEquals(ruleEngine.getState(board).getWinner(), "X");
    }

    @Test
    public void checkForRevDiagWin(){
        Board board = gameEngine.start("TicTacToe");
        int moves[][] = new int[][]{{0,2},{1,1},{2,0}};
        playGame(board, moves);
        Scanner scanner = new Scanner(System.in);
        Assert.assertTrue(ruleEngine.getState(board).isOver());
        Assert.assertEquals(ruleEngine.getState(board).getWinner(), "X");
    }

    @Test
    public void checkForSecondPlaWin(){
        Board board = gameEngine.start("TicTacToe");
        int moves[][] = new int[][]{{1,0},{1,1},{2,0}};
        playGame(board, moves);
        Scanner scanner = new Scanner(System.in);
        Assert.assertTrue(ruleEngine.getState(board).isOver());
        Assert.assertEquals(ruleEngine.getState(board).getWinner(), "O");
    }

    public void playGame(Board board, int[][] moves){
        int row,col;
        int next = 0;
        while(!ruleEngine.getState(board).isOver()) {
            Player computer = new Player("O");
            Player human = new Player("X");
            if(next<moves.length) {
                row = moves[next][0];
                col = moves[next][1];
                next++;
                Move oppMove = new Move(new Cell(row, col), human); // Example move, replace with actual input logic
                gameEngine.move(board, oppMove);
            }
            if(!ruleEngine.getState(board).isOver()){
                Move computerMove = aiEngine.suggestMove(computer,board);
                gameEngine.move(board, computerMove);
            }

        }
    }
}
