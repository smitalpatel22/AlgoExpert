package com.algoexpert.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class d33RemoveIslands {

    //Space : O(w*h) || Time : O(w*h)
    //In case all elements in input matrix are 1, then all co-ordinates will be inside the stack.
    //But also we have created auxiliary matrix to save bordered islands which makes space used always O(w*h)
    //So it will never be less than O(w*h)
    public static int[][] removeIslands(int[][] matrix) {
        boolean[][] borderedIslands = new boolean[matrix.length][matrix[0].length];

        for(int i=0; i<matrix.length; i++) {
            traverseNodes(i, 0, matrix, borderedIslands);
        }

        for(int j=0; j<matrix[0].length; j++) {
            traverseNodes(0, j, matrix, borderedIslands);
        }

        for(int i=0; i<matrix.length; i++) {
            traverseNodes(i, matrix[0].length-1, matrix, borderedIslands);
        }

        for(int j=0; j<matrix[0].length; j++) {
            traverseNodes(matrix.length-1, j, matrix, borderedIslands);
        }

        for(int i=1; i<matrix.length-1; i++) {
            for (int j=1; j<matrix[0].length-1; j++) {
                if(!borderedIslands[i][j]) {
                    matrix[i][j] = 0;
                }
            }
        }
        return matrix;
    }

    private static void traverseNodes(int startRow, int startCol, int[][] matrix, boolean[][] borderedIslands) {
        Stack<int[]> nodesToExplore = new Stack<>();
        nodesToExplore.push(new int[]{startRow,startCol});
        while(!nodesToExplore.isEmpty()) {
            int[] currentNode = nodesToExplore.pop();
            int currRow = currentNode[0];
            int currCol = currentNode[1];
            if(borderedIslands[currRow][currCol]) {
                continue;
            }
            borderedIslands[currRow][currCol]=true;

            if(matrix[currRow][currCol]==1) {
                borderedIslands[currRow][currCol]=true;
            } else {
                continue;
            }
            int[][] unvisitedNeighbours = getUnvisitedNeighbours(currRow, currCol, matrix);
            for(int[] neighbour : unvisitedNeighbours) {
                int row = neighbour[0];
                int col = neighbour[1];
                if(matrix[row][col]==1) {
                    nodesToExplore.push(neighbour);
                }
            }
        }
    }

    private static int[][] getUnvisitedNeighbours(int row, int column, int[][] matrix) {
        List<int[]> unvisited = new ArrayList<>();

        if(row-1>=0) {
            unvisited.add(new int[]{row-1, column});   //UP
        }
        if(column-1>=0) {
            unvisited.add(new int[]{row, column-1});   //LEFT
        }
        if(row+1<matrix.length) {
            unvisited.add(new int[]{row+1, column});   //DOWN
        }
        if(column+1<matrix[0].length) {
            unvisited.add(new int[]{row, column+1});   //RIGHT
        }
        int[][] neighbours = new int[unvisited.size()][2];
        for(int i=0; i<unvisited.size(); i++) {
            neighbours[i] = unvisited.get(i);
        }
        return neighbours;
    }

    //Space : O(w*h) || Time : O(w*h)
    //Here worst/average space complexity may be same as other approach in case all elements in input matrix are 1.
    //And in such case all co-ordinates will be inside the stack. So Space occupied will be O(w*h) in stack.
    //But most of the time that will not be the case. So usual space time complexity will be few elements in stack.
    public static int[][] removeIslands2(int[][] matrix) {
        List<Integer> sizes = new ArrayList<>();

        for(int i=0; i<matrix.length; i++) {
            traverseNodes2(i, 0, matrix);
        }

        for(int j=0; j<matrix[0].length; j++) {
            traverseNodes2(0, j, matrix);
        }

        for(int i=0; i<matrix.length; i++) {
            traverseNodes2(i, matrix[0].length-1, matrix);
        }

        for(int j=0; j<matrix[0].length; j++) {
            traverseNodes2(matrix.length-1, j, matrix);
        }

        for(int i=0; i<matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j]==2) {
                    matrix[i][j] = 1;
                } else if(matrix[i][j]==1) {
                    matrix[i][j] = 0;
                }
            }
        }
        return matrix;
    }

    private static void traverseNodes2(int startRow, int startCol, int[][] matrix) {
        Stack<int[]> nodesToExplore = new Stack<>();
        nodesToExplore.push(new int[]{startRow,startCol});
        while(!nodesToExplore.isEmpty()) {
            int[] currentNode = nodesToExplore.pop();
            int currentRow = currentNode[0];
            int currentCol = currentNode[1];
            if(matrix[currentRow][currentCol]==2 || matrix[currentRow][currentCol]==0) {
                continue;
            }
            matrix[currentRow][currentCol]=2;

            int[][] unvisitedNeighbours = getUnvisitedNeighbours(currentRow, currentCol, matrix);
            for(int[] neighbour : unvisitedNeighbours) {
                int row = neighbour[0];
                int col = neighbour[1];
                if(matrix[row][col]==1) {
                    nodesToExplore.push(neighbour);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] input = {
                {1, 0, 0, 0, 0, 0},
                {0, 1, 0, 1, 1, 1},
                {0, 0, 1, 0, 1, 0},
                {1, 1, 0, 0, 1, 0},
                {1, 0, 1, 1, 0, 0},
                {1, 0, 0, 0, 0, 1},
        };
        int[][] output = removeIslands2(input);
        for (int i = 0; i < output.length; i++) {

            for (int j = 0; j < output[i].length; j++) {
                System.out.print(output[i][j] + " ");
            }
            System.out.print("\n");
        }
    }
}
