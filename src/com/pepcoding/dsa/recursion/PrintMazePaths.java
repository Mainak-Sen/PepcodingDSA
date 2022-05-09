package com.pepcoding.dsa.recursion;

public class PrintMazePaths {

    /*As mentioned in the problem you are given a number n and a number m representing the number of rows and columns in a maze.
     Suppose you are standing in the top-left corner and have to reach the bottom-right corner. Only two moves are allowed,
      "h" (1-step horizontal) and "v" (1-step vertical). We need to complete the body of printMazePath function
       - without changing signature - to print the list of all paths that can be used to move from top-left to bottom-right.*/

    private static void printMazePaths(int rows, int columns) {
        //starting from (0,0) in the matrix and we have to reach (rows-1,columns-1)
        printMazePaths(rows, columns, 0, 0, "");
    }

    private static void printMazePaths(int rows, int columns, int sourceRow, int sourceColumn, String pathSoFar) {

        //base cases
        if (sourceRow == (rows - 1) && sourceColumn == (columns - 1)) {
            System.out.print(pathSoFar + " ");
            return;
        }
        if (sourceRow > (rows - 1) || sourceColumn > (columns - 1)) {
            return;
        }
        printMazePaths(rows, columns, sourceRow, sourceColumn + 1, "h" + pathSoFar);//horizontal call
        printMazePaths(rows, columns, sourceRow + 1, sourceColumn, "v" + pathSoFar);//vertical call
    }

    public static void main(String[] args) {

        printMazePaths(3, 3);
    }
}
