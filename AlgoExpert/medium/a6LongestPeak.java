package com.algoexpert.medium;

public class a6LongestPeak {
    public static void main(String[] args) {
        int[] input = new int[] {1, 2, 3, 3, 4, 0, 10, 6, 5, -1, -3, 2, 3};
        System.out.println(longestPeak(input));

        input = new int[] {2,3,3,2,2,2,1};
        System.out.println(longestPeak(input));

    }

    public static int longestPeak(int[] array) {
        int highestPeakLength = 0;
        int i=1;

        while(i<array.length-1) {
            boolean isPeak = array[i+1]<array[i] && array[i-1]<array[i];
            if(!isPeak) {
                i = i+1;
                continue;
            }

            int left = i-2;
            while(left>=0 && array[left]<array[left+1]) {
                left = left -1;
            }
            int right = i+2;
            while(right<array.length && array[right]<array[right-1]) {
                right = right +1;
            }

            int currentPeakLenght = right - left - 1;
            if(currentPeakLenght > highestPeakLength) {
                highestPeakLength = currentPeakLenght;
            }

            i = right;
        }
        return highestPeakLength;
    }
}
