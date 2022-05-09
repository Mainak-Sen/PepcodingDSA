package com.pepcoding.dsa.arrays;

public class MatrixMultiplication {

    /*Given two matrices ,we have to find the product matrix of the same
     * PS: Matrix product is possible only when number of columns in first matrix
     * is equal to number of rows in 2nd matrix (i.e. m1=n2)
     *and it will form a product matrix of size n1*m2
     * */

    private static void printProductMatrix(int[][] matrix1, int[][] matrix2) {

        int n1 = matrix1.length;
        int m1 = matrix1[0].length;

        int n2 = matrix2.length;
        int m2 = matrix2[0].length;

        if (m1 != n2) {
            System.out.println("Invalid input");
            return;
        }

        int[][] productMatrix = new int[n1][m2];

        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < m2; j++) {
                for (int k = 0; k < m1; k++)// number of elements determined by number of columns in each row of 1st matrix
                {
                    productMatrix[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }

        //print the product matrix
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < m2; j++) {
                System.out.print(productMatrix[i][j] + " ");
            }
            //new line
            System.out.println();
        }


    }

    public static void main(String[] args) {

        int[][] matrix1 = {{1, 2, 4, 3}, {7, 4, 2, 9}, {6, 3, 2, 9}}; //3*4
        int[][] matrix2 = {{1, 3}, {5, 4}, {6, 7}, {1, 0}, {7, 6}}; // 4*2

        printProductMatrix(matrix1, matrix2);

    }
}
