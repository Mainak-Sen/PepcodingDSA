package com.pepcoding.dsa.slidingwindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SmallestWindowWithAllDistinctCharacters {

    private static String getSmallestWindowWithAllDistinctCharactersInGivenString(String input) {

        //aabcbcdaabcaaad

        //first we will put all the distinct characters of the given string in a set as
        //set doesn't allow duplicates
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < input.length(); i++) {
            set.add(input.charAt(i));
        }

        Map<Character, Integer> currentWindowMap = new HashMap<>();
        int startIdx = 0;
        int windowLength = 0;
        int minWindowLength = Integer.MAX_VALUE;
        int matchCount = 0; //to keep track if we have all distinct characters as per the set in the current window
        int startIndexOfMinWindow = -1;

        for (int i = 0; i < input.length(); i++) {

            //adding current character in the current running window map
            char ch = input.charAt(i);
            //track count of number of distinct elements before adding current element in currentWindowMap
            int noOfDistinctElementsBefore = currentWindowMap.size();

            //add current  element
            currentWindowMap.put(ch, currentWindowMap.getOrDefault(ch, 0) + 1);
            if (currentWindowMap.size() <= set.size() && currentWindowMap.size() > noOfDistinctElementsBefore) {
                matchCount++;
            }
            //here we have got the window with all distinct characters present
            //now we need to contract from front to minimize the window as much as possible
            //here matchCount == set size
            if (matchCount == set.size() && startIdx <= i) {

                //remove elements from front as long as all distinct elements are in current window
                while (currentWindowMap.get(input.charAt(startIdx)) > 1 && currentWindowMap.size() == set.size()) {
                    char characterAtStartIndexOfCurrentWindow = input.charAt(startIdx);
                    currentWindowMap.put(characterAtStartIndexOfCurrentWindow, currentWindowMap.get(characterAtStartIndexOfCurrentWindow) - 1);
                    startIdx++;
                }

                //check if window length is less than previous min ,if yes change the minWindowLength
                //and store the startIndex for the minWindow
                windowLength = i - startIdx + 1;
                if (windowLength < minWindowLength) {
                    minWindowLength = windowLength;
                    startIndexOfMinWindow = startIdx;
                }
            }
        }
        return startIndexOfMinWindow == -1 ? "No substring found" : input.substring(startIndexOfMinWindow, startIndexOfMinWindow + minWindowLength);

    }

    public static void main(String[] args) {

        System.out.println(getSmallestWindowWithAllDistinctCharactersInGivenString(" "));
    }
}
