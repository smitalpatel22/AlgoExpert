package com.algoexpert.medium;

public class d39DoublyLinkedList {
    public Node head;
    public Node tail;

    public void setHead(Node node) {
        if(head == null) {                          //empty list
            head = node;
            tail = node;
        } else {
            insertBefore(head, node);
        }
    }

    public void setTail(Node node) {
        if(tail == null) {
            head = node;
            tail = node;
        } else {
            insertAfter(tail, node);
        }
    }

    public void insertBefore(Node node, Node nodeToInsert) {

        if(nodeToInsert==tail && nodeToInsert==head) {              //if the node to be inserted is the only node existing
            return;
        }

        remove(nodeToInsert);                               //if same node is existing & we are inserting same i.e. not same value
        nodeToInsert.prev = node.prev;
        nodeToInsert.next = node;
        if(node.prev==null) {                               //node is head node
            head = nodeToInsert;
        } else {                                            //node is not head
            node.prev.next = nodeToInsert;
        }
        node.prev = nodeToInsert;
    }

    public void insertAfter(Node node, Node nodeToInsert) {
        if(nodeToInsert==head && nodeToInsert==tail) {
            return;
        }

        remove(nodeToInsert);
        nodeToInsert.prev = node;
        nodeToInsert.next = node.next;
        if(node.next==null) {
            tail = nodeToInsert;
        } else {
            node.next.prev = nodeToInsert;
        }
        node.next = nodeToInsert;
    }

    public void insertAtPosition(int position, Node nodeToInsert) {

        if(position==1) {
            setHead(nodeToInsert);
            return;
        }
        int currPosition = 1;
        Node currentNode = head;
        while(currentNode != null && currPosition!= position){
            currentNode = currentNode.next;
            currPosition++;
        }
        if(currentNode != null) {
            insertBefore(currentNode, nodeToInsert);
        } else {
            setTail(nodeToInsert);
        }
    }

    public void removeNodesWithValue(int value) {
        Node currentNode = head;
        while(currentNode != null) {
            if(currentNode.value==value) {
                Node tempNext = currentNode.next;
                remove(currentNode);                    //we cannot return after this, coz we need to remove all nodes with value
                currentNode = tempNext;
            } else {
                currentNode = currentNode.next;
            }
        }
    }

    public void remove(Node node) {
        if(node==head) {
            head = head.next;
        }
        if(node==tail) {
            tail = tail.prev;
        }
        removeNodeBindings(node);
    }

    private void removeNodeBindings(Node node) {
        if(node.prev != null) node.prev.next = node.next;
        if(node.prev != null) node.next.prev = node.prev;
        node.prev = null;
        node.next = null;
    }

    public boolean containsNodeWithValue(int value) {
        Node currentNode = head;
        while(currentNode != null) {
            if(currentNode.value==value) {
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
    }

    static class Node {
        public int value;
        public Node prev;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        d39DoublyLinkedList linkedList = new d39DoublyLinkedList();
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node three2 = new Node(3);
        Node three3 = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);
        bindNodes(one, two);
        bindNodes(two, three);
        bindNodes(three, four);
        bindNodes(four, five);
        linkedList.head = one;
        linkedList.tail = five;

        linkedList.setHead(four);
    }

    private static void bindNodes(Node nodeOne, Node nodeTwo) {
        nodeOne.next = nodeTwo;
        nodeTwo.prev = nodeOne;
    }
}
