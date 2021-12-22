package com.algoexpert.medium;

public class f53LongestPalindromicSubstring {

    //Time: O(n^3) || Space : O(n)
    public static String longestPalindromicSubstring(String str) {
        String longest="";
        for (int i = 0; i < str.length(); i++) {
            for (int j = i; j < str.length(); j++) {
                String substring = str.substring(i, j+1);
                if(substring.length() > longest.length() && isPalindrome(substring)) {
                    longest = substring;
                }
            }
        }
        return longest;
    }

    public static boolean isPalindrome(String subString) {

        int left = 0;
        int right = subString.length()-1;

        while(left<right) {
            if(subString.charAt(left)!=subString.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static String longestPalindromicSubstringOptimized(String str) {

        int currentLongest[] = new int[]{0,1};

        for (int i = 0; i < str.length(); i++) {

            int[] odd = longestPalindromicSubstring(str, i-1, i+1);
            int[] even = longestPalindromicSubstring(str, i-1, i);

            int[] longest = odd[1] - odd[0] > even[1] - even[0]
                    ? odd : even;

            currentLongest = longest[1] - longest[0] > currentLongest[1] - currentLongest[0]
                    ? longest : currentLongest;
        }
        return str.substring(currentLongest[0], currentLongest[1]);
    }

    private static int[] longestPalindromicSubstring(String str, int left, int right) {
        while (left>=0 && right<str.length()) {
            if(str.charAt(left) != str.charAt(right)) {
                break;
            }
            left--;
            right++;
        }
        return new int[]{left+1, right};
    }

    public static void main(String[] args) {
        System.out.println(longestPalindromicSubstringOptimized("abaxyzzyxf"));
    }
}
