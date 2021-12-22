package com.algoexpert.medium;

import java.util.Arrays;

public class c25CoinChangeMinimumCoins {


    //Time: O(n*coins) Space: O(n)
    public static int numberOfWaysToMakeChangeOptimized(int n, int[] coins) {

        int[] minCoins = new int[n + 1];
        Arrays.fill(minCoins, Integer.MAX_VALUE);
        minCoins[0] = 0;
        int toCompare;

        for (int denom : coins) {
            for (int amt = 0; amt < minCoins.length; amt++) {
                if (denom <= amt) {
                    if(minCoins[amt-denom] == Integer.MAX_VALUE) {
                        toCompare = minCoins[amt-denom];
                    } else {
                        toCompare = 1 + minCoins[amt-denom];
                    }
                    minCoins[amt] = Math.min(minCoins[amt], toCompare);
                }
            }
        }
        return minCoins[n]!=Integer.MAX_VALUE ?  minCoins[n] : -1;
    }

    public static void main(String[] args) {
        int[] input = {1, 5, 10};
        System.out.println(numberOfWaysToMakeChangeOptimized(10, input));

        input = new int[]{2,3,7};
        System.out.println(numberOfWaysToMakeChangeOptimized(12, input));
    }

}
