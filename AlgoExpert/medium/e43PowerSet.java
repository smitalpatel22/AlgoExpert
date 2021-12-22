package com.algoexpert.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class e43PowerSet {

    //If we had 0 element in input, we will have 1 length output
    //If we had 1 then 2
    //If we had 2 then 4
    //So we have to double time-complexity each time as we had to iterate everytime the current calculated powerset
    //This takes us to 2^n timecomplexcity.
    //And we have to append each time to the previous subset, so minimum subset len could be 0 and maximum can be n. So avg is n/2
    //Total Time Complexcity is (2^n) * (n/2) ~~~ n*2^n
    //Same Space complexity we will have, avg elements in each will be n/2 and we will have 2^n combinations
    // Time : n*2^n | Space: n*2^n
    public static List<List<Integer>> powersetIterative(List<Integer> array) {

        List<List<Integer>> powerset = new ArrayList<>();
        powerset.add(new ArrayList<>());
        for (int ele : array) {
            int previousSize = powerset.size();
            for(int j=0; j<previousSize; j++) {
                List<Integer> newSet = new ArrayList<>(powerset.get(j));
                newSet.add(ele);
                powerset.add(newSet);
            }
        }
        return powerset;
    }

    // Time : n*2^n | Space: n*2^n
    public static List<List<Integer>> powersetRecursive(List<Integer> array) {
        return powersetRecursiveHelper(array, array.size()-1);
    }

    public static List<List<Integer>> powersetRecursiveHelper(List<Integer> array, int idx) {
        if(idx<0) {
            List<List<Integer>> emptySet = new ArrayList<>();
            emptySet.add(new ArrayList<>());
            return emptySet;
        }
        int ele = array.get(idx);
        List<List<Integer>> subsets = powersetRecursiveHelper(array, idx-1);
        int length = subsets.size();
        for(int i=0;i<length; i++) {
            List<Integer> newSubset = new ArrayList<>(subsets.get(i));
            newSubset.add(ele);
            subsets.add(newSubset);
        }
        return subsets;
    }



    public static void main(String[] args) {
        List<Integer> input = new ArrayList<Integer>(Arrays.asList(1, 2, 3));
        List<List<Integer>> powerset = powersetIterative(input);
        System.out.println(powerset);
    }
}