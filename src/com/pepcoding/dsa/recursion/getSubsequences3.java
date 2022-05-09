package com.pepcoding.dsa.recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class getSubsequences3 {

    public static ArrayList<String> gss(String str) {

        //base case
        if (str.length() == 0) {
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");//subsequence of empty string is empty string itself
            return bres;
        }

        char ch = str.charAt(0);
        String restOfString = str.substring(1);
        ArrayList<String> recursion_result = gss(restOfString);

        //now comes two cases
        // 1.we want to add "" to recursion result
        ArrayList<String> myResult = new ArrayList<>();
        for (String rstr : recursion_result) {
            myResult.add("" + rstr);
        }
        // 2.we want to add extracted character to recursion result
        for (String rstr : recursion_result) {
            myResult.add(ch + rstr);
        }

        return myResult;

    }

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        ArrayList<String> res = gss(str);
        System.out.println(res);
    }
}
