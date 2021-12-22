package com.algoexpert.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class e49BalancedBrackets {

    //Time : O(n) || Space : O(n)
    //Stack Push and Pop are constant Time but we have a for loop for iterating all characters so Time==n
    //Space==n because input can have all opening brackets then all chars will be inside stack.
    public static boolean balancedBrackets(String str) {

        String openingBrackets = "({[";
        String closingBrackets = ")}]";

        Map<Character, Character> matchingBrackets = new HashMap<>();
        matchingBrackets.put(')','(');
        matchingBrackets.put('}','{');
        matchingBrackets.put(']','[');

        List<Character> stack = new ArrayList<>();

        for (int i = 0; i < str.length(); i++) {
            char letter = str.charAt(i);

            if(openingBrackets.indexOf(letter) != -1) {
                stack.add(letter);
            } else if(closingBrackets.indexOf(letter) != -1) {
                if(stack.size()==0) {
                    return false;
                }
                if(stack.get(stack.size()-1)==matchingBrackets.get(str.charAt(i))) {
                    stack.remove(stack.size()-1);
                } else {
                    return false;
                }
            }
        }
        return stack.size()==0;
    }

    public static void main(String[] args) {
        String str = "([])(){}(())()()";
        System.out.println(balancedBrackets(str));

        str = "())";
        System.out.println(balancedBrackets(str));
    }
}
