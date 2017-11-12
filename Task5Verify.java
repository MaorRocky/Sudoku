package Assign2;

import static Assign2.TasksArrays.*;


public class Task5Verify {

    public static boolean isSolution(int sqrtN, int[][] hints, int[][] board) {
        boolean ans = true;
        int root = sqrtN * sqrtN;
        int[][] matrix = new int[root][root];
        int[][] Blocmatrix = new int[root][root];
        for (int i = 0; i < root; i++) {
            for (int j = 0; j < root; j++) {
                matrix[i][j] = board[i][j];
                Blocmatrix[i][j] = board[i][j];
            }
        }

        columns(matrix);
        blocks(Blocmatrix, sqrtN);

        for (int i = 0; i < root && ans; i++) {
            if (board == null || board.length != root || board[i].length != root)
                ans = false;
        }
        for (int i = 0; i < board.length && ans; i++) {
            if (!(isAllDiff(board[i]))) {
                ans = false;
            }

            if (!(isAllDiff(matrix[i]))) {
                ans = false;
            }
            if (!(isAllDiff((Blocmatrix[i])))) {
                ans = false;
            }
        }
        if (!(isMatrixBetween(board, sqrtN, 1, sqrtN * sqrtN))) {
            ans = false;
        }
        // Checks if the user didn't change the hints.
        if (ans) {
            int a = 0;
            int b = 0;
            for (int i = 0; i < hints.length; i++) {
                for (int j = 1; j < 2; j++) {
                    a = hints[i][0];
                    b = hints[i][1];
                    if (board[a][b] != hints[i][hints[i].length - 1]) {
                        ans = false;
                    }
                }
            }
        }
        return ans;
    }
}


