package com.pepcoding.dsa.recursion;

public class FastExponentiation {

    private static int getExponent(int power) {
        if (power == 0) {
            return 1;
        }

        int small_power = getExponent(power / 2);
        if (power % 2 == 0) {
            //case even
            return small_power * small_power;
        } else {
            //case odd
            return 2 * small_power * small_power;
        }
    }

    public static void main(String[] args) {

        System.out.println(getExponent(7));
    }
}
