package com.algoexpert.easy;

import java.util.HashMap;

public class c25FirstNonRepeatingChar {
    public static int firstNonRepeatingCharacter(String str) {
        HashMap<Character, Integer> freq = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            freq.put(c, freq.getOrDefault(c, 0)+1);
        }

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(freq.get(c)==1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String input = "abcdcaf";
        System.out.print(firstNonRepeatingCharacter(input));
    }
}
