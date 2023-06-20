package com.company;

public class BotC {

    public static void aiBlockMove(String[][] board) {
        diagnolsBlock(board, "X");
        rowsBlock(board, "X");
        colBlock(board, "X");
    }
    public static void aiBestMove(String[][] board) {

    }

    public static void diagnolsBlock(String[][] board, String att){
        if (board[0][0].equals(att) && board[1][1].equals(att))
            board[2][2] = "O";
        if (board[0][2].equals(att) && board[1][1].equals(att))
            board[2][0] = "O";
    }
    public static void rowsBlock(String[][] board, String att) {
        for (int row = 0; row < 3; row++) {
            if (board[row][0].equals(att) && board[row][1].equals(att)) {
                board[row][2] = "O";
            } else if (board[row][1].equals(att) && board[row][2].equals(att)) {
                board[row][0] = "O";
            }
        }
    }
    public static void colBlock(String[][] board, String att) {
        for (int col = 0; col < 3; col++) {
            if (board[0][col].equals(att) && board[1][col].equals(att)) {
                board[2][col] = "O";
            } else if (board[2][col].equals(att) && board[1][col].equals(att)) {
                board[0][col] = "O";
            }
        }
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