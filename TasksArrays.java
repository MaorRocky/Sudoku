package Assign2.Assign2;

public class TasksArrays {

    public static boolean isAllDiff(int[] array) {
        boolean isDifferent = true;
        for (int i = 0; i < array.length - 1 && isDifferent; i++) {
            for (int j = i + 1; j < array.length && isDifferent; j++) {
                if (array[i] == array[j])
                    isDifferent = false;
            }
        }
        return isDifferent;
    }

    public static boolean isMatrixBetween(int[][] matrix, int n, int min, int max) {
        boolean rangeCheck = true;
        // first we'll check if the matrix is null or not n*n.
        for (int i = 0; i < n && rangeCheck; i++) {
            if (matrix == null || matrix[i] == null || matrix.length != matrix[i].length)
                rangeCheck = false;
        }
        //now we'll check if the matrix values is between the given ranges.
        for (int i = 0; i < n && rangeCheck; i++) {
            for (int j = 0; j < n && rangeCheck; j++) {
                if (matrix[i][j] < min || matrix[i][j] > max)
                    rangeCheck = false;

            }
        }
        return rangeCheck;
    }

    public static int[][] columns(int[][] matrix) {
        int[][] colMatrix = new int[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                colMatrix[i][j] = matrix[j][i];
            }
        }
        for (int i = 0; i < matrix.length; i++) {//might delete it
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = colMatrix[i][j];
            }
        }
        return colMatrix;
    }

    public static int[][] blocks(int[][] matrix, int sqrtN) {
        // 4 for loops because we have two dimensional arrays,
        // inside another two dimensional arrays.
        int countRow = -1;
        int countCol = 0;
        int[][] blocMatrix = new int[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i = i + sqrtN) {
            for (int j = 0; j < matrix.length; j = j + sqrtN) {
                countRow++;
                countCol = 0;
                for (int q = i; q < i + sqrtN; q++) {
                    for (int k = j; k < j + sqrtN; k++) {
                        blocMatrix[countRow][countCol] = matrix[q][k];
                        countCol++;
                        if (countCol > matrix.length)
                            countCol = 0;
                    }
                }
            }
        }// now we will copy our block matrix values into the given matrix from the user.
        for (int i = 0; i < matrix.length; i++) {
            for (int k = 0; k < matrix.length; k++) {
                matrix[i][k] = blocMatrix[i][k];
            }
        }
        return blocMatrix;
    }
}
