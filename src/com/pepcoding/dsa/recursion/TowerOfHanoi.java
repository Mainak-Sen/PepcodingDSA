package com.pepcoding.dsa.recursion;

public class TowerOfHanoi {

    private static void printMoves(int n) {
        printMoves(n, 'A', 'B', 'C');
    }

    private static void printMoves(int numberOfDisks, char sourceTower, char auxiliaryTower, char destinationTower) {

        //base case
        if (numberOfDisks == 1) {
            System.out.println("Move " + 1 + "th disk from " + sourceTower + " to " + destinationTower);
            return;
        }

        //move n-1 disks from A to B using C as auxiliary tower
        printMoves(numberOfDisks - 1, sourceTower, destinationTower, auxiliaryTower);
        //Simply move nth disk from A to C
        System.out.println("Move " + numberOfDisks + "th disk from " + sourceTower + " to " + destinationTower);
        //move n-1 disks from B to C using A as auxiliaryTower
        printMoves(numberOfDisks - 1, auxiliaryTower, sourceTower, destinationTower);

    }

    public static void main(String[] args) {

        printMoves(4);
    }
}
