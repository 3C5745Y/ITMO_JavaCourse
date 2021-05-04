package com.company;

public class SearchMaxValue {

        public int[][] fillMatrix(int matrix[][]) {
            for (int i = 0; i < matrix.length; i++){
                for (int j = 0; j < matrix[i].length; j++){
                    matrix[i][j] = (int)(Math.random() * 1000);
                }
            }
            return matrix;
        }

        public int searchMaxValue(int[][] matrix, int row, int column) {
            int max = matrix[0][0];
            for (int a = 0; a < row; a++) {
                for (int b = 0; b < column; b++) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (matrix[a][b] > max) {
                        max = matrix[a][b];
                    }
                }
            }
            return max;
        }
}
