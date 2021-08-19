package com.algoexpert.medium;

public class a4MonotonicArray {
    public static void main(String[] args) {
        System.out.println(isMonotonic(new int[]{-1,-1,-10,-1100,-1100,-1101,-1102,-9001}));
        System.out.println(isMonotonic(new int[]{-1,-1,-1,-1,-1}));
        System.out.println(isMonotonic(new int[]{1,2,0}));
        System.out.println(isMonotonic(new int[]{1,2}));
        System.out.println(isMonotonic(new int[]{1}));
    }

    public static boolean isMonotonic(int[] array) {
        if(array.length<=2) return true;
        int i=0;
        while(i<array.length-1 && array[i]==array[i+1]) {
            i++;
        }

        if(i<array.length-1) {
            String flow = "";
            if (array[i] > array[i + 1]) {
                flow = "DSC";
            } else {
                flow = "ASC";
            }

            for (i=i; i < array.length - 1; i++) {

                if (array[i] > array[i + 1]) {
                    if (flow.equals("ASC")) {
                        return false;
                    }
                } else if (array[i] < array[i + 1]) {
                    if (flow.equals("DSC")) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
