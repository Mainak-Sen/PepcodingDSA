package com.pepcoding.dsa.lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveAllPrimesFromArrayList {

    private static void removeAllPrimes(ArrayList<Integer> numbers) {

        for (int i = numbers.size() - 1; i >= 0; i--) {
            if (isPrime(numbers.get(i))) {
                numbers.remove(i);
            }
        }
    }

    private static boolean isPrime(int n) {

        if (n <= 1) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(8, 2, 13, 16, 7, 5, 3, 22, 56, 55, 51, 31);
        ArrayList<Integer> listInput = new ArrayList<>(list);
        removeAllPrimes(listInput);
        System.out.println(listInput);
    }

}
