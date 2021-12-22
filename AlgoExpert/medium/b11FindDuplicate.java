package com.algoexpert.medium;

import java.util.HashSet;
import java.util.Set;

public class b11FindDuplicate {
    public static void main(String[] args) {
        int[] arr = new int[] {2, 1, 5, 2, 3, 3, 4};
        System.out.println(firstDuplicateValue2(arr));
    }

    //Time: O(n) Space: O(n)
    public static int firstDuplicateValue(int[] array) {
        Set<Integer> existing = new HashSet<>();

        for (int i = 0; i < array.length; i++) {
            if(existing.contains(array[i])) {
                return array[i];
            } else {
                existing.add(array[i]);
            }
        }
        return -1;
    }

    //Time: O(n) Space: O(1)
    public static int firstDuplicateValue2(int[] array) {
        for(int ele : array) {
            int absValue = Math.abs(ele);
            if(array[absValue-1] < 0) return absValue;
            array[absValue-1]*=-1;
        }
        return -1;
    }
}
