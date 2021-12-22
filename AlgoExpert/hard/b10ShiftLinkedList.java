package com.algoexpert.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class b10ShiftLinkedList {

    //Time : n + m || Space : 1   ==> n = List 1 Length & m = List 2 Length
    public static LinkedList shiftLinkedList(LinkedList head, int k) {

        int listLength = 1;

        LinkedList listTail = head;
        while(listTail.next != null) {
            listTail = listTail.next;
            listLength++;
        }

        int offset = Math.abs(k) % listLength;
        if(offset == 0) return head;

        int newTailPosition = k>0 ? listLength - offset : offset;

        LinkedList newTail = head;
        for (int i = 1; i < newTailPosition; i++) {
            newTail = newTail.next;
        }

        LinkedList newHead = newTail.next;
        newTail.next = null;
        listTail.next = head;

        return newHead;
    }


    public static void main(String[] args) {
        LinkedList head = new LinkedList(0);
        head.next = new LinkedList(1);
        head.next.next = new LinkedList(2);
        head.next.next.next = new LinkedList(3);
        head.next.next.next.next = new LinkedList(4);
        head.next.next.next.next.next = new LinkedList(5);
        System.out.println(shiftLinkedList(head, 2));

        head = new LinkedList(0);
        head.next = new LinkedList(1);
        head.next.next = new LinkedList(2);
        head.next.next.next = new LinkedList(3);
        head.next.next.next.next = new LinkedList(4);
        head.next.next.next.next.next = new LinkedList(5);
        LinkedList x = shiftLinkedList(head, 6);
        System.out.println(x);

        System.out.println(shiftLinkedList(x, 14));

        head = new LinkedList(0);
        head.next = new LinkedList(1);
        head.next.next = new LinkedList(2);
        LinkedList x1 = shiftLinkedList(head, -1);
        System.out.println(x1);
        System.out.println(shiftLinkedList(x1, -14));

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
