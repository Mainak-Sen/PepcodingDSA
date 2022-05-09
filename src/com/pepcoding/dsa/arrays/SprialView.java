package com.pepcoding.dsa.arrays;

public class SprialView {

    public static void printSpiralView(int[][] input) {

        int minColumn = 0;
        int minRow = 0;
        int maxColumn = input[0].length - 1;
        int maxRow = input.length - 1;

        int totalNoOfElements = input[0].length * input.length;
        int count = 0;

        while (count < totalNoOfElements) {
            //left wall (column remains fixed,row changes from min to max)
            if (count < totalNoOfElements) {
                for (int i = minRow; i <= maxRow; i++) {
                    System.out.print(input[i][minColumn]+" ");
                    count++;
                }
                minColumn++; //incrementing minColumn to avoind the corner element already printed
            }

            //bottom wall (row remains fixed,column changes from min to max)
            if (count < totalNoOfElements) {
                for (int i = minColumn; i <= maxColumn; i++) {
                    System.out.print(input[maxRow][i]+" ");
                    count++;
                }
                maxRow--; //decrementing  maxRow to avoid the corner element already printed
            }

            //right wall (column remains fixed,row changes from min to max)
            if (count < totalNoOfElements) {
                for (int i = maxRow; i >= minRow; i--) {
                    System.out.print(input[i][maxColumn]+" ");
                    count++;
                }
                maxColumn--; //decrementing  maxColumn to avoid the corner element already printed
            }

            //top wall (row remains fixed,column changes from min to max)
            if (count < totalNoOfElements) {
                for (int i = maxColumn; i >= minColumn; i--) {
                    System.out.print(input[minRow][i]+" ");
                    count++;
                }
                minRow++; //decrementing  maxColumn to avoid the corner element already printed
            }
        }

    }

    public static void main(String[] args) {

        int[][] input = {{11, 12, 13, 14, 15, 16, 17},
                         {21, 22, 23, 24, 25, 26, 27},
                         {31, 32, 33, 34, 35, 36, 37},
                         {41, 42, 43, 44, 45, 46, 47},
                         {51, 52, 53, 54, 55, 56, 57}};

        printSpiralView(input);
    }
}
