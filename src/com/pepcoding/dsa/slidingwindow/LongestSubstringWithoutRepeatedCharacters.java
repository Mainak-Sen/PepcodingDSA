package com.pepcoding.dsa.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatedCharacters {

    private static String getLongestSubStringWithoutRepeatedCharacters(String input) {
        //we will have a hashmap to store the index of the previous occurrence of the current character

        Map<Character, Integer> map = new HashMap<>();
        int startIndex = 0;
        int window_length = 0;
        int max_window_length = Integer.MIN_VALUE;
        int maxWindowStartIndex = 0;
        //aabcb  output : abc

        for (int endIndex = 0; endIndex < input.length(); endIndex++) {

            if (map.containsKey(input.charAt(endIndex))) //the character has occurred before
            {
                //shift the window
                //shift the window one after the last occurrence index and tak the max
                // as it can happen that the current start has already been traversed before
                startIndex = Math.max(startIndex, map.get(input.charAt(endIndex)) + 1);
            }
            window_length = endIndex - startIndex + 1;

            //update maxWindowStartIndex only when the current window_length is greater than max_window_length
            if (window_length > max_window_length) {
                max_window_length = window_length;
                maxWindowStartIndex = startIndex;
            }
            map.put(input.charAt(endIndex), endIndex);

        }

        return input.substring(maxWindowStartIndex, maxWindowStartIndex + max_window_length);
    }

    public static void main(String[] args) {

        System.out.println(getLongestSubStringWithoutRepeatedCharacters("abcddamnopqrmj"));

    }
}
