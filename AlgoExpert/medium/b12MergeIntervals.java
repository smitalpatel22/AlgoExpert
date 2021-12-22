package com.algoexpert.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class b12MergeIntervals {

    public static void main(String[] args) {
        int[][] intervals = new int[][] { {1, 2},  {3, 5}, {4, 7}, {6, 8}, {9, 10} };
        int[][] output = mergeIntervals(intervals);

        intervals = new int[][] {     {89, 90}, {-10, 20}, {-50, 0}, {70, 90}, {90, 91}, {90, 95} };
        output = mergeIntervals(intervals);
        System.out.println(output);
    }

    private static int[][] mergeIntervals(int[][] intervals) {

        int[][] sortedIntervals = intervals.clone();
        Arrays.sort(sortedIntervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> mergedIntervals = new ArrayList<>();
        int[] currentInterval = sortedIntervals[0];
        mergedIntervals.add(currentInterval);
        for(int[] next : sortedIntervals) {
            int currentEnd = currentInterval[1];
            int nextStart = next[0];
            int nextEnd = next[1];

            if(currentEnd >= nextStart) {
                currentInterval[1] = Math.max(currentEnd, nextEnd);
            } else {
                currentInterval = next;
                mergedIntervals.add(currentInterval);
            }
        }


        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }
}
