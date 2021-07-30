package com.algoexpert.easy;

import java.util.Arrays;

public class a8NonConstructibleChange {
    public static int nonConstructibleChange(int[] coins) {
        Arrays.sort(coins);
        if(coins.length==0 || coins[0]!= 1) {
            return 1;
        }
        int sum=0;
        for(int i = 0; i<coins.length; i++) {
            sum = sum + coins[i];

            if(i+1<coins.length && coins[i+1] > sum+1) {
                return sum+1;
            }
        }

        return sum+1;
    }

    public static void main(String[] args) {
        int[] input = new int[] {5, 7, 1, 1, 2, 3, 22};
        int actual = nonConstructibleChange(input);
        System.out.println("\nActual: "+actual+"\nExpected: 20");

        input = new int[] {1, 1, 1, 1, 1};
        actual = nonConstructibleChange(input);
        System.out.println("\nActual: "+actual+"\nExpected: 6");

        input = new int[0];
        actual = nonConstructibleChange(input);
        System.out.println("\nActual: "+actual+"\nExpected: 6");
    }
}
