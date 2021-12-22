package com.algoexpert.medium;

import sun.awt.image.ImageWatched;

public class e41SumOfLinkedLists {
    // This is an input class. Do not edit.
    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }

        public static LinkedList addMany(LinkedList linkedList, int[] values) {
            LinkedList current = linkedList;
            while (current.next != null) {
                current = current.next;
            }
            for (int value : values) {
                current.next = new LinkedList(value);
                current = current.next;
            }
            return linkedList;
        }
    }

    //O(max(n,m)) | O(max(n,m))
    public static LinkedList sumOfLinkedLists(LinkedList llOne, LinkedList llTwo) {
        LinkedList outputHead = new LinkedList(0);

        LinkedList currentNode = outputHead;
        int carry=0;

        while(llOne!=null && llTwo!=null) {
            int value1 = llOne.value;
            int value2 = llTwo.value;

            int sum = value1 + value2 + carry;

            carry = sum/10;
            int nodeValue = sum%10;
            currentNode.next = new LinkedList(nodeValue);
            llOne = llOne.next;
            llTwo = llTwo.next;
            currentNode = currentNode.next;
        }
        while(llOne==null && llTwo!=null) {
            int value2 = llTwo.value;
            int sum = value2 + carry;

            carry = sum/10;
            int nodeValue = sum%10;
            currentNode.next = new LinkedList(nodeValue);
            llTwo = llTwo.next;
            currentNode = currentNode.next;
        }
        while(llOne!=null && llTwo==null) {
            int value1 = llOne.value;
            int sum = value1 + carry;

            carry = sum/10;
            int nodeValue = sum%10;
            currentNode.next = new LinkedList(nodeValue);
            llOne = llOne.next;
            currentNode = currentNode.next;
        }
        if(carry!=0) {
            currentNode=outputHead;
            while(currentNode.next!=null) {
                currentNode = currentNode.next;
            }
            currentNode.next = new LinkedList(carry);
        }
        return outputHead.next;
    }

    public static LinkedList sumOfLinkedListsTheir(LinkedList llOne, LinkedList llTwo) {
        LinkedList newLinkedListHeadPointer = new LinkedList(0);
        LinkedList currentNode = newLinkedListHeadPointer;
        int carry = 0;

        LinkedList nodeOne = llOne;
        LinkedList nodeTwo = llTwo;

        while(nodeOne != null || nodeTwo != null || carry != 0) {
            int valueOne = (nodeOne!=null) ? nodeOne.value  : 0;
            int valueTwo = (nodeTwo!=null) ? nodeTwo.value  : 0;

            int sumOfValues = valueOne + valueTwo + carry;

            int newValue = sumOfValues % 10;
            LinkedList newNode = new LinkedList(newValue);
            currentNode.next = newNode;
            currentNode = newNode;

            carry = sumOfValues/10;
            nodeOne = nodeOne!=null ? nodeOne.next : null;
            nodeTwo = nodeTwo!=null ? nodeTwo.next : null;
        }
        return newLinkedListHeadPointer;
    }

    public static void main(String[] args) {
        LinkedList ll1 = new LinkedList(2);
        LinkedList.addMany(ll1, new int[] {4, 7, 1});

        LinkedList ll2 = new LinkedList(9);
        LinkedList.addMany(ll2, new int[] {4, 5});

        sumOfLinkedLists(ll1, ll2);
    }
}