package com.sattler;


import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import static com.sattler.TicTacToeMethods.*;

public class Main {

    static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
    static ArrayList<Integer> cpuPositions = new ArrayList<Integer>();

    public static void main(String[] args) {
        // create gameBoard
        char[][] gameBoard = new char[5][5];
        int positions = gameBoard.length*gameBoard[0].length;
        //set empty values
        newGameBoard(gameBoard);
        //print gameBoard
        printGameBoard(gameBoard);

        String result = "";
        while (result.length() == 0){        //end game if winning condition is given
            //Player
            Scanner sc1 = new Scanner(System.in);
            System.out.println("Enter Placement (1-" + positions + "):");
            //INPUT
            int playerPos = sc1.nextInt();
            //check INPUT
            while(playerPositions.contains(playerPos) || cpuPositions.contains(playerPos) || playerPos < 1 || playerPos > positions){
                System.out.println("Already taken! Choose another position: ");
                //correct Input if taken
                playerPos = sc1.nextInt();
            }
            //set position
            setChoice(gameBoard, playerPos, "player");
            //print Board
            printGameBoard(gameBoard);
            //check winning conditions
            result = checkWin(gameBoard, positions);
            System.out.println(result);

            //CPU
            Random rng = new Random();
            //INPUT
            int cpuPos = rng.nextInt(positions) + 1;
            //check INPUT
            while(playerPositions.contains(cpuPos) || cpuPositions.contains(cpuPos)){
                //correct Input if taken
                cpuPos = rng.nextInt(positions) + 1;
            }
            //set position
            setChoice(gameBoard, cpuPos, "cpu");
            //print Board
            printGameBoard(gameBoard);
            //check winning conditions
            result = checkWin(gameBoard, positions);
            System.out.println(result);
        }
    }
}