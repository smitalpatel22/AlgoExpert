package com.algoexpert.hard;

import java.util.ArrayList;
import java.util.Arrays;

public class a5MaximizeExpression {

    //Brute Force solution is to find max sum for all sub-matrices
    //Time : Widht*Heigh*size^2 ==> because for each bigger size, there will be more repeated elements.
    //For size=1, 1^2=1


    //Optimal approach:
    //Time : 4n~n || Space : 4n~n
    public static int maximizeExpression(int[] arr) {

        if(arr.length < 4) {
            return 0;
        }

        ArrayList<Integer> maxA = new ArrayList<>(Arrays.asList(arr[0]));
        ArrayList<Integer> maxAMinusB = new ArrayList<>(Arrays.asList(Integer.MIN_VALUE));
        ArrayList<Integer> maxAMinusBPlusC = new ArrayList<>(Arrays.asList(Integer.MIN_VALUE, Integer.MIN_VALUE));
        ArrayList<Integer> maxAMinusBPlusCMinusD = new ArrayList<>(Arrays.asList(Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE));

        for (int i = 1; i < arr.length; i++) {
            int currentMax = Math.max(maxA.get(i-1), arr[i]);
            maxA.add(currentMax);
        }

        for (int i = 1; i < arr.length; i++) {
            int currentMax = Math.max(maxA.get(i-1)-arr[i], maxAMinusB.get(i-1));
            maxAMinusB.add(currentMax);
        }

        for (int i = 2; i < arr.length; i++) {
            int currentMax = Math.max(maxAMinusB.get(i-1)+arr[i], maxAMinusBPlusC.get(i-1));
            maxAMinusBPlusC.add(currentMax);
        }

        for (int i = 3; i < arr.length; i++) {
            int currentMax = Math.max(maxAMinusBPlusC.get(i-1)-arr[i], maxAMinusBPlusCMinusD.get(i-1));
            maxAMinusBPlusCMinusD.add(currentMax);
        }

        return maxAMinusBPlusCMinusD.get(maxAMinusBPlusCMinusD.size()-1);

        //Directly using array

//        if(arr.length < 4) {
//            return 0;
//        }
//        int[] maxA = new int[arr.length];
//        maxA[0] = arr[0];
//        for (int i = 1; i < arr.length; i++) {
//            maxA[i] = Math.max(arr[i], maxA[i-1]);
//        }
//
//        int[] maxAminusB = new int[arr.length];
//        maxAminusB[1] = maxA[0]-arr[1];
//        for (int i = 2; i < arr.length; i++) {
//            maxAminusB[i] = Math.max(maxA[i-1]-arr[i], maxAminusB[i-1]);
//        }
//
//        int[] maxAminusBplusC = new int[arr.length];
//        maxAminusBplusC[2] = maxAminusB[1]+arr[2];
//        for (int i = 3; i < arr.length; i++) {
//            maxAminusBplusC[i] = Math.max(maxAminusB[i-1]+arr[i], maxAminusBplusC[i-1]);
//        }
//
//        int[] maxAminusBplusCminusD = new int[arr.length];
//        maxAminusBplusCminusD[3] = maxAminusBplusC[2]-arr[3];
//        for (int i = 4; i < arr.length; i++) {
//            maxAminusBplusCminusD[i] = Math.max(maxAminusBplusC[i-1]-arr[i], maxAminusBplusCminusD[i-1]);
//        }
//        return maxAminusBplusCminusD[maxAminusBplusCminusD.length-1];
    }

    public static void main(String[] args) {
        int[] array = new int[]{3, 6, 1, -3, 2, 7};
        System.out.println(maximizeExpression(array));
    }
}
