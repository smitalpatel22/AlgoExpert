package com.algoexpert.medium;

public class c28KadanesAlgoMaxSumSubarray {

    public static int findMaxSumInAnySubarray(int[] array) {
        int maxSoFar = array[0];
        int sum=array[0];
        for (int i=1; i<array.length; i++) {
            sum=sum+array[i];
            if(sum>maxSoFar) {
                maxSoFar=sum;
            }
            if(sum<0) {
                sum=0;
            }
        }
        return maxSoFar;
    }

    public static int findMaxSumInAnySubarrayMethod2(int[] array) {
        int maxEndingHere = array[0];
        int maxSoFar=array[0];
        for (int i=1; i<array.length; i++) {
            int num = array[i];
            maxEndingHere = Math.max(num, maxEndingHere+num);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }

    public static void main(String[] args) {
        System.out.println(findMaxSumInAnySubarray(new int[]{3, 5, -9, 1, 3, -2, 3, 4, 7, 2, -9, 6, 3, 1, -5, 4}));
        System.out.println(findMaxSumInAnySubarrayMethod2(new int[]{3, 5, -9, 1, 3, -2, 3, 4, 7, 2, -9, 6, 3, 1, -5, 4}));
    }

}
