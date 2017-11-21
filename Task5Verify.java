package Assign2.Assign2;


import static Assign2.Assign2.TasksArrays.*;


public class Task5Verify {

    public static boolean isSolution(int sqrtN, int[][] hints, int[][] board) {
        boolean ans = true;
        int root = sqrtN * sqrtN;
        int[][] TransposeMatrix = new int[root][root];
        int[][] BlocMatrix = new int[root][root];
        for (int i = 0; i < root; i++) {
            for (int j = 0; j < root; j++) {
                TransposeMatrix[i][j] = board[i][j];
                BlocMatrix[i][j] = board[i][j];
            }
        }

        columns(TransposeMatrix);
        blocks(BlocMatrix, sqrtN);

        for (int i = 0; i < root && ans; i++) {
            if (board == null || board.length != root || board[i].length != root) {
//                ans = false;
                throw new RuntimeException("invalid input");

            }
        }
        for (int i = 0; i < board.length && ans; i++) {//we have 3 matrixes, one is the original,
            //one is the columns, and one is the blockMatrix. now well check in each matrix line
            // if all the the numbers are different.
            if (!(isAllDiff(board[i]))) {
                ans = false;
            }

            if (!(isAllDiff(TransposeMatrix[i]))) {
                ans = false;
            }
            if (!(isAllDiff((BlocMatrix[i])))) {
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


