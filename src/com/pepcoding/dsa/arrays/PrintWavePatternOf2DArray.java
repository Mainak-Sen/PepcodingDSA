package com.pepcoding.dsa.arrays;

public class PrintWavePatternOf2DArray {


    private static void printWavePatternOf2dArray(int[][] input) {

        //we get to see that column should increase in every iteration
        //and if we get even column ,row is increasing
        //if odd column row is decreasing

        for (int j = 0; j < input[0].length; j++) {

            if (j % 2 == 0)//case even
            {
                for (int i = 0; i < input.length; i++) {
                    System.out.print(input[i][j] + " ");
                }
            } else //case odd
            {
                for (int i = input.length - 1; i >= 0; i--) {
                    System.out.print(input[i][j] + " ");
                }
            }
        }


    }

    public static void main(String[] args) {

        int[][] input = {{1, 7, 3, 5},
                         {3, 5, 2, 4},
                         {7, 6, 2, 9}
        };

        printWavePatternOf2dArray(input);
    }
}
