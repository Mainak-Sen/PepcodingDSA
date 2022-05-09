package com.pepcoding.dsa.recursion;

public class AllIndicesOfAnElementInArray {

    /*Use recursion to return an array with all indices of the search element in input array*/
    private static int[] getAllIndices(int[] input, int searchElement) {
        return getAllIndices(input, 0, 0, searchElement);
    }

    private static int[] getAllIndices(int[] input, int index, int foundSoFarCount, int searchElement) {

        //base case
        if (index == input.length) {
            return new int[foundSoFarCount];
        }
        if (input[index] == searchElement) {
            int[] result = getAllIndices(input, index + 1, foundSoFarCount + 1, searchElement);
            result[foundSoFarCount] = index;
            return result;
        } else {
            int[] result = getAllIndices(input, index + 1, foundSoFarCount, searchElement);
            return result;
        }

    }

    public static void main(String[] args) {

        int[] input = {2, 3, 6, 9, 8, 3, 2, 3, 6, 4};
        int[] result = getAllIndices(input, 3);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
