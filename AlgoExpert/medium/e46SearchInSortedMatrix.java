package com.algoexpert.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class e46SearchInSortedMatrix {

    //Time : R+C || Space : 1   ==> R=Row & C=Column
    //Time : R+C ==> suppose the target element is at the lower left corner then you will have to travel R+C
    public static int[] searchInSortedMatrix(int[][] matrix, int target) {

        int row = 0;
        int col = matrix[0].length-1;

        while(row<matrix.length && col>=0) {
            if(target < matrix[row][col]) {
                col--;
            } else if(target > matrix[row][col]) {
                row++;
            } else {
                return new int[]{row, col};
            }
        }
        return new int[] {-1, -1};
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 4, 7, 12, 15, 1000},
                {2, 5, 19, 31, 32, 1001},
                {3, 8, 24, 33, 35, 1002},
                {40, 41, 42, 44, 45, 1003},
                {99, 100, 103, 106, 128, 1004},
        };
        int[] expected = {3, 3};
        int[] output = searchInSortedMatrix(matrix, 44);
        System.out.println(""+output[0]+" : "+output[1]);
    }
}
