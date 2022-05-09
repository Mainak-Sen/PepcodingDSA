package com.pepcoding.dsa.hashMap;

import java.util.HashMap;
import java.util.Map;

public class getHighestFrequencyOfCharacter {

    private static char getHighestFrequencyChar(String input) {

        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int maxFrequency = 0;
        char mostFrequentChar = 0;
        //storing the frequency of characters in input
        for (char c : input.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
            int frequency = map.get(c);
            if (frequency > maxFrequency) {
                maxFrequency = frequency;
                mostFrequentChar = c;
            }
        }
        return mostFrequentChar;

    }

    public static void main(String[] args) throws Exception {
        System.out.println(getHighestFrequencyChar("zmszeqxllzvheqwrofgcuntypejcxovtaqbnqyqlmrwitc"));


    }
}
