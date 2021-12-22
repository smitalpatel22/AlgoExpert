package com.algoexpert.easy;

public class b18BubbleSort {
    public static int[] bubbleSort(int[] array) {
        if(array.length==0) {
            return new int[]{};
        }
        boolean isSorted = false;
        int counter = 0;
        while(!isSorted) {
            isSorted = true;
            for(int i=0; i<array.length-1-counter; i++) {
                if(array[i] > array[i+1]) {
                    swap(array, i, i+1);
                    isSorted = false;
                }
            }
            counter++;
        }
        return array;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
