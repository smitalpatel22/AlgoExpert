package com.algoexpert.medium;

import java.util.Arrays;

public class a2MinimumDiffence {
    public static void main(String[] args) {
        int[] result = smallestDifference(new int[]{-1, 5, 10, 20, 28, 3}, new int[]{26, 134, 135, 15, 17});
        System.out.println(result);
        System.out.println(smallestDifference(new int[] {5,5,3,9,2}, new int[]{3,6,7,2,1}));
    }

    public static int[] smallestDifference(int[] red, int[] blue) {
        Arrays.sort(red);       //-1,3,5,10,20,28
        Arrays.sort(blue);      //15,17,26,134,135
        int[] result = new int[2];
        int i=0,j=0;
        int diff=Integer.MAX_VALUE;
        while(i<red.length && j<blue.length){
            if(Math.abs(red[i]-blue[j])<diff) {
                diff=Math.abs(red[i]-blue[j]);
                result[0] = red[i];
                result[1] = blue[j];
            }
            if(red[i]-blue[j]<0) {
                i++;
            } else if(red[i]-blue[j]>0){
                j++;
            } else {
                return new int[]{red[i], blue[j]};
            }
        }
        return result;

    }
}
