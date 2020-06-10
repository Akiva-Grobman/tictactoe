package com.akivaGrobman;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    private static Scanner scanner;
    private static char[] board;
    private static boolean isXTurn;

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

    private static void printBoard() {
        StringBuilder output = new StringBuilder(" -------------\n");
        for (int i = 0; i < board.length; i++) {
            output.append(" | ").append(board[i]);
            if((i + 1) % 3 == 0) {
                output.append(" |\n -------------\n");
            }
        }
        System.out.println(output);
    }

    private static int getPosition() {
        char character;
        do {
            String input = scanner.nextLine();
            character = input.charAt(0);
            if (character >= '1' && character <= '9') {
                break;
            }
            System.out.println("invalid input please try again 1-9");
        } while (true);
        return character - '1';
    }

    private static char getCurrentPiece() {
        char piece;
        if(isXTurn) {
            piece = 'X';
        } else {
            piece = 'O';
        }
        return piece;
    }

    private static boolean gameNotWon() {
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
        return !(board[2] != ' ' && board[2] == board[4] && board[2] == board[6]);
    }

    private static void initializeGame() {
        scanner = new Scanner(System.in);
        board = new char[9];
        Random random = new Random();
        isXTurn = random.nextBoolean();
        for (int i = 0; i < board.length; i++) {
            board[i] = (char)(i + '1');
        }
    }

    private static void clearBoard() {
        Arrays.fill(board, ' ');
    }

}