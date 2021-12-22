package com.algoexpert.medium;

import java.util.*;

public class d35MinimumPassesOfMatrix {

    //O(w*h) || O(w*h)
    public static int minimumPassesOfMatrixToConvertNegativesUsingQueue(int[][] matrix) {
        int passes = convertNegativesUsingOnly1Queue(matrix);
//        int passes = convertNegativesUsing2Queues(matrix);
        return containsAllPositives(matrix) ? passes-1 : -1;
    }

    private static int convertNegativesUsingOnly1Queue(int[][] matrix) {

        int passes = 0;
        Queue<int[]> queue = getAllPositivePositions(matrix);       //Only Queue can be used as same DS saves current & next pass
                                                                    //elements & so they cannot be picked up in LIFO manner
        while (queue.size()>0) {                                    //like in stack otherwise next-pass elements will be picked first.
            int currentSize = queue.size();

            while(currentSize > 0) {
                int[] currentCoord = queue.remove();
                int currRow = currentCoord[0];
                int currCol = currentCoord[1];

                ArrayList<int[]> neighbors = getNeighbors(matrix, currRow, currCol);

                for(int[] neighbor : neighbors) {
                    int adjRow = neighbor[0];
                    int adjCol = neighbor[1];
                    int adjVal = matrix[adjRow][adjCol];

                    if(adjVal<0) {
                        matrix[adjRow][adjCol] = adjVal * -1;
                        queue.add(new int[]{adjRow, adjCol});
                    }
                }
                currentSize -= 1;
            }
            passes+=1;
        }
        return passes;
    }

    private static int convertNegativesUsing2Queues(int[][] matrix) {

        int passes = 0;
        Queue<int[]> nextPassQueue = getAllPositivePositions(matrix);       //Stack or Queue both can be used as current & next pass
                                                                            //elements are saved in different DS & so they cannot be
        while (nextPassQueue.size()>0) {                                    //picked up in any order
            Queue<int[]> currentPassQueue = nextPassQueue;
            nextPassQueue = new ArrayDeque<>();

            while(currentPassQueue.size() > 0) {
                int[] currentCoord = currentPassQueue.remove();
                int currRow = currentCoord[0];
                int currCol = currentCoord[1];

                ArrayList<int[]> neighbors = getNeighbors(matrix, currRow, currCol);

                for(int[] neighbor : neighbors) {
                    int adjRow = neighbor[0];
                    int adjCol = neighbor[1];
                    int adjVal = matrix[adjRow][adjCol];

                    if(adjVal<0) {
                        matrix[adjRow][adjCol] = adjVal * -1;
                        nextPassQueue.add(new int[]{adjRow, adjCol});
                    }
                }
            }
            passes+=1;
        }
        return passes;
    }


    private static Queue<int[]> getAllPositivePositions(int[][] matrix) {
        Queue<int[]> positives = new ArrayDeque<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] > 0) {
                    positives.add(new int[]{i,j});
                }
            }
        }
        return positives;
    }

    private static boolean containsAllPositives(int[][] matrix) {
        for(int[] row : matrix) {
            for(int element : row) {
                if (element < 0) {
                    return false;
                }
            }
        }
        return true;
    }


    private static ArrayList<int[]> getNeighbors(int[][] matrix, int row, int col) {
        ArrayList<int[]> neighbors = new ArrayList<>();
        if(row>0) {
            neighbors.add(new int[]{row-1, col});
        }
        if(col>0) {
            neighbors.add(new int[]{row, col-1});
        }
        if(row<matrix.length-1) {
            neighbors.add(new int[]{row+1, col});
        }
        if(col<matrix[0].length-1) {
            neighbors.add(new int[]{row, col+1});
        }
        return neighbors;
    }














    /*
        Below method is Brute Force solution by me. Pass Every Element in each pass & flip. Also remember flip elements in a pass
        so that they dont flip other elements in the same pass.
    */

    private static int minimumPassesOfMatrixToConvertNegatives(int[][] matrix) {

        int passes = 0;
        int negativeCount = matrix.length * matrix[0].length;

        while(negativeCount>0) {
            int[][] copy = matrix.clone();
            passes++;
            Set<Coordinates> flippedInThisPass = new HashSet<>();
            boolean valueReassigned = false;
            for (int row = 0; row < matrix.length; row++) {
                for (int col = 0; col < matrix[0].length; col++) {
                    int currElement = matrix[row][col];
                    if (currElement < 0) {
                        boolean neighborPositive = getIfNeighborsPositive(copy, row, col, flippedInThisPass);
                        if (neighborPositive) {
                            matrix[row][col] = matrix[row][col] * -1;
                            flippedInThisPass.add(new Coordinates(row, col));
                            valueReassigned = true;
                            negativeCount--;
                        }
                    } else {
                        if(passes==1)
                        negativeCount--;
                    }
                }

            }
            if(passes==1 && !valueReassigned && negativeCount==0) {
                return 0;
            }
            if(!valueReassigned && negativeCount>0) {
                return -1;
            }
        }
        return passes;
    }

    private static boolean getIfNeighborsPositive(int[][] matrix, int row, int col, Set<Coordinates> flippedInThisPass) {
        if(row>0) {
            if(matrix[row-1][col]>0 && !flippedInThisPass.contains(new Coordinates(row-1,col))) return true;
        }
        if(col>0) {
            if(matrix[row][col-1]>0 && !flippedInThisPass.contains(new Coordinates(row,col-1))) return true;
        }
        if(row<matrix.length-1) {
            if(matrix[row+1][col]>0 && !flippedInThisPass.contains(new Coordinates(row+1,col))) return true;
        }
        if(col<matrix[0].length-1) {
            if(matrix[row][col+1]>0 && !flippedInThisPass.contains(new Coordinates(row,col+1))) return true;
        }
        return false;
    }

    static class Coordinates {
        int x;
        int y;

        public Coordinates(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Coordinates that = (Coordinates) o;
            return x == that.x &&
                    y == that.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public static void main(String[] args) {
        int[][] input = {
                {0, -1, -3, 2, 0},
                {1, -2, -5, -1, -3},
                {3, 0, 0, -4, -1}
        };
        int output = minimumPassesOfMatrixToConvertNegativesUsingQueue(input);
        System.out.println(output);

        input = new int[][]{
                {1}
        };
        output = minimumPassesOfMatrixToConvertNegativesUsingQueue(input);
        System.out.println(output);

        input = new int[][]{
                {1,2,3},
                {1,2,3}
        };
        output = minimumPassesOfMatrixToConvertNegativesUsingQueue(input);
        System.out.println(output);
    }
}
