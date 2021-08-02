package com.algoexpert.easy;

public class a9SortedSquaredArray {
    public static void main(String[] args) {
        int[] input = new int[] {1,2,3,5,6,8,9};
        int[] actual = sortedSquaredArray(input);
        System.out.println("\nActual: "+actual+"\nExpected: 20");
    }

    public static int[] sortedSquaredArray(int[] array) {
        int[] output = new int[array.length];
        int smallIndx = 0;
        int largeIndx = array.length-1;
        for (int i = largeIndx; i >=0; i--) {
            int smallValue = array[smallIndx];
            int largeValue = array[largeIndx];
            if(Math.abs(smallValue) > Math.abs(largeValue)) {
                output[i] = smallValue * smallValue;
                smallIndx++;
            } else {
                output[i] = largeValue * largeValue;
                largeIndx--;
            }
        }
        return output;
    }
}
