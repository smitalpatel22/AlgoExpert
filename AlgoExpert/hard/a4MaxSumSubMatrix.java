package com.algoexpert.hard;

import java.util.*;

public class a4MaxSumSubMatrix {

    //Brute Force solution is to find max sum for all sub-matrices
    //Time : Widht*Heigh*size^2 ==> because for each bigger size, there will be more repeated elements.
    //For size=1, 1^2=1


    //Optimal approach:
    //Time : w*h || Space : w*h ==>w=width and h=height
    //Here we will create a similar matrix, & for (i,j) element, we will store sum of sub-matrix of (0,0) to (i,j).
    public static int maximumSumSubmatrix(int[][] matrix, int size) {
        int[][] sums = createSumsMatrix(matrix);
        int maxSum = findMaxSum(matrix, sums, size);

        return maxSum;
    }

    private static int findMaxSum(int[][] matrix, int[][] sums, int size) {
        int maxSum = Integer.MIN_VALUE;

        for(int row = size-1; row < matrix.length; row++) {
            for(int col = size-1; col < matrix[row].length; col++) {
                int total = sums[row][col];
                boolean isTouchingLeft = (col-size<0);
                boolean isTouchingTop = (row-size<0);

                //if not touching the top border, then deduct the top border
                if(!isTouchingTop) {
                    total -= sums[row-size][col];
                }
                //if not touching the left border, then deduct the left border
                if(!isTouchingLeft) {
                    total -= sums[row][col-size];
                }

                //if we are touching both if these borders, then we must have deducted overlapping elements between above deductions twice.
                //so we will have to add back 1 of the overlap.
                boolean touchesLeftOrTopBorder = (isTouchingTop || isTouchingLeft);
                //touching not the top && not the left border
                if(!touchesLeftOrTopBorder) {
                    total += sums[row-size][col-size];
                }

                maxSum = Math.max(maxSum, total);
            }
        }
        return maxSum;
    }


    private static int[][] createSumsMatrix(int[][] matrix) {
        int[][] sums = new int[matrix.length][matrix[0].length];

        sums[0][0] = matrix[0][0];
        //Fill First Column with sums
        for (int row = 1; row < matrix.length; row++) {
            sums[row][0] = sums[row-1][0] + matrix[row][0];
        }

        //Fill First Row with sums
        for (int col = 1; col < matrix[0].length; col++) {
            sums[0][col] = sums[0][col-1] + matrix[0][col];
        }

        for(int row=1; row < matrix.length; row++) {
            for(int col=1; col < matrix[0].length; col++) {
                sums[row][col] = matrix[row][col] + sums[row-1][col] + sums[row][col-1] - sums[row-1][col-1];
            }
        }
        return sums;
    }


    public static void main(String[] args) {
        int[][] matrix = new int[][] {{5, 3, -1, 5}, {-7, 3, 7, 4}, {12, 8, 0, 0}, {1, -8, -8, 2}};
        int size = 2;
        System.out.println(maximumSumSubmatrix(matrix, size));
    }
}
