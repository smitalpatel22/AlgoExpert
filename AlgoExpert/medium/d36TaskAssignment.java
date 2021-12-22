package com.algoexpert.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class d36TaskAssignment {

    public static void main(String[] args) {
        System.out.println(taskAssignment(3,  new ArrayList<>(Arrays.asList(1, 3, 5, 3, 1, 4))));
    }

    //O(nlog(n)) || //O(n) ==> n=Number of Tasks
    public static ArrayList<ArrayList<Integer>> taskAssignment(int k, ArrayList<Integer> tasks) {
        ArrayList<ArrayList<Integer>> pairedTaskIndices = new ArrayList<>();
        HashMap<Integer, ArrayList<Integer>> taskLengthsToIndicesMap = getTaskLengthsToIndicesMap(tasks);

        ArrayList<Integer> sortedTasks = tasks;
        Collections.sort(sortedTasks);              //O(nlog(n))

        //O(n)
        for(int idx=0; idx<k; idx++) {
            int task1Duration = sortedTasks.get(idx);
            int task2Duration = sortedTasks.get(sortedTasks.size()-1-idx);

            ArrayList<Integer> indicesWithTask1Duration = taskLengthsToIndicesMap.get(task1Duration);
            ArrayList<Integer> indicesWithTask2Duration = taskLengthsToIndicesMap.get(task2Duration);

            int task1Index = indicesWithTask1Duration.remove(indicesWithTask1Duration.size()-1);
            int task2Index = indicesWithTask2Duration.remove(indicesWithTask2Duration.size()-1);

            ArrayList<Integer> pairedIndex = new ArrayList<>();
            pairedIndex.add(task1Index);
            pairedIndex.add(task2Index);
            pairedTaskIndices.add(pairedIndex);
        }

        return pairedTaskIndices;
    }

    public static HashMap<Integer, ArrayList<Integer>> getTaskLengthsToIndicesMap(ArrayList<Integer> tasks) {
        HashMap<Integer, ArrayList<Integer>> taskLengthToIndices = new HashMap<>();

        //O(n)
        for(int index=0; index<tasks.size(); index++){
            int taskLength = tasks.get(index);
            if(taskLengthToIndices.containsKey(taskLength)) {
                taskLengthToIndices.get(taskLength).add(index);
            } else {
                ArrayList<Integer> indices = new ArrayList<>();
                indices.add(index);
                taskLengthToIndices.put(taskLength, indices);
            }
        }
        return taskLengthToIndices;
    }

}
