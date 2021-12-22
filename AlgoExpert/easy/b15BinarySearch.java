package com.algoexpert.easy;

public class b15BinarySearch {
    public static void main(String[] args) {
        System.out.println(binarySearch(new int[] {0, 1, 21, 33, 45, 45, 61, 71, 72, 73}, 33));
        System.out.println(binarySearch(new int[] {0, 1, 21, 33, 45, 45, 61, 71, 72, 73}, 34));
        System.out.println(binarySearch(new int[] {1,5,23,111}, 111));
    }

    public static int binarySearch(int[] array, int target) {

        int length = array.length-1;
        int left=0,right=length;
        while(left<=right) {
            int halfPoint = (left + right)/2;
            if(array[halfPoint] == target) {
                return halfPoint;
            }
            if(target<array[halfPoint]) {
                right = halfPoint-1;
            } else {
                left = halfPoint+1;
            }
        }
        return -1;

    }
}
