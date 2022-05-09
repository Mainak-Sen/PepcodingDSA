package com.pepcoding.dsa.recursion;

import java.util.ArrayList;
import java.util.List;

public class PrintAllPossibleStringsWihSpacesInBetween {

    public static List<String> getAllPossibleStrings(String input) {

        List<String> list = new ArrayList<String>();
        //basecase
        if (input.length() == 1) {

            list.add(input);
            return list;
        }


        char c = input.charAt(0);
        String restOfString = input.substring(1);

        List<String> restOfStringWithSpaces = getAllPossibleStrings(restOfString);

        for (String str : restOfStringWithSpaces) {

            //insert space and add it to list
            list.add(c + " " + str);

            //without space and add it to list
            list.add(c + str);
        }
        return list;

    }

    public static void main(String[] args) {

        System.out.println(getAllPossibleStrings("ABC"));
    }

}
