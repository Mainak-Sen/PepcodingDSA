package com.pepcoding.dsa.recursion;

public class FindIfThereIsAPath {

    private static boolean find(int[][] mat, int r, int c, int startr, int startc, int endr, int endc) {
        boolean[][] visited = new boolean[r][c];
        return find(mat, r, c, startr, startc, endr, endc, visited);
    }


    private static boolean find(int[][] mat, int r, int c, int startr, int startc, int endr, int endc, boolean[][] visited) {


        //base case
        if (startr == endr && startc == endc) {
            return true;
        }

        if (startr > r - 1 || startc > c - 1 || startr < 0 || startc < 0 || mat[startr][startc] != 1 || visited[startr][startc]) {

            return false;
        }

        visited[startr][startc] = true; //marking the index as visited

        boolean found = find(mat, r, c, startr, startc + 1, endr, endc, visited)
                || find(mat, r, c, startr + 1, startc, endr, endc, visited)
                || find(mat, r, c, startr - 1, startc, endr, endc, visited)
                || find(mat, r, c, startc - 1, startc, endr, endc, visited);

        visited[startr][startc] = false;//setting it to false again to consider it for next

        return found;

    }

    public static void main(String[] args) {

        int[][] matrix = {{1, 1, 1, 1},
                          {0, 0, 1, 1},
                          {0, 0, 1, 0},
                          {0, 0, 0, 1}};
        System.out.println(find(matrix, matrix.length, matrix[0].length, 2, 2, 3, 3));

    }

}
