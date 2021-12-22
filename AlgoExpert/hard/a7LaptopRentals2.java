package com.algoexpert.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class a7LaptopRentals2 {

    public static int laptopRentals(ArrayList<ArrayList<Integer>> times) {

        if(times.size() == 0) {
            return 0;
        }

        int usedLaptops = 0;
        ArrayList<Integer> startTimes = new ArrayList<>();
        ArrayList<Integer> endTimes = new ArrayList<>();

        for(ArrayList<Integer> time : times) {
            startTimes.add(time.get(0));
            endTimes.add(time.get(1));
        }

        Collections.sort(startTimes);
        Collections.sort(endTimes);

        int startIterator = 0;
        int endIterator = 0;

        while(startIterator < times.size()) {
            if(startTimes.get(startIterator) >= endTimes.get(endIterator)) {
                usedLaptops -= 1;
                endIterator += 1;
            }
            usedLaptops += 1;
            startIterator += 1;
        }
        return usedLaptops;
    }

    public static void main(String[] args) {
        int[][] times = new int[][] {{0, 2}, {1, 4}, {4, 6}, {0, 4}, {7, 8}, {9, 11}, {3, 10}};
        ArrayList<ArrayList<Integer>> input = new ArrayList<>();
        for (int[] time : times) {
            input.add(new ArrayList(Arrays.asList(time[0], time[1])));
        }
        System.out.println(laptopRentals(input));
    }

}
