package com.algoexpert.medium;

import java.util.*;

public class e44PhoneNumberMnemonics {

    public static Map<Character, String[]> KEYPAD = new HashMap<>();
    static {
        KEYPAD.put('0', new String[]{"0"});
        KEYPAD.put('1', new String[]{"1"});
        KEYPAD.put('2', new String[]{"a","b","c"});
        KEYPAD.put('3', new String[]{"d","e","f"});
        KEYPAD.put('4', new String[]{"g","h","i"});
        KEYPAD.put('5', new String[]{"j","k","l"});
        KEYPAD.put('6', new String[]{"m","n","o"});
        KEYPAD.put('7', new String[]{"p","q","r","s"});
        KEYPAD.put('8', new String[]{"t","u","v"});
        KEYPAD.put('9', new String[]{"w","x","y","z"});
    }

    public static ArrayList<String> phoneNumberMnemonics(String phoneNumber) {
        ArrayList<String> result = new ArrayList<>();
        String[] currentMnemonic = new String[phoneNumber.length()];
        //Arrays.fill(currentMnemonic,"0");

        phoneNumberMnemonicsRecursion(phoneNumber, 0, currentMnemonic, result);

        return result;
    }


    //Time Complexity
    //worst case the number pressed will have 4 letters i.e.7 & 9.
    //For each letter there will be n recursive calls which takes complexity to 4^n
    //For the currentMnemonic array to be converted to String, complexity will be n.
    //So total complexity will (4^n)*n
    //Space Complexity will be same. 4^n mnemonics are there the most and each mnemonic is n length.
    // Time : (4^n)*n || Space : (4^n)*n
    public static ArrayList<String> phoneNumberMnemonicsRecursion(String phoneNumber, int idx, String[] currentMnemonic,ArrayList<String> result) {

        if(idx >= phoneNumber.length()) {
            String mnemonic = String.join("", currentMnemonic);
            result.add(mnemonic);
        } else {
            char digit = phoneNumber.charAt(idx);
            String[] letters = KEYPAD.get(digit);

            for(String letter : letters) {
                currentMnemonic[idx] = letter;
                phoneNumberMnemonicsRecursion(phoneNumber, idx + 1, currentMnemonic, result);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(phoneNumberMnemonics("952"));

    }
}
