package com.algoexpert.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class a9MergeLinkedLists {

    //Time : n + m || Space : 1   ==> n = List 1 Length & m = List 2 Length
    public static LinkedList mergeLinkedLists(LinkedList headOne, LinkedList headTwo) {

        LinkedList p1 = headOne;
        LinkedList p2 = headTwo;
        LinkedList p1Prev = null;

        while(p1 != null && p2 !=null) {
            if(p1.value < p2.value) {
                p1Prev = p1;
                p1 = p1.next;
            } else {
                if(p1Prev!=null) p1Prev.next=p2;
                p1Prev = p2;
                p2 = p2.next;
                p1Prev.next = p1;
            }
        }
        if(p1==null) p1Prev.next = p2;
        return headOne.value < headTwo.value ? headOne : headTwo;
    }

    //Time : n + m || Space : n + m   ==> n = List 1 Length & m = List 2 Length
    public static LinkedList mergeLinkedListsMethod2Reursive(LinkedList headOne, LinkedList headTwo) {

        recursiveMerge(headOne, headTwo, null);
        return headOne.value < headTwo.value ? headOne : headTwo;
    }

    private static void recursiveMerge(LinkedList p1, LinkedList p2, LinkedList p1Prev) {
        if(p1 == null) {
            p1Prev.next = p2;
            return;
        }
        if(p2 == null) return;
        if(p1.value < p2.value) {
            recursiveMerge(p1.next, p2, p1);
        } else {
            if(p1Prev != null) p1Prev.next = p2;
            LinkedList newP2 = p2.next;
            p2.next = p2;
            recursiveMerge(p1, newP2, p2);
        }
    }


    public static void main(String[] args) {
        LinkedList list1 = new LinkedList(2);
        addMany(list1, new ArrayList(Arrays.asList(6, 7, 8)));
        LinkedList list2 = new LinkedList(1);
        addMany(list2, new ArrayList(Arrays.asList(3, 4, 5, 9, 10)));
        LinkedList output = mergeLinkedLists(list1, list2);
    }

    public static LinkedList addMany(LinkedList ll, List<Integer> values) {
        LinkedList current = ll;
        while (current.next != null) {
            current = current.next;
        }
        for (int value : values) {
            current.next = new LinkedList(value);
            current = current.next;
        }
        return ll;
    }


    public static class LinkedList {
        int value;
        LinkedList next;

        LinkedList(int value) {
            this.value = value;
            this.next = null;
        }

        @Override
        public String toString() {
            return "{" +
                    "value=" + value +
                    ", next=" + next +
                    '}';
        }
    }
}
