package com.algoexpert.medium;

public class a10MaxSubsetSumNoAdjacent {
    public static void main(String[] args) {
        int[] input = new int[] {75, 105, 120, 75, 90, 135};
        int output = maxSubsetSumNoAdjacentOptimized(input);
        System.out.println(output);
    }

    public static int maxSubsetSumNoAdjacent(int[] array) {
        if(array.length==0) {
            return 0;
        } else if(array.length==1) {
            return array[0];
        }

        int maxSums[] = array.clone();

        maxSums[1] = Math.max(array[0],array[1]);

        for (int i = 2; i < array.length; i++) {
            maxSums[i] = Math.max(maxSums[i-2]+array[i], maxSums[i-1]);
        }
        return maxSums[maxSums.length-1];
    }

    public static int maxSubsetSumNoAdjacentOptimized(int[] array) {

        if(array.length==0) {
            return 0;
        } else if(array.length==1) {
            return array[0];
        }

        int previousSum = array[0];
        int lastSum = Math.max(array[0],array[1]);

        for (int i = 2; i < array.length; i++) {
            int current = Math.max(previousSum+array[i], lastSum);
            previousSum = lastSum;
            lastSum = current;
        }
        return lastSum;
    }
}
