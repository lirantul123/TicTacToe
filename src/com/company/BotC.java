package com.company;

public class BotC {
    static boolean rowChecker, ColChecker, checkedDiagnol;

    public static boolean aiBlockMove(String[][] board) {
        boolean ansToMain = false;
//        checkedDiagnol = false;

//        diagnolsBlock(board, "X", checkedDiagnol);// need to delete all this function
//        if(checkedDiagnol)
//            ansToMain = true;

        if (rowsBlock(board, "X", false, "O", "dont") && colsBlock(board, "X", false, "O", "dont")
                                                               && diagnolsBlock(board, "X", false, "O", "dont")) {
            rowsBlock(board, "X", false, "O", "do");
            ansToMain = true;
        }if (!rowsBlock(board, "X", false, "O", "dont") && !colsBlock(board, "X", false, "O", "dont")
                                                                      && diagnolsBlock(board, "X", false, "O", "dont")) {
            diagnolsBlock(board, "X", false, "O", "do");
            ansToMain = true;

        }if (!rowsBlock(board, "X", false, "O", "dont") && colsBlock(board, "X", false, "O", "dont")
                                                                 && !diagnolsBlock(board, "X", false, "O", "dont")) {
            colsBlock(board, "X", false, "O", "do");
            ansToMain = true;
        }


        return ansToMain;
    }

    public static void aiBestMove(String[][] board) {
        diagnolsMove(board, "X");
        rowsMove(board, "X");
        colsMove(board, "X");
    }

    //Block moves
    public static boolean diagnolsBlock(String[][] board, String att, boolean checkedDiagnol, String put, String doOn){
        if (doOn.equals("do")){
            if (board[0][0].equals(att) && board[1][1].equals(att)){
                board[2][2] = put;
                checkedDiagnol= true;
            }
            if (board[2][2].equals(att) && board[1][1].equals(att)){
                board[0][0] = put;
                checkedDiagnol= true;
            }
            if (board[0][2].equals(att) && board[1][1].equals(att)) {
                board[2][0] = put;
                checkedDiagnol = true;
            }
            if (board[2][0].equals(att) && board[1][1].equals(att)){
                board[0][2] = put;
                checkedDiagnol= true;
            }

            if (board[0][0].equals(att) && board[2][2].equals(att)) {
                board[1][1] = put;
                checkedDiagnol= true;
            }
            if (board[2][0].equals(att) && board[0][2].equals(att)){
                board[0][0] = put;
                checkedDiagnol= true;
            }
        }
        else{
            if (board[0][0].equals(att) && board[1][1].equals(att)){
                checkedDiagnol= true;
            }
            if (board[2][2].equals(att) && board[1][1].equals(att)){
                checkedDiagnol= true;
            }
            if (board[0][2].equals(att) && board[1][1].equals(att)) {
                checkedDiagnol = true;
            }
            if (board[2][0].equals(att) && board[1][1].equals(att)){
                checkedDiagnol= true;
            }
            if (board[0][0].equals(att) && board[2][2].equals(att)) {
                checkedDiagnol= true;
            }
            if (board[2][0].equals(att) && board[0][2].equals(att)){
                checkedDiagnol= true;
            }
        }

        return checkedDiagnol;
    }
    public static boolean rowsBlock(String[][] board, String att, boolean rowChecker, String put, String doOn) {
        if (doOn.equals("do")){
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
        }
        else{
            for (int row = 0; row < 3; row++) {
                if (board[row][0].equals(att) && board[row][1].equals(att)) {
                    rowChecker = true;
                } else if (board[row][1].equals(att) && board[row][2].equals(att)) {
                    rowChecker = true;
                }
            }
            if (board[0][0].equals(att) && board[0][2].equals(att)) {
                rowChecker = true;
            }
            if (board[1][0].equals(att) && board[1][2].equals(att)) {
                rowChecker = true;
            }
            if (board[2][0].equals(att) && board[2][2].equals(att)) {
                rowChecker = true;
            }
        }

        return rowChecker;
    }

    public static boolean colsBlock(String[][] board, String att, boolean ColChecker, String put, String doOn) {
        if (doOn.equals("do")){
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
        }else{
            for (int col = 0; col < 3; col++) {
                if (board[0][col].equals(att) && board[1][col].equals(att)) {
                    ColChecker = true;
                } else if (board[2][col].equals(att) && board[1][col].equals(att)) {
                    ColChecker = true;
                }
            }
            if (board[0][1].equals(att) && board[2][1].equals(att)) {
                ColChecker = true;
            }
            if (board[0][2].equals(att) && board[2][2].equals(att)) {
                ColChecker = true;
            }
            if (board[0][0].equals(att) && board[2][0].equals(att)){
                ColChecker = true;
            }
        }
        return ColChecker;
    }

    //Attack moves
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