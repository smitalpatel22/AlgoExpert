package com.algoexpert.hard;

public class b15IndexEqualsValues {

    //1st approach is brute force of comparing index with element returning value when same ==> Time=n & space=1

    //2nd approach
    //Time: log(n) || Space: log(n)==> Recursive call stack space
    public static int indexEqualsValueRecursive(int[] array, int left, int right) {

        if(left > right) {
            return -1;
        }

        int mid = left + (right-left)/2;            //or simply mid = (left+right)/2
        int midVal = array[mid];
        if(midVal < mid) {
            return indexEqualsValueRecursive(array, mid+1, right);
        } else if (midVal == mid && mid == 0) {
            return mid;
        } else if(midVal ==mid && array[mid-1] < mid-1) {
            return mid;
        } else {
            return indexEqualsValueRecursive(array, left, mid-1);
        }
    }



    //3rd approach
    //Time: log(n) || Space: 1
    public static int indexEqualsValue(int[] array) {

        int left = 0, right=array.length-1;

        while(left <= right) {
            int mid = right + (left -  right)/2;        //or simply mid = (left+right)/2
            if(array[mid] < mid) {
                left = mid + 1;
            } else if (array[mid] == mid && mid == 0) {
                return mid;
            } else if(array[mid]==mid && array[mid-1] < mid-1) {
                return mid;
            } else {
                right = right - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] input = new int[] {-5, -3, 0, 3, 4, 5, 9};
        System.out.println(indexEqualsValue(input));

        input = new int[] {-12, 1, 2, 3, 12};
        System.out.println(indexEqualsValue(input));

        input = new int[] {-12, 1, 2, 3, 12};
        System.out.println(indexEqualsValueRecursive(input, 0, input.length-1));
    }
}
