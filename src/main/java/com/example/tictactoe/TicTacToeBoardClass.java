package com.example.tictactoe;

import java.util.Random;
import java.util.Scanner;

public class TicTacToeBoardClass {

    public static void main(String[] args) {
        Random rand = new Random();
        char[][] ticTacToeBoard =
                {{' ', '|', ' ', '|', ' '},
                        {'-', '+', '-', '+', '-'},
                        {' ', '|', ' ', '|', ' '},
                        {'-', '+', '-', '+', '-'},
                        {' ', '|', ' ', '|', ' '}};

        printBoard(ticTacToeBoard);
        while (true) {
            playerPlay(ticTacToeBoard);
        if(hasGameEnded(ticTacToeBoard, "Player")){
            break;
        }
        computerTurn(ticTacToeBoard);
         if(hasGameEnded(ticTacToeBoard,"computer")){
            break;
            }
        printBoard(ticTacToeBoard);

        }
    }
    private static boolean hasGameEnded(char [][] ticTacToeBoard, String player){
        if(hasWon(ticTacToeBoard, player)){
            printBoard(ticTacToeBoard);
            System.out.println(player +" has won!");
            return true;
        }

        for(int i= 0; i <=4; i+=2){
            for (int j = 0; j<= 4 ; j+=2){
                if(ticTacToeBoard[i][j] == ' '){
                    return false;
                }
            }
        }
        printBoard(ticTacToeBoard);
        System.out.println("The game has tied");
        return true;
    }
    private static boolean hasWon(char[][] ticTacToeBoard, String player) {

        if((ticTacToeBoard[0][0] == playerXorO(player) && ticTacToeBoard[0][2] == playerXorO(player) && ticTacToeBoard[0][4] == playerXorO(player)) ||
        (ticTacToeBoard[2][0] == playerXorO(player) && ticTacToeBoard[2][2] == playerXorO(player) && ticTacToeBoard[2][4] == playerXorO(player)) ||
                (ticTacToeBoard[4][0] == playerXorO(player) && ticTacToeBoard[4][2] == playerXorO(player) && ticTacToeBoard[4][4] == playerXorO(player)) ||
        (ticTacToeBoard[0][0] == playerXorO(player) && ticTacToeBoard[2][0] == playerXorO(player) && ticTacToeBoard[4][0] == playerXorO(player)) ||
                (ticTacToeBoard[0][2] == playerXorO(player) && ticTacToeBoard[2][2] == playerXorO(player) && ticTacToeBoard[4][2] == playerXorO(player)) ||
                        (ticTacToeBoard[0][4] == playerXorO(player) && ticTacToeBoard[2][4] == playerXorO(player) && ticTacToeBoard[4][4] == playerXorO(player)) ||
        (ticTacToeBoard[0][0] == playerXorO(player) && ticTacToeBoard[2][2] == playerXorO(player) && ticTacToeBoard[4][4] == playerXorO(player)) ||
                (ticTacToeBoard[0][4] == playerXorO(player) && ticTacToeBoard[2][2] == playerXorO(player) && ticTacToeBoard[4][0] == playerXorO(player))){
                    return true;
        }
        return false;

    }
    public static void printBoard(char[][] ticTacToeBoard) {
        for (char[] row : ticTacToeBoard) {
            for (char each : row) {
                System.out.print(each);
            }
            System.out.println();
        }
    }
    private static int userInput() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your desired position from 1 to 9");
        return scan.nextInt();
    }
    private static char playerXorO(String player) {
        char val = ' ';
        if (player.equals("Player")) {
            val = 'X';
        } else if (player.equals(("computer"))) {
            val = 'O';
        }
        return val;
    }
    private static void placePosition(char[][] ticTacToeBoard, String user, int position) {
        char valueToBePlaced = playerXorO(user);
        switch (position) {
            case 1:
                ticTacToeBoard[0][0] = valueToBePlaced;
                break;
            case 2:
                ticTacToeBoard[0][2] = valueToBePlaced;
                break;
            case 3:
                ticTacToeBoard[0][4] = valueToBePlaced;
                break;
            case 4:
                ticTacToeBoard[2][0] = valueToBePlaced;
                break;
            case 5:
                ticTacToeBoard[2][2] = valueToBePlaced;
                break;
            case 6:
                ticTacToeBoard[2][4] = valueToBePlaced;
                break;
            case 7:
                ticTacToeBoard[4][0] = valueToBePlaced;
                break;
            case 8:
                ticTacToeBoard[4][2] = valueToBePlaced;
                break;
            case 9:
                ticTacToeBoard[4][4] = valueToBePlaced;
                break;
            default:
                break;
        }
    }
    private static void playerPlay(char [][]ticTacToeBoard ) {
        int user = userInput();
        while(true) {
            if (!checkAvailable(ticTacToeBoard, user)) {
                System.out.println("Move is not valid, pick another number");
                user = userInput();
            }

            break;
        }
        placePosition(ticTacToeBoard, "Player", user);
    }
    private static void computerTurn(char [][] ticTacToeBoard) {
        Random rand = new Random();
       int computerNumGenerator;

        while (true) {
            computerNumGenerator = rand.nextInt(9) + 1;
            if (checkAvailable(ticTacToeBoard, computerNumGenerator)) {
                break;
            }
        }
        System.out.println("Computer chose "+ computerNumGenerator);
        placePosition(ticTacToeBoard, "computer", computerNumGenerator);
    }
    private static boolean checkAvailable(char[][] ticTacToeBoard, int position) {
        switch (position) {
            case 1:
                return ticTacToeBoard[0][0] == ' ';
            case 2:
                return ticTacToeBoard[0][2] == ' ';
            case 3:
                return ticTacToeBoard[0][4] == ' ';
            case 4:
                return ticTacToeBoard[2][0] == ' ';
            case 5:
                return ticTacToeBoard[2][2] == ' ';
            case 6:
                return ticTacToeBoard[2][4] == ' ';
            case 7:
                return ticTacToeBoard[4][0] == ' ';
            case 8:
                return ticTacToeBoard[4][2] == ' ';
            case 9:
                return ticTacToeBoard[4][4] == ' ';
            default:
                return false;
        }
    }
}