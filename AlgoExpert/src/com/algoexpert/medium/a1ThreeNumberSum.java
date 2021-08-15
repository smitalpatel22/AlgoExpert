package com.algoexpert.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class a1ThreeNumberSum {
    public static void main(String[] args) {
        List<Integer[]> result = findTriplets(new int[]{12, 3, 1, 2, -6, 5, -8, 6}, 0);
        System.out.println(result);

    }

    public static List<Integer[]> findTriplets(int[] array, int targetSum) {

        List<Integer[]> result = new ArrayList<>();


        Arrays.sort(array);        //-8,-6,1,2,3,5,6,12
        for (int i = 0; i < array.length - 2; i++) {
            int left = i+1, right = array.length - 1;
            while (left < right) {
                int sum = array[i] + array[left] + array[right];
                if (sum == targetSum) {
                    result.add(new Integer[]{array[i], array[left], array[right]});
                    left++;
                    right--;
                } else if (sum < targetSum) {
                    left++;
                } else if (sum > targetSum) {
                    right--;
                }
            }
        }
        return result;
    }
}
