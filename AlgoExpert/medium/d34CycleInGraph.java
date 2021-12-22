package com.algoexpert.medium;

public class d34CycleInGraph {

    public static boolean cycleInGraph(int[][] edges) {
        boolean visited[] = new boolean[edges.length];
        boolean currentlyInStack[] = new boolean[edges.length];
        for(int vertex=0; vertex<edges.length; vertex++) {
            if(visited[vertex]) {
                continue;
            }
            boolean containsCycle = isNodeInCycle(vertex, edges, visited, currentlyInStack);
            if(containsCycle) {
                return true;
            }
        }
        return false;
    }

    public static boolean isNodeInCycle(int vertex, int[][] edges, boolean[] visited, boolean[] currentlyInStack) {
        int[] edge = edges[vertex];
        for(int targetNode : edge) {
            if(visited[vertex] && currentlyInStack[vertex]) {
                return true;
            }
            visited[vertex] = true;
            currentlyInStack[vertex] = true;
            boolean nodeInCycle = isNodeInCycle(targetNode, edges, visited, currentlyInStack);
            if(!nodeInCycle) {
                currentlyInStack[vertex] = false;
            } else if(nodeInCycle || currentlyInStack[targetNode]) {
                return true;
            }
        }
        return false;
    }

    //Method 1 by AlgoExpert
    public static boolean isNodeInCycle2(int vertex, int[][] edges, boolean[] visited, boolean[] currentlyInStack) {
        visited[vertex] = true;
        currentlyInStack[vertex] = true;
        boolean nodeInCycle = false;
        int[] neighbors = edges[vertex];
        for(int targetNode : neighbors) {
            if(!visited[targetNode]) {
                nodeInCycle = isNodeInCycle2(targetNode, edges, visited, currentlyInStack);
            }
            if(nodeInCycle || currentlyInStack[targetNode]) {
                return true;
            }
        }
        currentlyInStack[vertex] = false;
        return false;
    }


    //Method 2 by AlgoExpert
    public static final int WHITE = 0;  //Unvisited
    public static final int GREY = 1;   //Currently in Recurssion Stack
    public static final int BLACK = 3;  //Finished ->Dont Consider this node as this node cannot give a back edge

    public static boolean cycleInGraphUsingColors(int[][] edges) {
        int colors[] = new int[edges.length];
        for(int vertex=0; vertex<edges.length; vertex++) {
            if(colors[vertex]==WHITE) {
                boolean containsCycle = isNodeInCycle3(vertex, edges, colors);
                if (containsCycle) {
                    return true;
                }
            }
        }
        return false;
    }

    //Method 2 by AlgoExpert
    public static boolean isNodeInCycle3(int vertex, int[][] edges, int[] colors) {
        colors[vertex] = GREY;
        if(edges[vertex].length==0) {               //This if block can be removed. Its just an optimization to their code.
            colors[vertex] = BLACK;
            return false;
        }
        int[] neighbors = edges[vertex];
        for(int targetNode : neighbors) {
            if(colors[targetNode]==BLACK) {
                continue;
            }
            if(colors[targetNode]==GREY) {
                return true;
            }
            boolean nodeInCycle = isNodeInCycle3(targetNode, edges, colors);
            if(nodeInCycle) {
                return true;
            }
        }
        colors[vertex]=BLACK;
        return false;
    }

    public static void main(String[] args) {
        int[][] input =
                new int[][] {
                        {1, 3},
                        {2, 3, 4},
                        {0},
                        {},
                        {2, 5},
                        {}
                };
        System.out.println(cycleInGraphUsingColors(input));
        input =
                new int[][]{
                        {1},
                        {2, 3, 4, 5, 6, 7},
                        {},
                        {2, 7},
                        {5},
                        {},
                        {4},
                        {}
                };
        System.out.println(cycleInGraphUsingColors(input));
    }
}
