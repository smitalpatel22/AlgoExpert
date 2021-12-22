package com.algoexpert.medium;

import java.util.*;

public class f50SunsetViews {

    //Time : O(n) || Space : O(n)
    //Space==n because to store n elements in output array
    public static ArrayList<Integer> sunsetViews(int[] buildings, String direction) {

        ArrayList<Integer> sunsetViewableBuildingIndices = new ArrayList<>();
        int idx = buildings.length-1;
        int step = -1;

        if(direction.equals("WEST")) {
            idx = 0;
            step = 1;
        }

        int heightestBuildingTillNow = 0;
        while(idx>=0 && idx<buildings.length) {
            int currHeight = buildings[idx];

            if(currHeight>heightestBuildingTillNow) {
                sunsetViewableBuildingIndices.add(idx);
                heightestBuildingTillNow = currHeight;
            }
            idx += step;
        }

        if(direction.equals("EAST")) {
            Collections.reverse(sunsetViewableBuildingIndices);
        }
        return sunsetViewableBuildingIndices;
    }

    //Time : O(n) || Space : O(n)
    //Space==n because to store n elements in output array
    public static ArrayList<Integer> sunsetViewsUsingStack(int[] buildings, String direction) {

        ArrayList<Integer> sunsetViewableBuildingIndices = new ArrayList<>();
        int idx = buildings.length-1;
        int step = -1;

        if(direction.equals("EAST")) {
            idx = 0;
            step = 1;
        }

        while(idx >= 0 && idx < buildings.length) {
            int currHeight = buildings[idx];

            //If height of currentBuilding is greater than or equal to height of last index inserted in output stack then keep
            //keep poping top of stack till that
            while(sunsetViewableBuildingIndices.size()>0
                    && currHeight >= buildings[sunsetViewableBuildingIndices.get(sunsetViewableBuildingIndices.size()-1)]) {
                sunsetViewableBuildingIndices.remove(sunsetViewableBuildingIndices.size()-1);
            }
            sunsetViewableBuildingIndices.add(idx);
            idx += step;
        }

        if(direction.equals("WEST")) {
            Collections.reverse(sunsetViewableBuildingIndices);
        }
        return sunsetViewableBuildingIndices;
    }

    public static void main(String[] args) {
        int[] buildings = new int[] {3, 5, 4, 4, 3, 1, 3, 2};
        String direction = "EAST";
        System.out.println(sunsetViews(buildings, direction));
    }
}
