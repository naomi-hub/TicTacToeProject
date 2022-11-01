package com.example.tictactoe;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicTacToeBoardClassTest {

    @Test
    void printBoard() {
        char[][] ticTacToeBoard =
                {{' ', '|', ' ', '|', ' '},
                        {'-', '+', '-', '+', '-'},
                        {' ', '|', ' ', '|', ' '},
                        {'-', '+', '-', '+', '-'},
                        {' ', '|', ' ', '|', ' '}};

//        Assert.assertEquals(print(ticTacToeBoard), printBoard());
    }

    private void print(char[][] ticTacToeBoard) {
        for (char[] row : ticTacToeBoard) {
            for (char each : row) {
                System.out.print(each);
            }
            System.out.println();
        }
    }
}