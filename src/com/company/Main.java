package com.company;

import java.util.Scanner;

public class Main {
    public static Scanner in = new Scanner(System.in);
    public static String[][] buildBoard() {
        String[][] board = new String[3][3];
        initializeBoard(board);
        return board;
    }

    private static void initializeBoard(String[][] board) {
        // Fill the board with empty spaces
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = " ";
            }
        }
    }

    private static void setBoardValue(String[][] board, int row, int col, String value) {
        if (row >= 0 && row < 3 && col >= 0 && col < 3) {
            board[row][col] = value;
        }
    }

    public static void printBoard(String[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
                if (j < 2) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if (i < 2) {
                System.out.println("---------");
            }
        }
    }public static int botV(){
        final int min=0, max=2;
        return min + (int)(Math.random()*(max-min+1));
    }

    static String winner;
    private static boolean winningSituations(String[][] board, String player) {
        // Check rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0].equals(player) && board[i][1].equals(player) && board[i][2].equals(player)) {
                winner = board[i][0];
                return true;
            }
        }

        // Check columns
        for (int i = 0; i < 3; i++) {
            if (board[0][i].equals(player) && board[1][i].equals(player) && board[2][i].equals(player)) {
                winner = board[0][i];
                return true;
            }
        }

        // Check diagonals
        if (board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player)) {
            winner = board[0][0];
            return true;
        }

        if (board[0][2].equals(player) && board[1][1].equals(player) && board[2][0].equals(player)) {
            winner = board[0][2];
            return true;
        }

        return false;
    }


    // Checking if the board is full
    public static boolean isBoardFull(String[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j].equals(" ")) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int countBot = 0, countUser = 0;
        char cs;
        System.out.println();

        do {
            System.out.print("Play (if you want to stop click 's', else click 'y')? ");
            cs = Character.toLowerCase(in.next().charAt(0));
            if (cs == 's') {
                break;
            }
            System.out.println();
            game_loop(countBot, countUser);
        } while (true);

        System.out.printf("\nBot status: %d", countBot);
        System.out.printf("\nYour status: %d", countUser);

    }

    public static void game_loop(int countBot, int countUser){
        int valR, valC; String answerStr="";
        String[][] board = buildBoard();
        int resultR, resultC; int count=0; int countXMoves=0, countOMoves=0;

        do {
            printBoard(board);
            if (isBoardFull(board)) {
                answerStr = "It's a tie!";
                break;
            }

            System.out.print("Enter your place(1-3, row): ");
            valR = in.nextInt() - 1;
            System.out.print("Enter your place(1-3, col): ");
            valC = in.nextInt() - 1;
            while (board[valR][valC].equals("X") || board[valR][valC].equals("O")) {
                System.out.println("You have placed a char on existing position.");
                System.out.print("Enter your place-again(1-3, row): ");
                valR = in.nextInt() - 1;
                System.out.print("Enter your place-again(1-3, col): ");
                valC = in.nextInt() - 1;
            }
            count++;



            setBoardValue(board, valR, valC, "X");
            countXMoves++;

            if (winningSituations(board, "X") && !winningSituations(board, "O"))
                break;

            resultR = botV();
            resultC = botV();
            BotC bF = new BotC();
            boolean follow = bF.aiBlockMove(board);
            if (follow)
                countOMoves++;

            while ((board[resultR][resultC].equals("X") || board[resultR][resultC].equals("O")) && !isBoardFull(board)) {
                resultR = botV();
                resultC = botV();
            }

            if (countXMoves == countOMoves)
                setBoardValue(board, resultR, resultC, "O");

            if (!winningSituations(board, "X") && winningSituations(board, "O"))
                break;
            countOMoves++;
        }while (true);

        if (!answerStr.equals("It's a tie!")) {
            printBoard(board);
            System.out.println();
            if (!winner.equals("X"))
                countBot++;
            else
                countUser++;
            System.out.printf("The winner is '%s'.", winner);
        }
        else
            System.out.println("It's a tie!");

    }

}
