package com.algoexpert.easy;

import java.util.HashSet;
import java.util.Set;

public class a1TwoNumberSum {
    public static void main(String[] args) {
        twoNumberSum(new int[] {3, 5, -4, 8, 11, 1, -1, 6}, 10);
    }

    public static int[] twoNumberSum(int[] array, int targetSum) {
        // Write your code here.
        Set<Integer> resultArr = new HashSet<>();
        for(int i=0; i<array.length; i++) {
            int y = targetSum - array[i];
            resultArr.add(y);
            if(resultArr.contains(array[i]) && y != array[i]) {
                int[] result = {array[i], y};
                System.out.println(result[0]+" : "+result[1]);
                return result;
            }
        }
        return new int[0];
    }


}
