package com.algoexpert.easy;

import java.util.Arrays;

public class b17TandemCycle {
    public static void main(String[] args) {
        System.out.println(findMaxMin(new int[] {5,5,3,9,2}, new int[]{3,6,7,2,1},true));
        System.out.println(findMaxMin(new int[] {5,5,3,9,2}, new int[]{3,6,7,2,1},false));
//        System.out.println(findMaxMin(new int[] {0, 1, 21, 33, 45, 45, 61, 71, 72, 73}));
//        System.out.println(findMaxMin(new int[] {1,5,23,111}));
//        System.out.println(findMaxMin(new int[] {-1, -2, -3, -7, -17, -27, -18, -541, -8, -7, 7}));
    }

    public static int findMaxMin(int[] red, int[] blue, boolean fastest) {
        Arrays.sort(red);
        Arrays.sort(blue);

        if(fastest) {
            for (int i = 0, j = red.length - 1; i < j; i++, j--) {
                int temp = blue[j];
                blue[j] = blue[i];
                blue[i] = temp;
            }
        }

        int totalSpeed = 0;
        for(int i=0;i<red.length;i++) {
            int redSpeed = red[i];
            int blueSpeed = blue[i];
            totalSpeed += Math.max(redSpeed,blueSpeed);
        }

        return totalSpeed;

    }
}
