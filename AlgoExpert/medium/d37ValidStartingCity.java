package com.algoexpert.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class d37ValidStartingCity {

    public static void main(String[] args) {
        int[] distances = new int[] {5, 25, 15, 10, 15};
        int[] fuel = new int[] {1, 2, 1, 0, 3};
        int milesPerGallon = 10;
        System.out.println(validStartingCity(distances,  fuel, milesPerGallon));
    }

    //O(n) | O(1)==>if we used Brute force then O(n^2) as we need to try each city as starting point & travel other cities
    public static int validStartingCity(int[] distances, int[] fuel, int mpg) {

        int minMilesLeft = 0;
        int minMilesLeftIdx = 0;
        int milesLeft = 0;
        for(int cityIdx=0; cityIdx<distances.length; cityIdx++) {
            int milesLeftByFuelFromPreviousCity = milesLeft;            //just for sake of understanding
            if(milesLeft<minMilesLeft) {
                minMilesLeft=milesLeft;
                minMilesLeftIdx = cityIdx;
            }
            milesLeft = milesLeftByFuelFromPreviousCity + (fuel[cityIdx] * mpg - distances[cityIdx]);
        }

        return minMilesLeftIdx;
    }


    public static int validStartingCityTheirs(int[] distances, int[] fuel, int mpg) {

        int minMilesLeft = 0;
        int minMilesLeftIdx = 0;
        int milesLeft = 0;
        for(int cityIdx=1; cityIdx<distances.length; cityIdx++) {
            int milesLeftByFuelFromPreviousCity = distances[cityIdx-1];
            int fuelLeftFromPreviousCity = fuel[cityIdx-1];
            milesLeft = milesLeft + (fuelLeftFromPreviousCity * mpg - milesLeftByFuelFromPreviousCity);
            if(milesLeft<minMilesLeft) {
                minMilesLeft=milesLeft;
                minMilesLeftIdx = cityIdx;
            }
        }
        return minMilesLeftIdx;
    }

}
