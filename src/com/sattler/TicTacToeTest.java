package com.sattler;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

public class TicTacToeTest {

    @Test   //check if array gets filled with empty spaces
    public void testNewGameBoard(){
        char[][] expectedGameBoard = {
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '},
        };
        char[][] testBoard = new char[3][3];

        TicTacToeMethods.newGameBoard(testBoard);
        assertTrue(Arrays.deepEquals(expectedGameBoard, testBoard));
    }

    @Test   //Check correct positioning of PlayerMove
    public void testSetChoicePLayer() {
        char[][] actualBoard = {
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '},
        };
        char[][] expectedBoard = {
                {' ', ' ', ' '},
                {' ', 'X', ' '},
                {' ', ' ', ' '},
        };

        int playerPos = 5;

        TicTacToeMethods.setChoice(actualBoard, playerPos, "player");
        assertTrue(Arrays.deepEquals(actualBoard, expectedBoard));
    }

    @Test   //Check correct positioning of CpuMove
    public void testSetChoiceCpu(){
        char[][] actualBoard = {
                {' ', ' ', ' '},
                {' ', 'X', ' '},
                {' ', ' ', ' '},
        };
        char[][] expectedBoard = {
                {' ', ' ', 'O'},
                {' ', 'X', ' '},
                {' ', ' ', ' '},
        };

        int cpuPos = 3;

        TicTacToeMethods.setChoice(actualBoard, cpuPos, "cpu");
        assertTrue(Arrays.deepEquals(actualBoard, expectedBoard));

    }

//PLAYER WINNING CONDITIONS
    @Test   //check winning Conditions Player Top Row
    public void testCheckWinPlayerRowTop() {
        char[][] board = new char[3][3];
        int pos = board.length * board[0].length;
        String playerWin = "You win!";
        Main.playerPositions.clear();
        Main.playerPositions.add(1);
        Main.playerPositions.add(2);
        Main.playerPositions.add(3);
        String result = TicTacToeMethods.checkWin(board, pos);
        assertEquals(result, playerWin);
        Main.playerPositions.clear();
    }

    @Test   //check winning Conditions Player Bottom Row
    public void testCheckWinPlayerRowBot() {
        char[][] board = new char[3][3];
        int pos = board.length * board[0].length;
        String playerWin = "You win!";
        Main.playerPositions.clear();
        Main.playerPositions.add(7);
        Main.playerPositions.add(8);
        Main.playerPositions.add(9);
        String result = TicTacToeMethods.checkWin(board, pos);
        assertEquals(result, playerWin);
        Main.playerPositions.clear();
    }

    @Test   //check winning Conditions Player Left Column
    public void testCheckWinPlayerColLeft() {
        char[][] board = new char[3][3];
        int pos = board.length * board[0].length;
        String playerWin = "You win!";
        Main.playerPositions.clear();
        Main.playerPositions.add(1);
        Main.playerPositions.add(4);
        Main.playerPositions.add(7);
        String result = TicTacToeMethods.checkWin(board, pos);
        assertEquals(result, playerWin);
        Main.playerPositions.clear();
    }

    @Test   //check winning Conditions Player Right Column
    public void testCheckWinPlayerColRight() {
        char[][] board = new char[3][3];
        int pos = board.length * board[0].length;
        String playerWin = "You win!";
        Main.playerPositions.clear();
        Main.playerPositions.add(3);
        Main.playerPositions.add(6);
        Main.playerPositions.add(9);
        String result = TicTacToeMethods.checkWin(board, pos);
        assertEquals(result, playerWin);
        Main.playerPositions.clear();
    }

    @Test   //check winning Conditions Player Cross Top to Bottom
    public void testCheckWinPlayerCrossTopBot() {
        char[][] board = new char[3][3];
        int pos = board.length * board[0].length;
        String playerWin = "You win!";
        Main.playerPositions.clear();
        Main.playerPositions.add(1);
        Main.playerPositions.add(5);
        Main.playerPositions.add(9);
        String result = TicTacToeMethods.checkWin(board, pos);
        assertEquals(result, playerWin);
        Main.playerPositions.clear();
    }

    @Test   //check winning Conditions Player Cross Bottom to Top
    public void testCheckWinPlayerCrossBotTop() {
        char[][] board = new char[3][3];
        int pos = board.length * board[0].length;
        String playerWin = "You win!";
        Main.playerPositions.clear();
        Main.playerPositions.add(3);
        Main.playerPositions.add(5);
        Main.playerPositions.add(7);
        String result = TicTacToeMethods.checkWin(board, pos);
        assertEquals(result, playerWin);
        Main.playerPositions.clear();
    }

//CPU WINNING CONDITIONS
    @Test   //check winning Conditions Cpu Top Row
    public void testCheckWinCpuRowTop() {
        char[][] board = new char[3][3];
        int pos = board.length * board[0].length;
        String cpuWin = "CPU wins!";
        Main.cpuPositions.clear();
        Main.cpuPositions.add(1);
        Main.cpuPositions.add(2);
        Main.cpuPositions.add(3);
        String result = TicTacToeMethods.checkWin(board, pos);
        assertEquals(result, cpuWin);
        Main.cpuPositions.clear();
    }

    @Test   //check winning Conditions Cpu Bottom Row
    public void testCheckWinCpuRowBot() {
        char[][] board = new char[3][3];
        int pos = board.length * board[0].length;
        String cpuWin = "CPU wins!";
        Main.cpuPositions.clear();
        Main.cpuPositions.add(7);
        Main.cpuPositions.add(8);
        Main.cpuPositions.add(9);
        String result = TicTacToeMethods.checkWin(board, pos);
        assertEquals(result, cpuWin);
        Main.cpuPositions.clear();
    }

    @Test   //check winning Conditions Cpu Left Column
    public void testCheckWinCpuColLeft() {
        char[][] board = new char[3][3];
        int pos = board.length * board[0].length;
        String cpuWin = "CPU wins!";
        Main.cpuPositions.clear();
        Main.cpuPositions.add(1);
        Main.cpuPositions.add(4);
        Main.cpuPositions.add(7);
        String result = TicTacToeMethods.checkWin(board, pos);
        assertEquals(result, cpuWin);
        Main.cpuPositions.clear();
    }

    @Test   //check winning Conditions Cpu Right Column
    public void testCheckWinCpuColRight() {
        char[][] board = new char[3][3];
        int pos = board.length * board[0].length;
        String cpuWin = "CPU wins!";
        Main.cpuPositions.clear();
        Main.cpuPositions.add(3);
        Main.cpuPositions.add(6);
        Main.cpuPositions.add(9);
        String result = TicTacToeMethods.checkWin(board, pos);
        assertEquals(result, cpuWin);
        Main.cpuPositions.clear();
    }

    @Test   //check winning Conditions Cpu Cross Top to Bottom
    public void testCheckWinCpuCrossTopBot() {
        char[][] board = new char[3][3];
        int pos = board.length * board[0].length;
        String cpuWin = "CPU wins!";
        Main.cpuPositions.clear();
        Main.cpuPositions.add(1);
        Main.cpuPositions.add(5);
        Main.cpuPositions.add(9);
        String result = TicTacToeMethods.checkWin(board, pos);
        assertEquals(result, cpuWin);
        Main.cpuPositions.clear();
    }

    @Test   //check winning Conditions Cpu Cross Bottom to Top
    public void testCheckWinCpuCrossBotTop() {
        char[][] board = new char[3][3];
        int pos = board.length * board[0].length;
        String cpuWin = "CPU wins!";
        Main.cpuPositions.clear();
        Main.cpuPositions.add(3);
        Main.cpuPositions.add(5);
        Main.cpuPositions.add(7);
        String result = TicTacToeMethods.checkWin(board, pos);
        assertEquals(result, cpuWin);
        Main.cpuPositions.clear();
    }

//Tie Conditions
    @Test   //all positions occupied
    public void testCheckWinGameOver() {
        char[][] board = new char[3][3];
        int pos = board.length * board[0].length;
        String noWin = "bäh..";
        Main.playerPositions.clear();
        Main.cpuPositions.clear();
        Main.playerPositions.add(1);
        Main.cpuPositions.add(2);
        Main.playerPositions.add(3);
        Main.cpuPositions.add(6);
        Main.playerPositions.add(4);
        Main.cpuPositions.add(7);
        Main.playerPositions.add(5);
        Main.cpuPositions.add(9);
        Main.playerPositions.add(8);
        String result = TicTacToeMethods.checkWin(board, pos);
        assertEquals(result, noWin);
        Main.playerPositions.clear();
        Main.cpuPositions.clear();
    }

}
