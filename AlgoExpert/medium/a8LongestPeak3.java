package com.algoexpert.medium;

import java.math.BigInteger;

public class a8LongestPeak3 {
    public static void main(String[] args) {
//        int[] input = new int[] {1, 2, 3, 3, 4, 0, 10, 6, 5, -1, -3, 2, 3};
//        System.out.println(longestPeak(input));

        StringBuilder s = new StringBuilder();
        for(int i=0;i<400000;i++) {
            s.append(1);
        }
        String input =s.toString();
        System.out.println(solution(input));


    }

    public static int solution(String input) {
        int opsCount = 0;
//        int actual=Integer.parseInt(input,2);

        BigInteger zeroBig = new BigInteger("0");
        BigInteger actual = zeroBig;

        // Initializing base value to 1,
        // i.e 2^0
        BigInteger base = new BigInteger("1");

        int len = input.length();
        BigInteger twoBig = new BigInteger("2");
        for (int i = len - 1; i >= 0; i--) {
            if (input.charAt(i) == '1')
                actual = actual.add(base);
            base = base.multiply(twoBig);
        }

        while (true) {
            int i = actual.compareTo(zeroBig);
            if (i==0) break;
            boolean even = actual.mod(twoBig).compareTo(zeroBig) == 0;
            if(even) {
                actual = actual.divide(twoBig);
            } else {
                actual = actual.subtract(new BigInteger("1"));
            }
            opsCount++;
        }
        return opsCount;
    }
}
