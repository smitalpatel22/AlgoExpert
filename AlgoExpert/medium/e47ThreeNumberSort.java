package com.algoexpert.medium;

public class e47ThreeNumberSort {

    //Time : n || Space : 1 (although here we are using 1 array of size 3)
    //Passes : 2
    //Approach : BucketSort
    public static int[] threeNumberSort1(int[] array, int[] order) {

        int valueCounts[] = new int[]{0,0,0};

        for (int i = 0; i < array.length; i++) {
            if(array[i]==order[0]) {
                valueCounts[0]++;
            } else if(array[i]==order[1]) {
                valueCounts[1]++;
            } else {
                valueCounts[2]++;
            }
        }

        int offset=0;
        for (int i=0; i<3; i++) {
            int value = order[i];
            int count = valueCounts[i];
            while(offset<array.length && count>0) {
                array[offset] = value;
                offset++;
                count--;
            }
        }
        return array;
    }

    //Time : n || Space : 1
    //Passes : 2
    //Approach :
    // Pass1 : Loop from start & bring first-order value to the start of the array
    // Pass2 : Loop from end & bring the third-order value to the end of the array
    public static int[] threeNumberSort2(int[] array, int[] order) {

        int firstValue = order[0];
        int thirdValue = order[2];

        int firstIdx = 0;

        for (int i = 0; i < array.length; i++) {
            if(array[i] == firstValue) {
                swap(i, firstIdx, array);
                firstIdx++;
            }
        }

        int thirdIdx = array.length-1;
        for (int i = array.length-1; i>0; i--) {
            if(array[i]==thirdValue) {
                swap(i, thirdIdx, array);
                thirdIdx--;
            }
        }

        return array;
    }

    //Time : n || Space : 1
    //Approach :
    // Use 3 pointers : 2 from start and 3rd from last
    //Passes : 1
    public static int[] threeNumberSort3(int[] array, int[] order) {
        int firstIdx=0;
        int secondIdx=0;
        int thirdIdx=array.length-1;

        int firstVal = order[0];
        int secondVal = order[1];

        while(secondIdx<=thirdIdx) {

            int value = array[secondIdx];
            if(value == firstVal) {
                swap(secondIdx, firstIdx, array);
                firstIdx++;
                secondIdx++;
            } else if(value == secondVal) {
                secondIdx++;
            } else {
                swap(secondIdx, thirdIdx, array);
                thirdIdx--;
            }
        }
        return array;
    }

    public static void swap(int idx1, int idx2, int[] array) {
        int temp = array[idx1];
        array[idx1] = array[idx2];
        array[idx2] = temp;
    }

    public static void main(String[] args) {
        int[] array = {1, 0, 0, -1, -1, 0, 1, 1};
        int[] order = {0,1,-1};
        int[] output = threeNumberSort3(array, order);
        System.out.println(""+output);
    }
}
