package com.algoexpert.medium;

import java.util.*;
import java.util.stream.Collectors;

public class f54GroupAnagrams {

    public static List<List<String>> groupAnagrams(List<String> words) {

        Map<String, List<String>> groupedAnagramsMap = new HashMap<>();

        for(String str : words) {
            char[] charString = str.toCharArray();
            Arrays.sort(charString);
            String sortedKey = new String(charString);
            List<String> anagramsList = groupedAnagramsMap.getOrDefault(sortedKey, new ArrayList<>());
            anagramsList.add(str);
            if(anagramsList.size()==1) {
                groupedAnagramsMap.put(sortedKey, anagramsList);
            }
        }

        return new ArrayList<>(groupedAnagramsMap.values());

    }

    public static void main(String[] args) {
        List<String> words =
                new ArrayList<String>(
                        Arrays.asList("yo", "act", "flop", "tac", "foo", "cat", "oy", "olfp"));
        System.out.println(groupAnagrams(words));
    }
}
