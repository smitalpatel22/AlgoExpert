package com.algoexpert.hard;

import java.util.HashMap;

public class b14AmbiguosMeasurements {

    //Time : low*high*n ==> n=number of measuring cups
    //Space: low*high
    //Time: low*high*n ==> Suppose if only 1 measuring cup we have [1,1] then we will have to call our recursive funtion low*high * 1 cup times as only
    //then we can reach our conclusion. So that is why we will have Time=low*high*n
    //Space: low*high ==> Our memoization will have number of keys = low*high entries, because we have to account for all
    //possible combinations of low ranges & high ranges that we could have. So max amount of keys  we can have is low*high
    //to determine that many results
    //Both complexities are worst possible i.e. max upperbound & not very precise.
    public static boolean ambiguousMeasurements(int[][] measuringCups, int low, int high) {
        HashMap<String, Boolean> memoization = new HashMap<>();
        return canMeasureInRange(measuringCups, low, high, memoization);
    }

    private static boolean canMeasureInRange(int[][] measuringCups, int low, int high, HashMap<String, Boolean> memoization) {
        String memoizeKey = createHashableKey(low, high);
        if(memoization.containsKey(memoizeKey)) {
            return memoization.get(memoizeKey);
        }
        if(low <= 0 && high <=0) {      //because we cannot measure negative values
            return false;
        }

        boolean canMeasure = false;
        for(int[] cup : measuringCups) {
            int cupLow = cup[0];
            int cupHigh = cup[1];

            if(low<=cupLow && cupHigh<=high) {
                canMeasure=true;
                break;
            }

            canMeasure = canMeasureInRange(measuringCups, low-cupLow, high-cupHigh, memoization);
            if(canMeasure) break;
        }

        memoization.put(memoizeKey, canMeasure);
        return canMeasure;
    }

    private static String createHashableKey(int low, int high) {
        return low +":"+ high;
    }

    public static void main(String[] args) {
        int[][] cups = new int[][] {{200, 210}, {450, 465}, {800, 850}};
        int low = 2100;
        int high = 2300;
        boolean expected = true;
        System.out.println(ambiguousMeasurements(cups, low, high));
    }
}
