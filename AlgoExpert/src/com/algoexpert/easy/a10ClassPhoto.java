package com.algoexpert.easy;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class a10ClassPhoto {

    public static void main(String[] args) {
        System.out.println(classPhotos(Arrays.asList(5,8,1,3,4), Arrays.asList(6,9,2,4,5)));

        System.out.println(classPhotos(Arrays.asList(6, 9, 2, 4, 5), Arrays.asList(5, 8, 1, 3, 4)));
        System.out.println(classPhotos(Arrays.asList(6, 9, 2, 4, 5), Arrays.asList(5, 8, 1, 3, 4)));
        System.out.println(classPhotos(Arrays.asList(6, 9, 2, 4, 5, 1), Arrays.asList(5, 8, 1, 3, 4, 9)));
    }

    public static boolean classPhotos(List<Integer> red, List<Integer> blue) {
        Collections.sort(red);
        Collections.sort(blue);

        String taller = red.get(0) > blue.get(0) ? "red" : "blue";
        for(int i=0; i<red.size(); i++) {
            if(red.get(i) == blue.get(i)) {
                return false;
            }

            if(red.get(i) > blue.get(i)) {
                if(taller.equals("blue")) {
                    return false;
                }
            } else if(blue.get(i) > red.get(i)) {
                if(taller.equals("red")) {
                    return false;
                }
            }
        }
        return true;
    }
}
