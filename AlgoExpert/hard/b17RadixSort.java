package com.algoexpert.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class b17RadixSort {

    //Time: d+(n+b) || Space:               ==> d=largest number of digits in input, n=number of elements in your input, b=base of numbering system(10)
    //n+b is taken by counting sort ==> so even though your n<b, you have to process all 0 to 9 as you cannot assume & so you have to
    //maintain your counts array & so you need to perform b operations
    //Space: n+b ==> n=sorted array & b=counts array
    //here radix sort just means sorting by digits, so you can use different sort algo instead of counting sort.
    //But if you change your sorting algo, you will also change your time complexity. So whats the purpose of radix to be optimized.
    //If there are also negative numbers then below solution will not work
    public static ArrayList<Integer> radixSort(ArrayList<Integer> array) {

        if(array.size()<=1) {
            return array;
        }

        int maxNumber = Collections.max(array);
        int digit = 0;
        while((maxNumber/Math.pow(10, digit)) > 0) {
            countingSort(array, digit);
            digit += 1;
        }
        return array;
    }

    private static void countingSort(ArrayList<Integer> array, int digit) {
        int[] sortedArray = new int[array.size()];
        int[] countArray = new int[10];

        int digitColumn = (int)Math.pow(10, digit);
        for (int num : array) {
            int countIndex = (num/digitColumn) % 10;
            countArray[countIndex] += 1;
        }

        for (int i = 1; i < 10; i++) {
            countArray[i] += countArray[i-1];
        }

        for (int i = array.size()-1; i > -1; i--) {
            int countIdx = (array.get(i) / digitColumn) % 10;
            countArray[countIdx] -= 1;
            int sortedIndex = countArray[countIdx];
            sortedArray[sortedIndex] = array.get(i);
        }

        for (int i = 0; i < array.size(); i++) {
            array.set(i, sortedArray[i]);
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> input =
                new ArrayList(Arrays.asList(8762, 654, 3008, 345, 87, 65, 234, 12, 2));
        System.out.println(radixSort(input));

        input = new ArrayList(Arrays.asList(67, 68));
        System.out.println(radixSort(input));
    }
}
