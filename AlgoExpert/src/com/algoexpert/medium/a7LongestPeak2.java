package com.algoexpert.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class a7LongestPeak2 {
    public static void main(String[] args) {
//        int[] input = new int[] {1, 2, 3, 3, 4, 0, 10, 6, 5, -1, -3, 2, 3};
//        System.out.println(longestPeak(input));

        "piper".charAt(3);
        int[] input = new int[] {1,2};
        System.out.println(longestPeak(input));

        input = new int[] {2,5,3,2,4,1};
        System.out.println(longestPeak(input));

        input = new int[] {2,3,3,2,2,2,1};
        System.out.println(longestPeak(input));


    }

    public static int longestPeak(int[] array) {
        List<Integer> vector1 = new ArrayList<>();
        List<Integer> vector2 = new ArrayList<>();

        int repeatCount = 0;

        HashMap<Integer, Integer> countMap = new HashMap<>();

        for (int i = 0; i < array.length; i++)
        {
            countMap.put(array[i],
                    countMap.getOrDefault(array[i],0)+1
            );

            if (countMap.get(array[i]) == 1) {
                vector1.add(array[i]);
            } else if (countMap.get(array[i]) == 2) {
                vector2.add(array[i]);
                repeatCount++;
            }

        }

        int size = vector1.size();
         size = size + vector2.size();

         if(repeatCount>1) {
             size = size - repeatCount+1;
         }
         return size;

    }
}
