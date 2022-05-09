package com.pepcoding.dsa.string;

public class GetAsciiDifference {

    private static String getAsciiDifferenceBetweenConsecutiveCharacters(String input) {

        StringBuilder sb = new StringBuilder();
        sb.append(input.charAt(0));

        for (int i = 1; i < input.length(); i++) {

            int difference = input.charAt(i) - input.charAt(i - 1);
            sb.append(difference);
            sb.append(input.charAt(i));
        }

        return sb.toString();

    }

    public static void main(String[] args) {

        System.out.println(getAsciiDifferenceBetweenConsecutiveCharacters("abecd"));
    }
}
