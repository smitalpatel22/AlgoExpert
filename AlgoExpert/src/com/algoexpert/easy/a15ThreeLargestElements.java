package com.algoexpert.easy;

public class a15ThreeLargestElements {
    public static void main(String[] args) {
        System.out.println(find3LargestElement(new int[] {3,8,8,2,9,5,4}));
        System.out.println(find3LargestElement(new int[] {0, 1, 21, 33, 45, 45, 61, 71, 72, 73}));
        System.out.println(find3LargestElement(new int[] {1,5,23,111}));
        System.out.println(find3LargestElement(new int[] {-1, -2, -3, -7, -17, -27, -18, -541, -8, -7, 7}));
    }

    public static int[] find3LargestElement(int[] array) {

        int a=Integer.MIN_VALUE,b=Integer.MIN_VALUE,c=Integer.MIN_VALUE;
        for(int i=0;i<array.length;i++) {
            if(array[i]>c) {
                a=b;
                b=c;
                c=array[i];
            } else if(array[i]>b) {
                a=b;
                b=array[i];
            } else if(array[i]>a) {
                a=array[i];
            }
        }
        System.out.println(a+" : "+b+" : "+c);

        return new int[]{a,b,c};
    }
}
