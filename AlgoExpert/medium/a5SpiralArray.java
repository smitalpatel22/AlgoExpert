package com.algoexpert.medium;

import java.util.ArrayList;
import java.util.List;

public class a5SpiralArray {
    public static void main(String[] args) {
        int[][] input =
                new int[][] {
                        {1, 2, 3, 4},
                        {12, 13, 14, 5},
                        {11, 16, 15, 6},
                        {10, 9, 8, 7},
                };
        System.out.println(spiralTraverse(input));
        input =
                new int[][] {
                        {1, 2, 3},
                        {8, 9, 4},
                            {7, 6, 5}
                };
        System.out.println(spiralTraverse(input));
    }

    public static List<Integer> spiralTraverse(int[][] array) {
        List<Integer> response = new ArrayList<>();

        int sR=0;
        int sC=0;
        int eR=array.length-1;
        int eC=array[0].length-1;

        int r=0,c=0;
        while(sR<=eR && sC<=eC){
            response.add(array[sR][sC]);
            for(c=sC+1;c<=eC;c++) {
                response.add(array[r][c]);
            }
            c--;
            for(r=sR+1;r<=eR;r++) {
                response.add(array[r][c]);
            }
            r--;
            for(c=eC-1;c>=sC;c--) {
                response.add(array[r][c]);
            }
            c++;
            for(r=eR-1;r>=sR+1;r--) {
                response.add(array[r][c]);
            }
            r++;
            sR++;
            sC++;
            eR--;
            eC--;
        }
        return response;
    }
}
