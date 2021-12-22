package com.algoexpert.medium;

public class c24CoinChangeNumberOfWays {
    public static int numberOfWaysToMakeChange(int n, int[] coins) {

        int[][] dp = new int[coins.length][n+1];
        for (int i = 0; i < coins.length; i++) {
            dp[i][0] = 1;
        }

        if(coins[0] == 1) {
            for (int j = 0; j <= n; j++) {
                dp[0][j] = 1;
            }
        } else if(coins[0] > 1){
            for (int j = 0; j <= n; j++) {
                if(j%coins[0]==0)
                    dp[0][j] = 1;
                else
                    dp[0][j] = 0;
            }
        }
        
        for (int i = 1; i < coins.length; i++) {
            for (int j = 1; j <= n; j++) {
                if(j<coins[i]) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i]];
                }
            }
        }
        
        return dp[coins.length-1][n];
    }

    //Time: O(n*coins) Space: O(n)
    public static int numberOfWaysToMakeChangeOptimized(int n, int[] coins) {

        int[] ways = new int[n + 1];
        ways[0] = 1;

        for (int denom : coins) {
            for (int amt = 1; amt < n+1; amt++) {
                if (denom <= amt) {
                    ways[amt] += ways[amt - denom];
                }
            }
        }
        return ways[n];
    }

    public static int numberOfWaysToMakeChangeForBigInput(int n, int coins) {

        int[] ways = new int[n + 1];
        ways[0] = 1;

        for (int denom = 1; denom <= coins; denom++) {
            for (int amt = 1; amt < n+1; amt++) {
                if (denom <= amt) {
                    ways[amt] += ways[amt - denom];
                }
            }
        }
        return ways[n];
    }

    public static void main(String[] args) {
        int[] input = {1, 5};
        System.out.println(numberOfWaysToMakeChangeOptimized(6, input));

        input = new int[]{2,3,7};
        System.out.println(numberOfWaysToMakeChangeOptimized(12, input));

        System.out.println(numberOfWaysToMakeChangeForBigInput(842, 91));       //expected output : 143119619
    }

}
