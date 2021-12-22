package com.algoexpert.medium;

public class a3MoveElementToEnd {
    public static void main(String[] args) {
        int[] result = moveElementToEnd(new int[]{2,1,2,2,2,3,4,2}, 2);
        result = moveElementToEnd(new int[]{3,3,3,3,3}, 3);
        System.out.println(result);

    }

    public static int[] moveElementToEnd(int[] array, int ele) {

        int right = array.length-1;
        for(int i=0;i<right;i++) {
            if(array[i]==ele) {
                while (i<right && array[right]==ele) {
                    right--;
                }
                if(i>right) {
                    break;
                }
                array[i]=array[right];
                array[right]=ele;
                right--;
            }
        }
        return array;
    }
}
