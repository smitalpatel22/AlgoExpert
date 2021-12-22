package com.algoexpert.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class b14ProductSum {
    public static void main(String[] args) {
        List<Object> test = new ArrayList<Object>(
                        Arrays.asList(
                                5,
                                2,
                                new ArrayList<Object>(Arrays.asList(7, -1)),
                                3,
                                new ArrayList<Object>(
                                        Arrays.asList(6, new ArrayList<Object>(Arrays.asList(-13, 8)), 4))));
        System.out.println(productSum(test));

        test = new ArrayList<>(
                        Arrays.asList(
                                1,
                                2,
                                new ArrayList<Object>(Arrays.asList(3)),
                                4,
                                5));
        System.out.println(productSum(test));
    }

    public static int productSum(List<Object> array) {

        return productSumUtility(array, 1);
    }

    public static int productSumUtility(List<Object> array, int depth) {
        int sum=0;
        for(Object ele : array) {
            if(ele instanceof ArrayList) {
                ArrayList<Object> ele1 = (ArrayList<Object>) ele;
                int result = productSumUtility(ele1, depth+1);
                sum = sum + result;
            } else {
                sum = sum + (int)ele;
            }
        }
            return sum * depth;
    }
}
