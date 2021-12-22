package com.algoexpert.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.IntStream;

public class b12SolveSudoku {

    //Time : 1 || Space : 1     //1 because assuming that the board will always be 9*9 size. So it is constant.
    public static ArrayList<ArrayList<Integer>> solveSudoku(ArrayList<ArrayList<Integer>> board) {
        solvePartialSudoku(0,0,board);
        return board;
    }

    public static boolean solvePartialSudoku(int row, int col, ArrayList<ArrayList<Integer>> board) {

        int currentRow = row;
        int currentCol = col;
        if(currentCol == board.get(currentRow).size()) {            //this means we are at end of the row
            currentRow += 1;
            currentCol = 0;
            if(currentRow == board.size()) {                        //we have reached row 9 so we have solved whole sudoku
                return true;
            }
        }

        if(board.get(currentRow).get(currentCol) == 0) {
            return tryDigitsAtPosition(board, currentRow, currentCol);
        }

        return solvePartialSudoku(currentRow, currentCol+1, board);
    }

    private static boolean tryDigitsAtPosition(ArrayList<ArrayList<Integer>> board, int row, int col) {
        for (int digit = 1; digit <= 9; digit++) {
            if(isValidAtPosition(digit, row, col, board)) {
                board.get(row).set(col, digit);                             //because we inserted this number temporarily,
                if(solvePartialSudoku(row, col+1, board)) {             //lets try to solve rest of the board
                    return true;
                }
            }
        }

        //this means we are not able to solve board above with the inserted digits so we have to remove the inserted number
        //& remove previous ones too in the recursive call stack if required.
        board.get(row).set(col, 0);
        return false;

    }

    public static boolean isValidAtPosition(int value, int row, int col, ArrayList<ArrayList<Integer>> board) {
        //check row
        ArrayList<Integer> rowMembers = board.get(row);
        if(rowMembers.contains(value)) return false;

        //check column
        for(ArrayList<Integer> currentRow : board) {
            if(currentRow.get(col)==value) return false;
        }

        //check subgrid
        int subGridRowStart = (row/3)*3;
        int subGridColStart = (col/3)*3;

        for (int rowIdx = 0; rowIdx < 3; rowIdx++) {
            for (int colIdx = 0; colIdx < 3; colIdx++) {
                int rowToCheck = subGridRowStart + rowIdx;
                int colToCheck = subGridColStart + colIdx;

                int existingValue = board.get(rowToCheck).get(colToCheck);
                if(existingValue==value) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[][] inputValues =
                new int[][] {
                        {7, 8, 0, 4, 0, 0, 1, 2, 0},
                        {6, 0, 0, 0, 7, 5, 0, 0, 9},
                        {0, 0, 0, 6, 0, 1, 0, 7, 8},
                        {0, 0, 7, 0, 4, 0, 2, 6, 0},
                        {0, 0, 1, 0, 5, 0, 9, 3, 0},
                        {9, 0, 4, 0, 6, 0, 0, 0, 5},
                        {0, 7, 0, 3, 0, 0, 0, 1, 2},
                        {1, 2, 0, 0, 0, 7, 4, 0, 0},
                        {0, 4, 9, 2, 0, 6, 0, 0, 7}
                };
        int[][] expectedValues =
                new int[][] {
                        {7, 8, 5, 4, 3, 9, 1, 2, 6},
                        {6, 1, 2, 8, 7, 5, 3, 4, 9},
                        {4, 9, 3, 6, 2, 1, 5, 7, 8},
                        {8, 5, 7, 9, 4, 3, 2, 6, 1},
                        {2, 6, 1, 7, 5, 8, 9, 3, 4},
                        {9, 3, 4, 1, 6, 2, 7, 8, 5},
                        {5, 7, 8, 3, 9, 4, 6, 1, 2},
                        {1, 2, 6, 5, 8, 7, 4, 9, 3},
                        {3, 4, 9, 2, 1, 6, 8, 5, 7}
                };
        ArrayList<ArrayList<Integer>> input = new ArrayList();
        for (int i = 0; i < inputValues.length; i++) {
            ArrayList<Integer> row = new ArrayList();
            for (int j = 0; j < inputValues[i].length; j++) {
                row.add(inputValues[i][j]);
            }
            input.add(row);
        }

        ArrayList<ArrayList<Integer>> expected = new ArrayList();
        for (int i = 0; i < expectedValues.length; i++) {
            ArrayList<Integer> row = new ArrayList();
            for (int j = 0; j < expectedValues[i].length; j++) {
                row.add(expectedValues[i][j]);
            }
            expected.add(row);
        }

        ArrayList<ArrayList<Integer>> actual = solveSudoku(input);
        System.out.println(expected.equals(actual));
    }

}
