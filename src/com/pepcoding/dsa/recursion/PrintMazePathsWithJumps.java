package com.pepcoding.dsa.recursion;

public class PrintMazePathsWithJumps {

    private static void printMazePathsWithJumps(int rows, int columns) {
        printMazePathsWithJumps(0, 0, rows - 1, columns - 1, "");
    }

    private static void printMazePathsWithJumps(int sourceRow, int sourceColumn, int destinationRow, int destinationColumn, String pathSoFar) {

        //base case
        if (sourceRow == destinationRow && sourceColumn == destinationColumn) {
            System.out.print(pathSoFar + " ");
            return;
        }

        //horizontalTraversal
        for (int move = 1; move <= destinationColumn - sourceColumn; move++) {
            printMazePathsWithJumps(sourceRow, sourceColumn + move, destinationRow, destinationColumn, move + "h" + pathSoFar);
        }

        //verticalTraversal
        for (int move = 1; move <= destinationRow - sourceRow; move++) {
            printMazePathsWithJumps(sourceRow + move, sourceColumn, destinationRow, destinationColumn, move + "v" + pathSoFar);
        }

        //diagonalTraversal
        for (int move = 1; move <= destinationColumn - sourceColumn && move <= destinationRow - sourceRow; move++) {
            printMazePathsWithJumps(sourceRow + move, sourceColumn + move, destinationRow, destinationColumn, move + "d" + pathSoFar);
        }
    }

    public static void main(String[] args) {

        printMazePathsWithJumps(2, 3);
    }
}
