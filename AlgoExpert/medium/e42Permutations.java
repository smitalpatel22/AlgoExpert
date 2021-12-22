package com.algoexpert.medium;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class e42Permutations {

    //Method 1:
    //Upper Bound : O(n!*n^2) time || O(n*n!) space
    // Time:
    // Recurssion Tree will have n! nodes as n! permutations are there(n!).
    // And Each recursion branch will call helper method for 1 element each(n)
    // and for each we are doing for loop and creating permutations n times(n).
    // So total time complexity is n!*n^2
    // Space:
    // Each of n! permutation will have n elements & even for recursion call stack its same n*n!. So Space complexity is n!*n
    //Roughly : O(n!*n) time || O(n!*n) space
    public static List<List<Integer>> getPermutations(List<Integer> array) {
        List<List<Integer>> permutations = new ArrayList<>();
        getPermutationsHelper(array, new ArrayList<Integer>(), permutations);
        return permutations;
    }

    private static void getPermutationsHelper(List<Integer> array, List<Integer> currentPerm, List<List<Integer>> permutations) {

        if(array.isEmpty() && currentPerm.size()>0) {
            permutations.add(currentPerm);
        } else {
            for(int i=0; i<array.size(); i++) {
                List<Integer> currentElementRemovedArray = new ArrayList<>(array);
                Integer element = currentElementRemovedArray.remove(i);
                List<Integer> newPermutation = new ArrayList<>(currentPerm);
                newPermutation.add(element);
                getPermutationsHelper(currentElementRemovedArray, newPermutation, permutations);
            }
        }
    }

    //Method 2:
    //here we try to rearrange the input array itself to save space
    //O(n*n!) time || O(n*n!) space
    //O(n*n!) time because in we have same n*n! call stack but we do only O(1) operations in the for loop
    public static List<List<Integer>> getPermutationsOptimized(List<Integer> array) {
        List<List<Integer>> permutations = new ArrayList<>();
        getPermutationsHelper2(0, array, permutations);
        return permutations;
    }

    private static void getPermutationsHelper2(int currentPosition, List<Integer> array, List<List<Integer>> permutations) {
        if(currentPosition==array.size()-1) {       //if its the last position
            permutations.add(new ArrayList<>(array));
        } else {
            for(int i=currentPosition; i<array.size(); i++) {
                swap(array, currentPosition, i);
                getPermutationsHelper2(currentPosition+1, array, permutations);
                swap(array, currentPosition, i);
            }
        }
    }

    private static void swap(List<Integer> array, int i, int j) {
        int temp = array.get(i);
        array.set(i, array.get(j));
        array.set(j, temp);
    }

    public static void main(String[] args) {
        List<Integer> input = new ArrayList<Integer>(Arrays.asList(1, 2, 3));
        List<List<Integer>> perms = getPermutationsOptimized(input);
        System.out.println(perms);
    }
}