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
            System.out.println("It's now the " + getCurrentPiece() + " turn\nPlease enter the position for your piece 1-9");
            int position = getPosition();
            if(board[position] == ' ') {
                board[position] = getCurrentPiece();
                turnCount++;
                isXTurn = !isXTurn;
            } else {
                System.out.println("Sorry that position is already taken please try an different position");
            }
        } while (turnCount != 9 && gameNotWon());
        if(turnCount == 9 && gameNotWon()) {
            System.out.println("Oops now winner :(\nbetter luck next time");
        } else {
            printBoard();
            isXTurn = !isXTurn;
            System.out.println("Yay the " + getCurrentPiece() + " player won.");
        }
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

    public static char getCurrentPiece() {
        char piece;
        if(isXTurn) {
            piece = 'X';
        } else {
            piece = 'O';
        }
        return piece;
    }

    public static boolean gameNotWon() {
        //todo fix this
        for (int i = 0; i < board.length; i += 3) {
            if(board[i] != ' ' && board[i] == board[i + 1] && board[i] == board[i + 2]) {
                return false;
            }
        }
        for (int i = 0; i < 3; i++) {
            if(board[i] != ' ' && board[i] == board[i + 3] && board[i] == board[i + 6]) {
                return false;
            }
        }
        if(board[0] != ' ' && board[0] == board[4] && board[0] == board[8]) {
            return false;
        }
        if(board[2] != ' ' && board[2] == board[4] && board[2] == board[6]) {
            return false;
        }
        return true;
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
