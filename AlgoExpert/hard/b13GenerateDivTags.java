package com.algoexpert.hard;

import java.util.ArrayList;

public class b13GenerateDivTags {

    //Time : (2n)! / (n!((n+1)!))   || Space : (2n)! / (n!((n+1)!))     ==> n=Number of tags required which is given as input
    //Above is Catalan Number Formula
    //This formula is not actually the upper bound time for our solution but instead it is the number of combinations possible for given input
    // For eg if n=2
    //  (2*2)! / (2!)((2+1)!) => 4! / (2!)(3!) ==> 24 / 2*6 ==> 24/12 ==> 2 ==> output
    public static ArrayList<String> generateDivTags(int numberOfTags) {

        String prefix="";
        ArrayList<String> matchedDivTagsOutput = new ArrayList<>();
        generateDivTagsRecursive(prefix, numberOfTags, numberOfTags, matchedDivTagsOutput);
        return matchedDivTagsOutput;
    }

    private static void generateDivTagsRecursive(String prefix, int noOfOpeningTags, int noOfClosingTags, ArrayList<String> result) {

        if(noOfOpeningTags>0) {
            generateDivTagsRecursive(prefix + "<div>", noOfOpeningTags - 1, noOfClosingTags, result);
        }
        if(noOfOpeningTags < noOfClosingTags) {
            generateDivTagsRecursive(prefix + "</div>", noOfOpeningTags, noOfClosingTags-1, result);
        }

        if(noOfClosingTags == 0) {
            result.add(prefix);
        }

    }

    public static void main(String[] args) {
        System.out.println(generateDivTags(2));
        System.out.println(generateDivTags(3));
    }
}
