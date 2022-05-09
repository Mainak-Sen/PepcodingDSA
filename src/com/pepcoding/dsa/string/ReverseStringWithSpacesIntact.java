package com.pepcoding.dsa.string;

public class ReverseStringWithSpacesIntact {

    private static String reverseStringWithSpacesIntact(String input) {

        StringBuilder sb = new StringBuilder(input);
        //2 pointer approach
        int i = 0;
        int j = sb.length() - 1;

        while (i < j) {
            if (Character.isSpaceChar(sb.charAt(i))) {
                i++;
            }
            if (Character.isSpaceChar(sb.charAt(j))) {
                j--;
            }
            if (!Character.isSpaceChar(sb.charAt(i)) && !Character.isSpaceChar(sb.charAt(j))) {
                char temp = sb.charAt(i);
                sb.setCharAt(i, sb.charAt(j));
                sb.setCharAt(j, temp);
                i++;
                j--;
            }
        }

        return sb.toString();

    }

    public static void main(String[] args) {

        System.out.println(reverseStringWithSpacesIntact("I work in Google"));
    }
}
