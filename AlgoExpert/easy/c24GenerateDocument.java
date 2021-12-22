package com.algoexpert.easy;

import java.util.HashMap;

public class c24GenerateDocument {
    public static boolean generateDocument(String characters, String document) {

        HashMap<Character, Integer> freq = new HashMap<>();

        for (int i = 0; i < characters.length(); i++) {
            char key = characters.charAt(i);
            freq.put(key, freq.getOrDefault(key, 0)+1);
        }

        for (int i = 0; i < document.length(); i++) {
            char currChar = document.charAt(i);

            if(freq.get(currChar)==null || freq.get(currChar)==0) {
                return false;
            }
            freq.put(currChar, freq.get(currChar)-1);
        }
        return true;
    }

    public static void main(String[] args) {
        String characters = "Bste!hetsi ogEAxpelrt x ";
        String document = "AlgoExpert is the Best!";
        System.out.print(generateDocument(characters, document));
    }
}
