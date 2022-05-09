package com.pepcoding.dsa.stack;

import java.util.Stack;

/*Here we will implement queue using two stacks,its an add efficient method*/


public class StackToQueueAdapter {

    private Stack<Integer> mainStack;
    private Stack<Integer> helperStack;

    public StackToQueueAdapter() {

        mainStack = new Stack<>();
        helperStack = new Stack<>();
    }

    public void add(int value) {
        mainStack.push(value);//O(1) hence add efficient
    }

    public int peek() { //O(N)
        //when queue is empty
        if (mainStack.size() == 0) {
            System.out.println("Stack underflow!!");
        }
        while (mainStack.size() > 1) {
            helperStack.push(mainStack.pop()); //move from main to helper until we reach the bottom element
        }
        //store the bottom element in a variable
        int front_value = mainStack.pop();
        //move the contents back from helper to main stack to maintain the Queue as it was before
        helperStack.push(front_value);//from bottom of main stack,it comes to top of helper stack

        while (helperStack.size() > 0) {
            mainStack.push(helperStack.pop());
        }

        return front_value;
    }

    public int remove() {  //O(N)

/*        remove would be similar to peek except for the fact that we should ensure not to push the
                element (which was at bottom of main stack at first) back from helper to main stack*/

        //when queue is empty
        if (mainStack.size() == 0) {
            System.out.println("Stack underflow!!");
        }
        while (mainStack.size() > 1) {
            helperStack.push(mainStack.pop()); //move from main to helper until we reach the bottom element
        }
        //store the bottom element in a variable
        int front_value = mainStack.pop();
        //move the contents back from helper to main stack to maintain the Queue as it was before

        while (helperStack.size() > 0) {
            mainStack.push(helperStack.pop());
        }

        return front_value;

    }

    public int size() {
        return mainStack.size();
    }

    public static void main(String[] args) {

        StackToQueueAdapter queue = new StackToQueueAdapter();
        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.add(40);
        queue.add(50);

        //System.out.println(queue.remove());
        System.out.println(queue.peek());

    }
}
