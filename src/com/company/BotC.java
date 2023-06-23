package com.company;

public class BotC {
    static boolean rowChecker, ColChecker, checkedDiagnol;

    public static boolean aiBlockMove(String[][] board) {
        boolean ansToMain = false;
        checkedDiagnol = false;

        diagnolsBlock(board, "X", checkedDiagnol);// need to delete all this function
        if(checkedDiagnol)
            ansToMain = true;

        if (rowsBlock(board, "X", false, "O") && colsBlock(board, "X", false, "O")) {
            rowsBlock(board, "X", false, "O");
            ansToMain = true;
        }else{
            rowsBlock(board, "X", false, "O");
            colsBlock(board, "X", false, "O");
            ansToMain = true;
        }

        return ansToMain;
    }

    public static void aiBestMove(String[][] board) {
        diagnolsMove(board, "X");
        rowsMove(board, "X");
        colsMove(board, "X");
    }

    public static void diagnolsBlock(String[][] board, String att, boolean checkedDiagnol){
        if (board[0][0].equals(att) && board[1][1].equals(att)){
            board[2][2] = "O";
            checkedDiagnol= true;
        }
        if (board[2][2].equals(att) && board[1][1].equals(att)){
            board[0][0] = "O";
            checkedDiagnol= true;
        }
        if (board[0][2].equals(att) && board[1][1].equals(att)) {
            board[2][0] = "O";
            checkedDiagnol = true;
        }
        if (board[2][0].equals(att) && board[1][1].equals(att)){
            board[0][2] = "O";
            checkedDiagnol= true;
        }

        if (board[0][0].equals(att) && board[2][2].equals(att)) {
            board[1][1] = "O";
            checkedDiagnol= true;
        }
        if (board[2][0].equals(att) && board[0][2].equals(att)){
            board[0][0] = "O";
            checkedDiagnol= true;
        }
    }
    public static boolean rowsBlock(String[][] board, String att, boolean rowChecker, String put) {
        for (int row = 0; row < 3; row++) {
            if (board[row][0].equals(att) && board[row][1].equals(att)) {
                board[row][2] = put;
                rowChecker = true;
            } else if (board[row][1].equals(att) && board[row][2].equals(att)) {
                board[row][0] = put;
                rowChecker = true;
            }
        }
        if (board[0][0].equals(att) && board[0][2].equals(att)) {
            board[0][1] = put;
            rowChecker = true;
        }
        if (board[1][0].equals(att) && board[1][2].equals(att)) {
            board[1][1] = put;
            rowChecker = true;
        }
        if (board[2][0].equals(att) && board[2][2].equals(att)) {
            board[2][1] = put;
            rowChecker = true;
        }
        return rowChecker;
    }

    public static boolean colsBlock(String[][] board, String att, boolean ColChecker, String put) {
        for (int col = 0; col < 3; col++) {
            if (board[0][col].equals(att) && board[1][col].equals(att)) {
                board[2][col] = put;
                ColChecker = true;
            } else if (board[2][col].equals(att) && board[1][col].equals(att)) {
                board[0][col] = put;
                ColChecker = true;
            }
        }
        if (board[0][1].equals(att) && board[2][1].equals(att)) {
            board[1][1] = put;
            ColChecker = true;
        }
        if (board[0][2].equals(att) && board[2][2].equals(att)) {
            board[1][2] = put;
            ColChecker = true;
        }
        if (board[0][0].equals(att) && board[2][0].equals(att)){
            board[1][0] = put;
            ColChecker = true;
        }
        return ColChecker;
    }

    public static void diagnolsMove(String[][] board, String att) {

    }
    public static void rowsMove(String[][] board, String att) {

    }
    public static void colsMove(String[][] board, String att) {

    }



}
//tic tac tow AI PERSPECTIVE
//
//WHAT DO WE WANT WITH THIS SMART AI MOVES TO TIC TAC TOE:
//
//**I want basically (the ai) to win the user as fast as possible.
//**Few steps are needed:
//	*getting into a function perspective position of the board.
//	*from now, I want to figure out by efficient algorithm my 	 best(the ai again;) possibilities to win.
//	*after the closing brocades, is an expansion on how to do it.
//}
//#Firstly, I(again) will see the situation, thus, I run with for loops on the board.
//#Secondly, get the best position to make a step on, where the bot has the most chances to win.