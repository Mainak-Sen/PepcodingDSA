package com.pepcoding.dsa.arrays;

public class LongestCommonPrefixAmongstAnArrayOfStrings {

    private static String getLongestCommonPrefix(String[] input) {

        //get the minLength of all the strings in the array
        //as longest prefix cannot be greater than the minString

        //["flower","flow","flight"]

        if (input.length == 0) {
            return "";
        }

        int minLen = Integer.MAX_VALUE;
        for (String str : input) {
            int currentStringLength = str.length();
            if (currentStringLength < minLen) {
                minLen = currentStringLength;
            }
        }


        int low = 0;
        int high = minLen - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isCommonPrefix(input, mid + 1)) {
                low = mid + 1;//increase low to check if the common prefix can be longer
            } else {
                high = mid - 1;
            }
        }

        return input[0].substring(0, low + (high - low) / 2);
    }

    private static boolean isCommonPrefix(String[] input, int len) {

        String str1Prefix = input[0].substring(0, len);
        for (int i = 1; i < input.length; i++) {
            if (!input[i].startsWith(str1Prefix)) {
                return false;
            }

        }
        return true;
    }

    public static void main(String[] args) {

        String[] input = {"flower", "dog", "racecar"};
        System.out.println(getLongestCommonPrefix(input));

    }

}
