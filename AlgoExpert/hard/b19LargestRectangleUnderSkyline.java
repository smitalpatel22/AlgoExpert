package com.algoexpert.hard;

import java.util.ArrayList;
import java.util.Stack;

public class b19LargestRectangleUnderSkyline {

    //Time: n^2 || Space: 1
    public int largestRectangleUnderSkylineNonOptimized(ArrayList<Integer> buildings) {

        int maxArea = 0;
        for (int i = 0; i < buildings.size(); i++) {
            Integer currHeight = buildings.get(i);

            int furthestLeft = i;
            while (furthestLeft>0 && buildings.get(furthestLeft-1) >= currHeight) {
                furthestLeft -= 1;
            }

            int furthestRight = i;
            while(furthestRight < buildings.size()-1 && buildings.get(furthestRight+1) >= currHeight) {
                furthestRight += 1;
            }

            int areaWithCurrentBuilding = (furthestRight - furthestLeft + 1) * currHeight;
            maxArea = Math.max(areaWithCurrentBuilding, maxArea);
        }
        return maxArea;
    }

    //Time: 3n~n || Space: n ==> Time : 3n == iterate n elements, push max n elements in stack & pop max n elements
    public int largestRectangleUnderSkylineUsingStack(ArrayList<Integer> buildings) {
        Stack<Integer> pillarIndices = new Stack<>();
        int maxArea = 0;

        ArrayList<Integer> extendedBuildings = new ArrayList<>(buildings);
        extendedBuildings.add(0);

        for (int idx = 0; idx < extendedBuildings.size(); idx++) {
            int height = extendedBuildings.get(idx);

            while(!pillarIndices.isEmpty() && extendedBuildings.get(pillarIndices.peek())>=height) {
                int pillarHeight = extendedBuildings.get(pillarIndices.pop());
                int width = pillarIndices.isEmpty() ? idx : idx - pillarIndices.peek() - 1;
                maxArea = Math.max(width*pillarHeight, maxArea);
            }
            pillarIndices.push(idx);
        }
        return maxArea;
    }
}
