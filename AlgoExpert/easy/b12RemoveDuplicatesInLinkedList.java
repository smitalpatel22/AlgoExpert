package com.algoexpert.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class b12RemoveDuplicatesInLinkedList {
    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }

        public static LinkedList removeDuplicatesFromLinkedList(LinkedList linkedList) {
            LinkedList root = linkedList;
            while(linkedList != null) {
                while(linkedList.next != null && linkedList.value==linkedList.next.value) {
                    linkedList.next = linkedList.next.next;
                }
                linkedList = linkedList.next;
            }
            return root;
        }

        public static void main(String[] args) {
            LinkedList input = new LinkedList(1);
            addMany(input, new ArrayList<Integer>(Arrays.asList(1, 3, 4, 4, 4, 5, 6, 6)));
            List<Integer> expectedNodes = new ArrayList<>(Arrays.asList(1, 3, 4, 5, 6));

            System.out.println("Actual: "+ getNodesInArray(removeDuplicatesFromLinkedList(input)));
            System.out.println("Expected: "+ expectedNodes);
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

        public static List<Integer> getNodesInArray(LinkedList ll) {
            List<Integer> nodes = new ArrayList<Integer>();
            LinkedList current = ll;
            while (current != null) {
                nodes.add(current.value);
                current = current.next;
            }
            return nodes;
        }
    }
}
