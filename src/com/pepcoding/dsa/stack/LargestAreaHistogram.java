package com.pepcoding.dsa.stack;

import java.util.Stack;

public class LargestAreaHistogram {

/*    You are given a number n, representing the size of array a.
    You are given n numbers, representing the height of bars in a bar chart.
    You are required to find and print the area of the largest rectangle in the histogram.*/

    private static int getLargestAreaOfHistogram(int[] a) {

/*        we will have two arrays
                1. to track the next smaller element to the right (default to length of the array)
                2. to track the next smaller element to the left (default to -1)
        for every element the max width is right-left-1 and height is  the value of the current element
                area = height * width, next find the max after iterating through the array */

        int len = a.length;
        int[] NSEIndexAtRight = new int[len];

        NSEIndexAtRight[len - 1] = len; //default
        Stack<Integer> stackRight = new Stack<>();
        stackRight.push(len - 1); //pushing it to check for the same when we start iterating from len-2

        //inserting elements to NSEIndexAtRight array
        for (int i = len - 2; i >= 0; i--) {
            while (stackRight.size() > 0 && a[i] <= a[stackRight.peek()]) {
                stackRight.pop(); //pop all elements until we get an element smaller than the current one
            }
            //popped all greater or equal elements ,there are two conditions
            if (stackRight.isEmpty()) {
                //default
                NSEIndexAtRight[i] = len;
            } else {
                NSEIndexAtRight[i] = stackRight.peek();
            }
            //push current element to stack in every iteration
            stackRight.push(i);
        }

        int[] NSEIndexAtLeft = new int[len];
        Stack<Integer> stackLeft = new Stack<>();
        stackLeft.push(0); //default for the 0th position
        NSEIndexAtLeft[0] = -1;
        //inserting elements to NSEIndexAtLeft array
        for (int i = 1; i < len; i++) {
            while (stackLeft.size() > 0 && a[i] <= a[stackLeft.peek()]) {
                stackLeft.pop(); //pop all elements until we get an element smaller than the current one
            }
            //popped all greater or equal elements ,there are two conditions
            if (stackLeft.isEmpty()) {
                //default
                NSEIndexAtLeft[i] = -1;
            } else {
                NSEIndexAtLeft[i] = stackLeft.peek();
            }
            //push current element to stack in every iteration
            stackLeft.push(i);
        }

        int maxArea = 0;
        for (int i = 0; i < len; i++) {
            int width = NSEIndexAtRight[i] - NSEIndexAtLeft[i] - 1;
            int height = a[i];
            int area = width * height;
            if (area > maxArea) {
                maxArea = area;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {

        int[] a = {6, 2, 5, 4, 5, 1, 6};
        System.out.println(getLargestAreaOfHistogram(a));

    }
}
