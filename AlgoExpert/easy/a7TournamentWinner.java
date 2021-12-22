package com.algoexpert.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class a7TournamentWinner {
    public static String tournamentWinner(
            ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {
        HashMap<String, Integer> counts = new HashMap<>();
        int maxCount = 0;
        String maxResult = "";
        int i = 0;
        for(ArrayList<String> indList : competitions) {
            String currentWinner = indList.get(1-results.get(i));
            Integer currentCount = counts.get(currentWinner);
            if(currentCount != null) {
                counts.put(currentWinner, currentCount + 3);
            } else {
                counts.put(currentWinner, 3);
            }
            if(counts.get(currentWinner) > maxCount) {
                maxCount = counts.get(currentWinner);
                maxResult = currentWinner;
            }
            i++;
        }
        System.out.println("Winner is Team: "+maxResult+" with Points: "+maxCount);
        return maxResult;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<String>> competitions = new ArrayList<ArrayList<String>>();
        ArrayList<String> competition1 = new ArrayList<String>(Arrays.asList("HTML", "C#"));
        ArrayList<String> competition2 = new ArrayList<String>(Arrays.asList("C#", "Python"));
        ArrayList<String> competition3 = new ArrayList<String>(Arrays.asList("Python", "HTML"));
        competitions.add(competition1);
        competitions.add(competition2);
        competitions.add(competition3);
        ArrayList<Integer> results = new ArrayList<Integer>(Arrays.asList(0, 0, 1));
        String expected = "Python";
        System.out.println(tournamentWinner(competitions, results));
    }
}
