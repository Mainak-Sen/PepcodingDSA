package com.pepcoding.dsa.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class StringWindow {


    /*Given two strings ,one big string and one small string .We need to find the smallest substring
     * in the big string that has all the characters of the  small string.
     *
     * Note :
     * Window can have additional characters than required
     * If the small string has duplicates ,the window should have same or higher count as the small pattern string
     *
     * Eg:
     * 1.
     * s1 = hello_world
     * s2 = lol
     *
     * output = llo
     *
     * 2.
     * s1=fizzbuzz
     * s2=fuzz
     * output = fizzbu
     *
     * */

    private static String getRequiredStringWindow(String bigStr, String smallStr) {

        //use two lookups to track the frequency of characters in the bigStr and the smallStr
        Map<Character, Integer> patternMap = new HashMap<>();
        Map<Character, Integer> currentWindowMap = new HashMap<>();

        for (int i = 0; i < smallStr.length(); i++) {
            patternMap.put(smallStr.charAt(i), patternMap.getOrDefault(smallStr.charAt(i), 0) + 1);
        }
        int count = 0; //this is to keep track when we have all required elements of pattern in current window
        int startIdx = 0; //windowStart marker
        int windowLength = 0;
        int minWindowLength = Integer.MAX_VALUE;
        int startIndexOfMinLengthWindow = -1;//initially -1

        for (int i = 0; i < bigStr.length(); i++) {

            char currentChar = bigStr.charAt(i);
            //include the character in current window
            currentWindowMap.put(currentChar, currentWindowMap.getOrDefault(currentChar, 0) + 1);

            if (patternMap.containsKey(currentChar)
                    && currentWindowMap.get(currentChar) <= patternMap.get(currentChar)) {

                //count is increased only if the current element being considered in this window
                //is indeed useful in terms of number of characters required as per patternMap
                count++;
            }
            //when we have got all the required characters of patternMap in the current window
            if (count == smallStr.length() && startIdx <= i) {
                //time to contract from left end of the window to remove unwanted characters
                while (patternMap.getOrDefault(bigStr.charAt(startIdx), 0) == 0 ||
                        currentWindowMap.get(bigStr.charAt(startIdx)) > patternMap.getOrDefault(bigStr.charAt(startIdx), 0)) {

                    char charAtStartOfCurrentWindow = bigStr.charAt(startIdx);
                    currentWindowMap.put(charAtStartOfCurrentWindow, currentWindowMap.get(charAtStartOfCurrentWindow) - 1);//reduce frequency by 1
                    startIdx++; //contract the window

                }
                //when we reach here the count is still the length of pattern length as we just removed unwanted characters from left
                windowLength = i - startIdx + 1;
                if (windowLength < minWindowLength) {
                    minWindowLength = windowLength;
                    startIndexOfMinLengthWindow = startIdx;

                }

            }

        }

        return startIndexOfMinLengthWindow == -1 ? "Sorry No window found"
                : bigStr.substring(startIndexOfMinLengthWindow, startIndexOfMinLengthWindow + minWindowLength);

    }

    public static void main(String[] args) {

        System.out.println(getRequiredStringWindow("hello", "hello"));
    }

}
