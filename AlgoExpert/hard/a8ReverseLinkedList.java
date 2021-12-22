package com.algoexpert.hard;

public class a8ReverseLinkedList {

    public static LinkedList reverseLinkedList(LinkedList head) {
        LinkedList previous = null;
        LinkedList current = head;

        while (current != null) {
            LinkedList nextNode = current.next;
            current.next = previous;
            previous = current;
            current = nextNode;
        }
        return previous;
    }

    static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
    }
}
