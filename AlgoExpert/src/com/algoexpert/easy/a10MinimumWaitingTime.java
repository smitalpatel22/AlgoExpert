package com.algoexpert.easy;

import java.util.Arrays;

public class a10MinimumWaitingTime {

    public static void main(String[] args) {
        int[] queries = {3,2,1,2,6};
        System.out.println(minimumWaitingTime(queries));
    }

    public static int minimumWaitingTime(int[] queries) {
        Arrays.sort(queries);
        int sum = 0;
        for(int i=0; i<queries.length-1; i++) {
            sum += queries[i]*(queries.length-i-1);
        }
        return sum;
    }
}
