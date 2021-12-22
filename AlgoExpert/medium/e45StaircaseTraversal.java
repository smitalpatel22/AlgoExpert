package com.algoexpert.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class e45StaircaseTraversal {

    //Time : k^n || Space : n(call stack)    ==> k=Max Steps && n=height
    //Time : k^n : if k=2 and n=4 then recursion(4)
    //                               /         \
    //                             rec(3)      rec(2)
    //                             /  \         /   \
    //                         rec(2) rec(1) rec(1) rec(0)
    //                         /   \
    //                      rec(1) rec(0)
    //Here the height of tree will be n
    //Number of branches from each call can be K and each branch will make another K calls. So its like k*k*k*.....
    //So the time complexity is K^n
    //Space : n because height of the call tree is n and at a point max n nodes can be there. For eg. rec(4),3,2,1.
    //For next calls, first this calls will get returned. Only then other branches will be made.
    public static int staircaseTraversal(int height, int maxSteps) {
        return noOfWaysToTopMethod1(height, maxSteps);
    }

    public static int noOfWaysToTopMethod1(int height, int maxSteps) {
        //Base Case
        if(height <= 1) {
            return 1;
        }

        int output = 0;
        for(int s=1; s<Math.min(maxSteps,height)+1 ; s++) {
            output += noOfWaysToTopMethod1(height-s, maxSteps);
        }
        // Write your code here.
        return output;
    }

    //Time: K*n || Space: n
    //Just a modification of the previous method.
    //Time : K*n
    //Many of the recursive calls & sub-recursive calls will be saved.
    //Only K*n calls will be made.
    //For Each of the heights, we need to sum atmost K other elements together
    //For tree of height of n, we need to sum K elements i.e. each one of recursive calls need to do K work.
    //Space : n because the Map data structure & call stack
    public static int staircaseTraversalMethod2(int height, int maxSteps) {
        Map<Integer, Integer> memoize = new HashMap();
        memoize.put(0, 1);
        memoize.put(1, 1);
        return noOfWaysToTopMethod2(height, maxSteps, memoize);
    }


    public static int noOfWaysToTopMethod2(int height, int maxSteps, Map<Integer, Integer> memoize) {
        int output = 0;
        for(int s=1; s<Math.min(maxSteps,height)+1 ; s++) {
            Integer ways = memoize.get(height - s);
            if(ways != null) {
                output += ways;
            } else {
                ways = noOfWaysToTopMethod2(height - s, maxSteps, memoize);
                memoize.put(height-s, ways);
                output += ways;
            }
        }
        return output;
    }

    //Time : K*n || Space : n
    //Method 3 ==> DP
    public static int staircaseTraversalMethod3DymamicProg(int height, int maxSteps) {
        int[] ways = new int[height+1];
        ways[0] = 1;
        ways[1] = 1;

        for(int currentHeight=2; currentHeight<height+1; currentHeight++) {
            int j=currentHeight-maxSteps;
            int tempSum = 0;
            while(j<currentHeight) {
                if(j>=0) {
                    tempSum += ways[j];
                }
                j++;
            }
            ways[currentHeight] = tempSum;
        }
        return ways[height];
    }

    public static int staircaseTraversalMethod3DymamicProgTheirWay(int height, int maxSteps) {
        int[] ways = new int[height+1];
        ways[0] = 1;
        ways[1] = 1;

        for(int currentHeight=2; currentHeight<height+1; currentHeight++) {

            int step = 1;    // subtract 1 step
            while(step<=maxSteps && step<=currentHeight) {
                ways[currentHeight] += ways[currentHeight-step];       //Go back 1 more step until maxSteps & add in current step
                step++;
            }
        }
        return ways[height];
    }

    //Time : n || Space : n
    //Time n because we have to do constant amount of work for each of the n heights
    //Space n because of the auxiliary data structure to store the ways.
    public static int staircaseTraversalMethod4SlidingWindow(int height, int maxSteps) {
        ArrayList<Integer> ways = new ArrayList<>();
        ways.add(1);

        int currentWays = 0;
        for(int currentHeight=1; currentHeight<height+1; currentHeight++) {
            int startOfWindow = currentHeight-maxSteps-1;
            int endOfWindow = currentHeight-1;

            if(startOfWindow >= 0) {
                currentWays -= ways.get(startOfWindow);
            }

            currentWays += ways.get(endOfWindow);
            ways.add(currentWays);
        }
        return ways.get(height);
    }

    public static void main(String[] args) {
        System.out.println(staircaseTraversalMethod4SlidingWindow(4,2));
    }
}
