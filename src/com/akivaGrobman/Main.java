package com.akivaGrobman;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static Scanner scanner;
    public static char[] board;
    public static boolean isXTurn;

    public static void main(String[] args) {
        int turnCount = 0;
        initializeGame();
        System.out.println("This is how you choose a position 1-9");
        printBoard();
        clearBoard();
        do {
            printBoard();
            System.out.println("Please enter the position for your piece 1-9");
            int position = getPosition();
        } while (turnCount != 9 && gameNotWon());
    }

    public static int getPosition() {
        String input = scanner.nextLine();
        char character = input.charAt(0);
        // todo allow him to correct
        if(character < '1' || character > '9') {
            System.out.println("error invalid input");
            System.exit(0);
        }
        return character - '1';
    }

    //todo
    public static boolean gameNotWon() {
        return false;
    }

    public static void clearBoard() {
        // todo fix this
        for (int i = 0; i < board.length; i++) {
            board[i] = ' ';
        }
    }

    public static void printBoard() {
        //todo fix this
        String output = " -------------\n";
        for (int i = 0; i < board.length; i++) {
            output += " | " + board[i];
            if((i + 1) % 3 == 0) {
                output += " |\n -------------\n";
            }
        }
        System.out.println(output);
    }

    public static void initializeGame() {
        scanner = new Scanner(System.in);
        board = new char[9];
        Random random = new Random();
        isXTurn = random.nextBoolean();
        for (int i = 0; i < board.length; i++) {
            board[i] = (char)(i + '1');
        }
    }

}
