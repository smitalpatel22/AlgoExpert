package com.algoexpert.easy;

public class c23RunLengthEncoding {
    public static String runLengthEncoding(String str) {
        StringBuilder encodedStringChars = new StringBuilder();
        int currRunLength = 1;

        for(int i=1; i<str.length(); i++){
            char currChar = str.charAt(i);
            char prevChar = str.charAt(i-1);

            if(currChar != prevChar || currRunLength==9) {
                encodedStringChars.append(Integer.toString(currRunLength));
                encodedStringChars.append(prevChar);
                currRunLength = 0;
            }
            currRunLength +=1;
        }
        //Last Run
        encodedStringChars.append(Integer.toString(currRunLength));
        encodedStringChars.append(str.charAt(str.length()-1));
        return encodedStringChars.toString();
    }

    public static void main(String[] args) {
        String input = "AAAAAAAAAAAAABBCCCCDD";
        System.out.print(runLengthEncoding(input));
    }
}
