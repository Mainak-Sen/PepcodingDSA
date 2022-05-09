package com.pepcoding.dsa.binarysearch;

public class getFirstAndLastIndexOfGivenElement {

    private static int[] getFirstAndLastIndexOfGivenElementInArray(int[] input, int target) {

        //initially potential firstIndex is -1
        int firstIndex = -1;
        int low = 0;
        int high = input.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (input[mid] > target) {
                high = mid - 1;
            } else if (input[mid] < target) {
                low = mid + 1;
            } else {
                //we have found the element ,it's a potential candidate for first index but not the final answer
                firstIndex = mid;

                //continue  the search towards left subarray as there can be repetitive elements
                high = mid - 1;

            }
        }

        //initially potential lastIndex is -1
        int lastIndex = -1;
        low = 0;
        high = input.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (input[mid] > target) {
                high = mid - 1;
            } else if (input[mid] < target) {
                low = mid + 1;
            } else {
                //we have found the element ,it's a potential candidate for first index but not the final answer
                lastIndex = mid;

                //continue  the search towards right subarray as there can be repetitive elements
                low = mid + 1;

            }
        }

        return new int[]{firstIndex, lastIndex};
    }

    public static void main(String[] args) {

        //int[] input = {1, 5, 10, 15, 22, 33, 33, 33, 33, 33, 40, 42, 55, 66, 77};
        int[] input = {1, 1, 1, 1, 1, 2, 2, 2};
        int[] result = getFirstAndLastIndexOfGivenElementInArray(input, 2);
        for (int i : result) {
            System.out.print(i + " ");
        }

    }
}
