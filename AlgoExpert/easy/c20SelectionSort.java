package com.algoexpert.easy;

public class c20SelectionSort {
    public static int[] selectionSort(int[] arr) {
        // Write your code here.
        if(arr.length==0) return new int[] {};

        int startIdx = 0;

        while(startIdx < arr.length) {
            int smallestIdx = startIdx;
            for(int j=startIdx+1; j<arr.length; j++) {
                if(arr[smallestIdx] > arr[j]) {
                    smallestIdx = j;
                }
            }
            swap(arr, startIdx, smallestIdx);
            startIdx++;
        }
        return arr;
    }


    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
