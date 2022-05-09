package com.pepcoding.dsa.recursion;

public class JosephusProblem {

    /*If we start the 1st position from one then we just to need to add 1 to the
    result achieved by this problem solved with starting position as 0 */

    private static int getPositionOfPersonAlive(int numberOfPersons, int killingPosition) {

        //base case
        if (numberOfPersons == 1) {
            return 0;
        }

        return (getPositionOfPersonAlive(numberOfPersons - 1, killingPosition) + killingPosition) % numberOfPersons;
    }

    public static void main(String[] args) {

        System.out.println(getPositionOfPersonAlive(100, 2));
    }
}
