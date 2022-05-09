package com.pepcoding.dsa.recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class GetKPC {

    //static String[] codes = {".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"};

    //the below mapping is same as the leetcode medium problem
    static String[] codes = {" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static ArrayList<String> getKPC(String str) {

        //base case occurs when recursive function is called on empty string ,i.e. no number pressed
        if (str.length() <= 0) {
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }

        char ch = str.charAt(0);
        String remainingPart = str.substring(1);
        ArrayList<String> recursionResult = getKPC(remainingPart);
        ArrayList<String> myResult = new ArrayList<>();

        String numberMapping = codes[ch - '0'];

        for (int i = 0; i < numberMapping.length(); i++) {
            char current = numberMapping.charAt(i);
            for (String each : recursionResult) {
                myResult.add(current + each);
            }
        }

        return myResult;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        ArrayList<String> result = getKPC(str);
        System.out.println(result);

    }
}
