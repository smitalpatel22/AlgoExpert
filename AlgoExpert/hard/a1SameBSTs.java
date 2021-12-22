package com.algoexpert.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class a1SameBSTs {

    //Time : n^2 || Space : n^2
    //For each n element we almost travel & create n other nodes & a sub-array containing almost n other element
    //That is why space & time complexity is n^2
    public static boolean sameBstsByCreatingSubArrays(List<Integer> arrayOne, List<Integer> arrayTwo) {
        if(arrayOne.size()==0 && arrayTwo.size()==0) {
            return true;
        }
        if(arrayOne.get(0) != arrayTwo.get(0) || arrayOne.size()!=arrayTwo.size()) {
            return false;
        }

        List<Integer> leftSubTree1 = getLeftSubTree(arrayOne);
        List<Integer> leftSubTree2 = getLeftSubTree(arrayTwo);
        List<Integer> rightSubTree1 = getRightSubTree(arrayOne);
        List<Integer> rightSubTree2 = getRightSubTree(arrayTwo);

        boolean left = sameBstsByCreatingSubArrays(leftSubTree1, leftSubTree2);
        boolean right = sameBstsByCreatingSubArrays(rightSubTree1, rightSubTree2);

        return left && right;
    }

    private static List<Integer> getRightSubTree(List<Integer> array) {
        return IntStream.range(1, array.size())
                .filter(ele -> array.get(ele) >= array.get(0))
                .mapToObj(i -> array.get(i))
                .collect(Collectors.toList());
    }

    private static List<Integer> getLeftSubTree(List<Integer> array) {
        return IntStream.range(1, array.size())
                .filter(ele -> array.get(ele) < array.get(0))
                .mapToObj(i -> array.get(i))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Integer> arrayOne = new ArrayList(Arrays.asList(10, 15, 8, 12, 94, 81, 5, 2, 11));
        List<Integer> arrayTwo = new ArrayList(Arrays.asList(10, 8, 5, 15, 2, 12, 11, 94, 81));
        boolean isSameBst = sameBstsByCreatingSubArrays(arrayOne, arrayTwo);
        System.out.println(isSameBst);
    }
}
