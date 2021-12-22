package com.algoexpert.medium;

import java.util.*;

public class f55ValidIpAddress {

    public static ArrayList<String> validIPAddresses(String str) {

        ArrayList<String> validsIps = new ArrayList<>();

        for (int i = 1; i < Math.min(str.length(), 4); i++) {

            String[] currentIpParts = {"","","",""};

            currentIpParts[0] = str.substring(0,i);
            if(!isValidPart(currentIpParts[0])) {
                continue;
            }


            for (int j = i+1; j < i+Math.min(str.length()-i, 4); j++) {
                currentIpParts[1] = str.substring(i, j);
                if(!isValidPart(currentIpParts[1])) {
                    continue;
                }

                for (int k = j+1; k < j+Math.min(str.length()-j, 4); k++) {
                    currentIpParts[2] = str.substring(j, k);
                    currentIpParts[3] = str.substring(k);

                    if(isValidPart(currentIpParts[2]) && isValidPart(currentIpParts[3])) {
                        validsIps.add(join(currentIpParts));
                    }
                }
            }

        }
        return validsIps;
    }

    public static boolean isValidPart(String part) {
        int partInt = Integer.parseInt(part);
        if(partInt>255) {
            return false;
        }
        return part.length() == Integer.toString(partInt).length(); //checking for leading 0
    }

    public static String join(String[] strs) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs.length; i++) {
            sb.append(strs[i]);
            if(i<strs.length-1) {
                sb.append(".");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        System.out.println(validIPAddresses("1921680"));
    }
}
