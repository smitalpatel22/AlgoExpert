package com.algoexpert.easy;

public class c21PalindromeCheck {
    public static void main(String[] args) {
        System.out.print(isPalindrome("abcba"));
    }

    public static boolean isPalindrome(String str) {
        int left=0, right=str.length()-1;

        while(left < right) {
            if(str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
