package com.algoexpert.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class a1SameBSTs2 {

    //Time : n^2 || Space : d ==> depth ==> worst space is n when only one branch in tree
    //For each n element we almost travel n other nodes so n^2
    //But we are not creating sub-arrays here. Instead we just have similar call stack as previous solution which will take d=depth space.
    public static boolean sameBstsByOptimal(List<Integer> arrayOne, List<Integer> arrayTwo) {
        return sameBstsRecursive(arrayOne, arrayTwo, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static boolean sameBstsRecursive(List<Integer> arrayOne, List<Integer> arrayTwo, int rootIdx1, int rootIdx2, int minVal, int maxVal) {

        if(rootIdx1==-1 || rootIdx2==-1) {
            return rootIdx1 == rootIdx2;
        }

        if(arrayOne.get(rootIdx1) != arrayTwo.get(rootIdx2)) {
            return false;
        }

        int leftRootIdx1 = getIdxOfFirstSmaller(arrayOne, rootIdx1, minVal);
        int leftRootIdx2 = getIdxOfFirstSmaller(arrayTwo, rootIdx2, minVal);
        int rightRootIdx1 = getIdxOfFirstEqualOrBigger(arrayOne, rootIdx1, maxVal);
        int rightRootIdx2 = getIdxOfFirstEqualOrBigger(arrayTwo, rootIdx2, maxVal);

        int currentVal = arrayOne.get(rootIdx1);
        boolean leftSame = sameBstsRecursive(arrayOne, arrayTwo, leftRootIdx1, leftRootIdx2, minVal, currentVal);       //as you go left, the min value is constant(suppose Int.MIN) whereas the max value keeps changing
        boolean rightSame = sameBstsRecursive(arrayOne, arrayTwo, rightRootIdx1, rightRootIdx2, currentVal, maxVal);    //Opposite of above comment

        return leftSame && rightSame;
    }

    private static int getIdxOfFirstSmaller(List<Integer> array, int startIdx, int minVal) {
        OptionalInt firstSmallId = IntStream.range(startIdx + 1, array.size())
                .filter(i -> array.get(i) >= minVal && array.get(i) < array.get(startIdx))
                .findFirst();
        if(firstSmallId.isPresent()) {
            return firstSmallId.getAsInt();
        } else {
            return -1;
        }
    }

    private static int getIdxOfFirstEqualOrBigger(List<Integer> array, int startIdx, int maxVal) {
        OptionalInt firsBigOrEqualId = IntStream.range(startIdx + 1, array.size())
                .filter(i -> array.get(i) >= array.get(startIdx) && array.get(i) < maxVal)
                .findFirst();
        if(firsBigOrEqualId.isPresent()) {
            return firsBigOrEqualId.getAsInt();
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        List<Integer> arrayOne = new ArrayList(Arrays.asList(10, 15, 8, 12, 94, 81, 5, 2, 11));
        List<Integer> arrayTwo = new ArrayList(Arrays.asList(10, 8, 5, 15, 2, 12, 11, 94, 81));
        boolean isSameBst = sameBstsByOptimal(arrayOne, arrayTwo);
        System.out.println(isSameBst);
    }
}
