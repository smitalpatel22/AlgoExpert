package com.algoexpert.easy;

import java.util.Arrays;
import java.util.List;

public class a2ValidSubsequence {
    public static void main(String[] args) {
        List<Integer> array = Arrays.asList(5, 1, 22, 25, 6, -1, 8, 10);
        List<Integer> sequence = Arrays.asList(1, 6, -1, 10);
        isValidSubsequence(array, sequence);

        array = Arrays.asList(5, 1, 22, 25, 6, 8, 10);
        sequence = Arrays.asList(1, 6, -1, 10);
        isValidSubsequence(array, sequence);

        array = Arrays.asList(1, 1, 1, 1, 1);
        sequence = Arrays.asList(1, 1, 1);
        isValidSubsequence(array, sequence);

        array = Arrays.asList(5, 1, 22, 25, 6, -1, 8, 10);
        sequence = Arrays.asList(25);
        isValidSubsequence(array, sequence);

        array = Arrays.asList(5, 1, 22, 25, 6, -1, 8, 10);
        sequence = Arrays.asList(5, 1, 22, 22, 25, 6, -1, 8, 10);
        isValidSubsequence(array, sequence);
    }

    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
        int seqIdx = 0;
        for(Integer ele : array) {
//            if(seqIdx==sequence.size()) {
//                break;
//            }
            if(sequence.get(seqIdx)==ele) {
                seqIdx++;
            }
        }
        return seqIdx==sequence.size();
    }

//    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
//        int finalPoint = sequence.size();
//        int seqIndx=0,arrayIndx = 0;
//		  if(finalPoint > array.size()) return false;
//        while(seqIndx<finalPoint) {
//                if(array.get(arrayIndx) == sequence.get(seqIndx)) {
//                    if(seqIndx==finalPoint-1) {
//                        System.out.println("Input is a valid Subsequence");
//                        return true;
//                    }
//                    seqIndx++; arrayIndx++;
//                } else {
//                		arrayIndx++;
//                }
//            if(arrayIndx==array.size()){
//                break;
//            }
//        }
//        System.out.println("Input is a Invalid Subsequence");
//        return false;
//    }
}
