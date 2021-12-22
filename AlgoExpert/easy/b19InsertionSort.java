package com.algoexpert.easy;

public class b19InsertionSort {
    public static int[] insertionSort(int[] arr) {
        if(arr.length == 0) {
            return new int[]{};
        }

        for(int i=1; i<arr.length; i++) {
            int j = i;
            while(j>0 && arr[j] < arr[j-1]) {
                swap(arr, j, j-1);
                j-=1;
            }
        }
        return arr;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
