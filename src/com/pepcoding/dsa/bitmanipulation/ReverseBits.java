package com.pepcoding.dsa.bitmanipulation;

public class ReverseBits {

    private static int reverseBits(int n) {

        int reverse = 0;
        boolean flag = false; //flag to check when we get the first set bit
        int j = 0;//pointer to point to bit positions of the reverse number
        for (int i = 31; i >= 0; i--) {
            int mask = 1 << i;
            if (flag) {
                if ((n & mask) != 0) {
                    int setMask = 1 << j;
                    reverse |= setMask;
                }
                j++;
            } else {
                if ((n & mask) != 0) {
                    flag = true; //got our first set bit ,before this everything was zero
                    int setMask = 1 << j;
                    reverse |= setMask;
                    j++;
                }
            }
        }
        return reverse;
    }

    public static void main(String[] args) {

        System.out.println(reverseBits(11));
    }
}
