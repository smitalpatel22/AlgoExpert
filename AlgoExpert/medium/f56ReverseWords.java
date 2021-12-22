package com.algoexpert.medium;

import java.util.ArrayList;
import java.util.Collections;

public class f56ReverseWords {

    //Time: 2n ~~ n || Space:O(n)
    public static String reverseWordsInString(String string) {

        ArrayList<String> words = new ArrayList<>();

        int startOfWord = 0;

        for (int idx = 0; idx < string.length(); idx++) {
            char letter = string.charAt(idx);

            if(letter==' ') {
                words.add(string.substring(startOfWord, idx));
                startOfWord = idx;
            } else if(string.charAt(startOfWord)==' ') {
                words.add(" ");
                startOfWord = idx;
            }
        }

        words.add(string.substring(startOfWord));
        Collections.reverse(words);
        return String.join("", words);
    }

    //Time: 2n ~~ n || Space:O(n)
    public static String reverseWordsInStringMethod2(String string) {
        char[] charArray = string.toCharArray();
        reverseListRange(charArray, 0, charArray.length-1);

        int startOfWord = 0;
        while (startOfWord < charArray.length) {
            int endOfWord = startOfWord;
            while (endOfWord < charArray.length && charArray[endOfWord] != ' ') {
                endOfWord+=1;
            }
            reverseListRange(charArray, startOfWord, endOfWord-1);
            startOfWord = endOfWord + 1;
        }
        return new String(charArray);
    }

    private static void reverseListRange(char[] charArray, int start, int end) {

        while(start < end) {
            char temp = charArray[start];
            charArray[start] = charArray[end];
            charArray[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        System.out.println(reverseWordsInStringMethod2("AlgoExpert is the best!"));
    }
}
