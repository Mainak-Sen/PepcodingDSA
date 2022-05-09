package com.pepcoding.dsa.arrays;

public class Move2sAtTheEndOfArray {

//naive approach
    /*private static int[] get2sAtEnd(int[] input) {
        int[] result = new int[input.length];
        int j = result.length - 1;
        int k = 0;
        for (int i = 0; i < input.length; i++) {

            if (input[i] == 2) {
                result[j--] = 2;

            } else {
                result[k++] = input[i];


            }

        }

        return result;
    }*/

    //optimized in-place approach
    private static int[] get2sAtEnd(int[] input)    //{10,3,6,5,2,2,2};  i=>6      k=>2first  k=> 2ns2
    {
        int k = 0;
        for (int i = 0; i < input.length; i++) {

            if (input[i] != 2) {
                int temp = input[i];
                input[i] = input[k];
                input[k] = temp;
                k++;

            }

        }

        return input;
    }

    public static void main(String[] args) {

        int[] input = {10, 2, 3, 2, 6, 5, 2};
        int[] result = get2sAtEnd(input);
        for (int i : result) {
            System.out.print(i + " ");
        }

    }
}
