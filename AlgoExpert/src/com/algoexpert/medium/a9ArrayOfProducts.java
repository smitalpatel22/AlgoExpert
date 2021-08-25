package com.algoexpert.medium;

public class a9ArrayOfProducts {
    public static void main(String[] args) {
        int[] input = new int[] {5, 1, 4, 2};
        input = arrayOfProducts(input);
        System.out.println(input);
    }

    public static int[] arrayOfProducts(int[] array) {

        int mult = 1;
        boolean hasZero=false;
        boolean hasMoreThanOneZero=false;
        int zeroIndex = 0;
        for (int i = 0; i < array.length; i++) {
            if(array[i]==0) {
                if(hasZero) {
                    hasMoreThanOneZero = true;
                    break;
                }
                hasZero = true;
                continue;
            }
            mult = mult * array[i];
        }

        if(hasMoreThanOneZero) {
            return new int[array.length];
        }
        else if(hasZero) {
            int[] output = new int[array.length];
            output[zeroIndex] = mult;
            return output;
        }

        for (int i = 0; i < array.length; i++) {
            array[i] = mult/array[i];
        }
        return array;
    }
}
