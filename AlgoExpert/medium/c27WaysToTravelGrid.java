package com.algoexpert.medium;

public class c27WaysToTravelGrid {

    //Time: O(2^(w+h)) || Space: O(w+h)     ==> 2 because you can go 2 directions so if diagonal way available then 3^(w+h)
    public static int waysToTravelGridRecursive(int width, int height) {
        // If either given row number is first or given column number is first
        if(width==1 || height==1) {
            return 1;
        }
        return waysToTravelGridRecursive(width-1, height) + waysToTravelGridRecursive(width, height-1); //+ways(width-1,height-1);
    }

    //Time: O(w*m)) || Space: O(w*h)
    public static int waysToTravelGridDynamicProgramming(int width, int height) {

        //For any initial border cells, the ways to reach will be 1 for all cells i.e. for first row & column
        //we will store this info
        //then for later cells, i.e. (1,1) we will look on value on left & above, & add both values. So 1+1=2
        //Keep doing this and at the last cell you will have your output.

        int[][] grid = new int[height][width];

        for(int r=0; r<height; r++) {
            for(int c=0; c<width; c++) {
                if(r==0 || c==0) {
                    grid[r][c] = 1;
                } else {
                    grid[r][c] = grid[r - 1][c] + grid[r][c - 1];
                }
            }
        }
        return grid[height-1][width-1];
    }

    //O(n+m) Time || O(1)
    public static int waysToGridUsingMaths(int width, int height) {
        //You can go Right or Down.
        //Max right you can go is R=(Width-1) & Max Down you can go is D=(Height-1)
        //So for W=4 H=3, you get R=3, D=2     R->R->R  || D->D
        //So you have to find out all "Permutations" of R=3 & D=2
        // i.e. R R R D D ==> find diff ways in which these 5 can be ordered
        //Formula for finding Permuations = (R + D)!
        //                                  --------
        //                                   R! * D!

        int r=width-1;
        int d=height-1;
        int numerator = factorial(r+d);
        int denominator = factorial(r) * factorial(d);
        return numerator/denominator;

    }

    private static int factorial(int num){
        int result = 1;
        for(int i=2; i<=num; i++) {
            result *=i;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(waysToTravelGridRecursive(4, 3));
        System.out.println(waysToTravelGridDynamicProgramming(4, 3));
        System.out.println(waysToGridUsingMaths(4, 3));
    }

}
