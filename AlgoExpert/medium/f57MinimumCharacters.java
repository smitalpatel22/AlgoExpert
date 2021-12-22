package com.algoexpert.medium;

import java.util.HashMap;
import java.util.Map;

public class f57MinimumCharacters {

    //Time: n * l || Space: c (Worst space = n*l)
    //n=number of words
    //l=length of longest word
    //c=number of unique characters across words
    public static char[] minimumCharactersForWords(String[] words) {

        Map<Character, Integer> maxCharFreqMap = new HashMap<>();
        for(String word : words) {
            Map<Character, Integer> countMap = getCharFreqMapForWord(word);
            populateMaxCharFreqMap(countMap, maxCharFreqMap);
        }
        return createOutputFromMaxCountMap(maxCharFreqMap);

    }

    private static char[] createOutputFromMaxCountMap(Map<Character, Integer> maxCharFreqMap) {
        int sizeOfOutput = 0;
        for(Integer freq : maxCharFreqMap.values()) {
            sizeOfOutput += freq;
        }

        int offset=0;
        char[] output = new char[sizeOfOutput];
        for(Map.Entry<Character, Integer> entry : maxCharFreqMap.entrySet()) {
            int i = 0;
            while(offset < sizeOfOutput && i<entry.getValue()) {
                output[offset] = entry.getKey();
                i++;
                offset++;
            }
        }
        return output;
    }

    private static void populateMaxCharFreqMap(Map<Character, Integer> countMap, Map<Character, Integer> maxCharFreqMap) {

        for(Map.Entry<Character, Integer> entry : countMap.entrySet()) {
            if (maxCharFreqMap.containsKey(entry.getKey())) {
                maxCharFreqMap.put(entry.getKey(), Math.max(countMap.get(entry.getKey()), maxCharFreqMap.get(entry.getKey())));
            }else {
                maxCharFreqMap.put(entry.getKey(), countMap.get(entry.getKey()));
            }
        }
    }

    private static Map<Character, Integer> getCharFreqMapForWord(String word) {
        char[] charArray = word.toCharArray();

        Map<Character, Integer> charFreq = new HashMap<>();
        for (char c : charArray) {
            charFreq.put(c, charFreq.getOrDefault(c, 0)+1);
        }
        return charFreq;
    }

    public static void main(String[] args) {
        String[] words = new String[] {"this", "that", "did", "deed", "them!", "a"};
        System.out.println(minimumCharactersForWords(words));

        System.out.println(new int[]{1,2,3,4});
        System.out.println(new char[]{'a','b','c','d'});
    }
}
