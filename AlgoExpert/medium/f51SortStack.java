package com.algoexpert.medium;

import java.util.*;

public class f51SortStack {

    //Time : 2n+n = 3n ~~ n  ||  Space : 2n ~~ n
    //Time : 2n For every iteration we pop of bunch of elements and update the output array. But due to the circular for loop,
    //each idx will be added in the stack for max 2 times and so we will be updating almost all the elements second time
    // too even though not required for all of them.
    //Time : +n = For the for loop
    //Space : 2n = Max 2n elements in the stack. So max 2n pop operations.
    public static int[] nextGreaterElementLeftToRight(int[] array) {

        int[] output = new int[array.length];
        Arrays.fill(output, -1);
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < 2 * array.length; i++) {
            int circularIdx = i % array.length;

            while(stack.size()>0 && array[stack.peek()]<array[circularIdx]) {
                int idxToUpdate = stack.pop();
                output[idxToUpdate] = array[circularIdx];
            }
            stack.push(circularIdx);                                                //adding the currentIdx for which grter elemt is not found yet
        }
        return output;
    }

    //Time : 2n+n = 3n ~~ n  ||  Space : 2n ~~ n
    //Here we start from right : Keep adding element in the stack.
    //If the current element is smaller than the top of stack, then put the top of element in the output array at same index.
    //If current greater than the top of stack, then pop all the smaller elements,
    //because those smaller elements will not be greater elements for any elements on the left.
    public static int[] nextGreaterElementRightToLeft(int[] array) {

        int[] output = new int[array.length];
        Arrays.fill(output, -1);
        Stack<Integer> stack = new Stack<>();

        for (int i = 2*array.length-1; i >= 0; i--) {
            int circularIdx = i % array.length;

            while(stack.size()>0) {

                if(array[circularIdx] >= stack.peek()) {
                    stack.pop();                            //popping off because it will not be a greater element for any of the left elements
                } else {
                    output[circularIdx] = stack.peek();
                    break;
                }
            }
            stack.push(array[circularIdx]);                                   //adding the current element which may be the greater for left elements
        }
        return output;
    }


    public static void main(String[] args) {
        int[] array = {2, 5, -3, -4, 6, 7, 2};
        System.out.println(nextGreaterElementLeftToRight(array));
    }
}
