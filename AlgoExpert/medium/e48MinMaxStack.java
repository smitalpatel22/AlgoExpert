package com.algoexpert.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class e48MinMaxStack {

    List<Integer> stack = new ArrayList<>();
    List<Map<String, Integer>> minMaxStack = new ArrayList<>();

    //Time : 1 || Space : 1
    public int peek() {
        return stack.get(stack.size()-1);
    }

    //Time : 1 || Space : 1
    public int pop() {
        minMaxStack.remove(minMaxStack.size()-1);
        return stack.remove(stack.size()-1);
    }

    //Time : 1 || Space : 1
    public void push(Integer number) {
        stack.add(number);
        Map<String, Integer> newMinMaxEntry = new HashMap<>();

        if(minMaxStack.size()>0) {
            Map<String, Integer> lastMinMax = minMaxStack.get(minMaxStack.size() - 1);
            newMinMaxEntry.put("min", Math.min(number, lastMinMax.get("min")));
            newMinMaxEntry.put("max", Math.max(number, lastMinMax.get("max")));
        } else {
            newMinMaxEntry.put("min", number);
            newMinMaxEntry.put("max", number);
        }
        minMaxStack.add(newMinMaxEntry);
    }

    //Time : 1 || Space : 1
    public int getMin() {
        return minMaxStack.get(minMaxStack.size()-1).get("min");
    }

    //Time : 1 || Space : 1
    public int getMax() {
        return minMaxStack.get(minMaxStack.size()-1).get("max");
    }

    public static void main(String[] args) {
        e48MinMaxStack stack = new e48MinMaxStack();
        stack.push(5);
        testMinMaxPeek(5, 5, 5, stack);
        stack.push(7);
        testMinMaxPeek(5, 7, 7, stack);
        stack.push(2);
        testMinMaxPeek(2, 7, 2, stack);
    }

    public static void testMinMaxPeek(int min, int max, int peek, e48MinMaxStack stack) {
        System.out.println(stack.getMin() == min);
        System.out.println(stack.getMax() == max);
        System.out.println(stack.peek() == peek);
    }
}
