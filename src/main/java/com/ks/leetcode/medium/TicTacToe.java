package com.ks.leetcode.medium;

public class TicTacToe {

    public static void main(String[] args) {

        TicTacToe t1 = new TicTacToe();
        int answer = t1.hasWon(new int[][]{
                {2, 2, 0},
                {2, 2, 0},
                {2, 0, 1}}, 3);
        System.out.println("winner=" + answer);

    }

    //returns 0 if no one has won
    //        1 if cross has won
    //        2 if zero has won


    public int hasWon(int[][] board, int length) {

        int crosPiecesdiagonally = 0;
        int oPiecesdiagonally = 0;

        for (int i = 0; i < length; i++) {
            int crossPiecesRowWise = 0;
            int oPiecesRowWise = 0;
            int crossPiecesColumnWise = 0;
            int oPiecesColumnWise = 0;
            for (int j = 0; j < length; j++) {
                if (board[i][j] == 1) crossPiecesRowWise++;
                if (board[i][j] == 2) oPiecesRowWise++;
                if (board[j][i] == 1) crossPiecesColumnWise++;
                if (board[j][i] == 2) oPiecesColumnWise++;

                if (i == j) {
                    if (board[i][j] == 1) crosPiecesdiagonally++;
                    if (board[i][j] == 2) oPiecesdiagonally++;

                }
            }
            if (crossPiecesRowWise == length) return 1;
            if (oPiecesRowWise == length) return 2;

            if (crossPiecesColumnWise == length) return 1;
            if (oPiecesColumnWise == length) return 2;

            if (crosPiecesdiagonally == length) return 1;
            if (oPiecesdiagonally == length) return 2;

        }

        return 0;

    }

}
