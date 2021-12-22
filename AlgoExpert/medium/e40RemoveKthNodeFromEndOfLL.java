package com.algoexpert.medium;

public class e40RemoveKthNodeFromEndOfLL {
    public static void removeKthNodeFromEnd(LinkedList head, int k) {
        int secondCounter = 0;

        LinkedList second = head;
        while(secondCounter<=k) {
            second = second.next;
            secondCounter++;
        }

        if(second==null) {
            head.value = head.next.value;
            LinkedList nodeToRemove = head.next;
            head.next = head.next.next;
            nodeToRemove.next=null;
            return;
        }

        LinkedList firstNode = head;
        while(second.next != null) {
            firstNode = firstNode.next;
            second = second.next;
        }
        LinkedList nodeToRemove = firstNode.next;
        firstNode.next = firstNode.next.next;
        nodeToRemove.next = null;

    }

    static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }

        public void addMany(LinkedList list, int[] values) {
            while (list.next != null) {
                list = list.next;
            }
            for (int value : values) {
                list.next = new LinkedList(value);
                list = list.next;
            }
        }
    }

    public static void main(String[] args) {
        LinkedList test = new LinkedList(0);
        test.addMany(test, new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9});
        removeKthNodeFromEnd(test, 10);
    }


}
