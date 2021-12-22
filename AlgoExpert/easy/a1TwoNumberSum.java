package com.algoexpert.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class a1TwoNumberSum {
    public static void main(String[] args) {
        twoNumberSum(new int[] {2,7}, 9);
    }

    public static int[] twoNumberSum(int[] nums, int target) {

        int[] output = new int[2];
        Map<Integer, Integer> storage = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            if(storage.containsKey(nums[i])) {
                output = new int[]{storage.get(nums[i]), i};
            } else {
                storage.put(target-nums[i], i);
            }
        }
        return output;
    }
}
