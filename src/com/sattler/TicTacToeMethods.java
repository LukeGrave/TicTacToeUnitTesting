package com.sattler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.sattler.Main.playerPositions;
import static com.sattler.Main.cpuPositions;

public class TicTacToeMethods {

    //new gameBoard
    public static void newGameBoard(char[][] gameBoard){
        for(int i = 0; i < gameBoard.length; i++){    //for every row
            for(int j = 0; j < gameBoard.length; j++){          //get every field in row
                gameBoard[i][j] = ' ';                //set value
            }
        }
    }

    //print gameBoard
    public static void printGameBoard(char[][] gameBoard){

        for (int i = 0; i <= gameBoard.length; i++){    //COORD ROW
            if(i == 0){
                System.out.print("+ |");
            } else{
            System.out.print(i + "|");
            }
        }
        System.out.println();
        int k = 0;  //Counter COORD COLUMN
        for(char[] row : gameBoard){    //for every row
            for(int i = -1; i < gameBoard.length; i++) {
                if(i == -1){
                    System.out.print("-");
                }
                System.out.print("-" + "+");       //grid
            }
            System.out.println();   //next row
            if(k < 10){
                System.out.print(" " + k + "|");  //COORD COLUMN
            } else {
                System.out.print(k + "|");
            }
            k = k + 5;
            for(char c : row){          //get every field in row
                System.out.print(c);    //print value
                System.out.print('|');
            }
            System.out.println();
        }
    }

    //set Positions on Field and keep track in List
    public static void  setChoice(char[][] gameBoard, int pos, String user){

        char symbol = ' '; //set to <space> per default

        if(user.equals("player")){
            symbol = 'X';
            playerPositions.add(pos); //add choice to List for winning condition
        } else if(user.equals("cpu")){
            symbol = 'O';
            cpuPositions.add(pos);
        }
        //Position-Conversion to 2-D Array location
        int x = ((pos - 1) / gameBoard.length);
        int y = ((pos - 1) % gameBoard[0].length);
        gameBoard[x][y] = symbol;

    }

    public static String checkWin(char[][] gameBoard, int positions) {
        //win by Column
        for (int i = 1; i <= positions - (2 * gameBoard[0].length); i++) {   //ohne die letzten zwei Reihen (out of bounds)
            if (playerPositions.contains(i) && playerPositions.contains(i + gameBoard[0].length) && playerPositions.contains(i + (gameBoard[0].length * 2))) {
                return "You win!";
            } else if (cpuPositions.contains(i) && cpuPositions.contains(i + gameBoard[0].length) && cpuPositions.contains(i + (gameBoard[0].length * 2))) {
                return "CPU wins!";
            }
        }
        //win by Row
        for (int i = 0; i < gameBoard.length; i++) {    //Row
            for (int j = 0; j < gameBoard[0].length - 2; j++) {   //Col -- einzug da sonst out of bounds
                if (playerPositions.contains((i * gameBoard.length) + (j + 1)) && playerPositions.contains((i * gameBoard[0].length) + (j + 2)) && playerPositions.contains((i * gameBoard[0].length) + (j + 3))) {
                    return "You win!";
                } else if (cpuPositions.contains((i * gameBoard[0].length) + (j + 1)) && cpuPositions.contains((i * gameBoard[0].length) + (j + 2)) && cpuPositions.contains((i * gameBoard[0].length) + (j + 3))) {
                    return "CPU wins!";
                }
            }
        }
        //win by Cross
        for (int i = 1; i < gameBoard.length - 1; i++) {    //Row
            for (int j = 1; j < gameBoard[0].length - 1; j++) {   //Col -- einzug da sonst out of bounds
                if (playerPositions.contains(((i - 1) * gameBoard.length) + j) && playerPositions.contains((i * gameBoard[0].length) + (j + 1)) && playerPositions.contains(((i + 1) * gameBoard[0].length) + (j + 2)) //top left to bot right
                || playerPositions.contains(((i + 1) * gameBoard.length) + j) && playerPositions.contains((i * gameBoard[0].length) + (j + 1)) && playerPositions.contains(((i - 1) * gameBoard[0].length) + (j + 2))) { //bot left to top right
                    return "You win!";
                } else if (cpuPositions.contains(((i - 1) * gameBoard[0].length) + j) && cpuPositions.contains((i * gameBoard[0].length) + (j + 1)) && cpuPositions.contains(((i + 1) * gameBoard[0].length) + (j + 2)) //top left to bot right
                || cpuPositions.contains(((i + 1) * gameBoard[0].length) + j) && cpuPositions.contains((i * gameBoard[0].length) + (j + 1)) && cpuPositions.contains(((i - 1) * gameBoard[0].length) + (j + 2))) {  //bot left to top right
                    return "CPU wins!";
                }
            }
        }
        //unentschieden
        if ((playerPositions.size() + cpuPositions.size()) == positions) {
            return "bäh..";
        }
        //nothing
        return "";
//    //winning conditions ROWS
//        List topRow = Arrays.asList(1, 2, 3);
//        List midRow = Arrays.asList(4, 5, 6);
//        List botRow = Arrays.asList(7, 8, 9);
//    //winning conditions COLUMNS
//        List leftCol = Arrays.asList(1, 4, 7);
//        List midCol = Arrays.asList(2, 5, 8);
//        List rightCol = Arrays.asList(3, 6, 9);
//    //winning conditions DIAGONALS
//        List cross1 = Arrays.asList(1, 5, 9);
//        List cross2 = Arrays.asList(7, 5, 3);
//    //List of winningCondition Lists
//        List<List> winning = new ArrayList<List>();
//        winning.add(topRow);
//        winning.add(midRow);
//        winning.add(botRow);
//        winning.add(leftCol);
//        winning.add(midCol);
//        winning.add(rightCol);
//        winning.add(cross1);
//        winning.add(cross2);
//
//    //Game breaks: result.length > 0
//        for (List l : winning) {
//            if (playerPositions.containsAll(l)){
//                return "You win!";
//            } else if(cpuPositions.containsAll(l)){
//                return "CPU wins!";
//            } else if(playerPositions.size() + cpuPositions.size() == 9){
//                return "bäh..";
//            }
//        }
//    //Game won't break: result.length == 0
//        return "";
//    }
    }

}