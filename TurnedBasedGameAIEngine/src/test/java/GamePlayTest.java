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
    RuleEngine ruleEngine;

    @BeforeEach
    public void Setup(){
       gameEngine = new GameEngine();
       ruleEngine = new RuleEngine();
    }

    @Test
    public void checkForRowWin(){
        Board board = gameEngine.start("TicTacToe");
        int moves[][] = new int[][]{{1,0},{1,1},{1,2}};
        int secondPlayerMoves[][] = new int[][]{{0,0},{0,1},{0,2}};
        playGame(board, moves, secondPlayerMoves);
        //make moves
        Assert.assertTrue(ruleEngine.getState(board).isOver());
        Assert.assertEquals(ruleEngine.getState(board).getWinner(), "X");
    }

    @Test
    public void checkForColWin(){
        Board board = gameEngine.start("TicTacToe");
        int moves[][] = new int[][]{{0,0},{1,0},{2,0}};
        int secondPlayerMoves[][] = new int[][]{{0,1},{0,2},{1,1}};
        playGame(board, moves,secondPlayerMoves);
        Scanner scanner = new Scanner(System.in);
        Assert.assertTrue(ruleEngine.getState(board).isOver());
        Assert.assertEquals(ruleEngine.getState(board).getWinner(), "X");

    }

    @Test
    public void checkForDiagWin(){
        Board board = gameEngine.start("TicTacToe");
        int moves[][] = new int[][]{{0,0},{1,1},{2,2}};
        int secondPlayerMoves[][] = new int[][]{{0,1},{0,2},{1,0}};
        playGame(board, moves,secondPlayerMoves);
        Scanner scanner = new Scanner(System.in);
        Assert.assertTrue(ruleEngine.getState(board).isOver());
        Assert.assertEquals(ruleEngine.getState(board).getWinner(), "X");
    }

    @Test
    public void checkForRevDiagWin(){
        Board board = gameEngine.start("TicTacToe");
        int moves[][] = new int[][]{{0,2},{1,1},{2,0}};
        int secondPlayerMoves[][] = new int[][]{{0,0},{0,1},{1,0}};
        playGame(board, moves,secondPlayerMoves);
        Scanner scanner = new Scanner(System.in);
        Assert.assertTrue(ruleEngine.getState(board).isOver());
        Assert.assertEquals(ruleEngine.getState(board).getWinner(), "X");
    }

    @Test
    public void checkForSecondPlaWin(){
        Board board = gameEngine.start("TicTacToe");
        int moves[][] = new int[][]{{1,0},{1,1},{2,0}};
        int secondPlayerMoves[][] = new int[][]{{0,0},{0,1},{0,2}};
        playGame(board, moves,secondPlayerMoves);
        Scanner scanner = new Scanner(System.in);
        Assert.assertTrue(ruleEngine.getState(board).isOver());
        Assert.assertEquals(ruleEngine.getState(board).getWinner(), "O");
    }

    public void playGame(Board board, int[][] firstPlayermoves, int[][] secondPlayermoves){
        int next = 0;
        while(!ruleEngine.getState(board).isOver()) {
            Player first = new Player("X");
            Player second = new Player("O");
            int row = firstPlayermoves[next][0];
            int col = firstPlayermoves[next][1];
            Move firstPlayerMove = new Move(new Cell(row, col), first); // Example move, replace with actual input logic
            gameEngine.move(board, firstPlayerMove);
            if(!ruleEngine.getState(board).isOver()){
                int sRow = secondPlayermoves[next][0];
                int sCol = secondPlayermoves[next][1];
                Move secondPlayerMove = new Move(new Cell(sRow,sCol),second);
                gameEngine.move(board, secondPlayerMove);
            }
            next++;
        }
    }
}
