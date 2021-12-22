package com.algoexpert.medium;

import java.util.ArrayList;
import java.util.List;

public class b18BSTFindKthLargestElement {

    public static void main(String[] args) {
        BST root = new BST(15);
        root.left = new BST(5);
        root.left.left = new BST(2);
        root.left.left.left = new BST(1);
        root.left.left.right = new BST(3);
        root.left.right = new BST(5);
        root.right = new BST(20);
        root.right.left = new BST(17);
        root.right.right = new BST(22);
        int k = 7;
        int element = findKthLargestValueInBst(root,k);
        System.out.println("Answer using first method : "+element);

        root = new BST(5);
        k = 1;
        element = findKthLargestValueInBst(root,k);
        System.out.println("Answer using first method : "+element);
    }

    public static int findKthLargestValueInBst(BST tree, int k) {
        List<Integer> elements = new ArrayList<>();

        //1st method
        findKthLargestValueInBst(tree, elements,k );

        //1st method with inorder traversal
        List<Integer> sortedNodeValues = new ArrayList<>();
        inorderTraverse(tree, sortedNodeValues);
        System.out.println(sortedNodeValues);

        //2nd method
        NodeInfo info = new NodeInfo(0, -1);
        findKthLargestValueInBst(tree, info, k);
        System.out.println("Answer using second method : "+info.lastVisitedNode);

        return elements.get(elements.size()-1);
    }

    private static void inorderTraverse(BST node, List<Integer> sortedNodeValues) {
        if (node == null) {
            return;
        }
        inorderTraverse(node.left, sortedNodeValues);
        sortedNodeValues.add(node.value);
        inorderTraverse(node.right, sortedNodeValues);
    }

    static boolean done = false;

    //1st method
    //O(h+k) || O(k)
    public static void findKthLargestValueInBst(BST tree, List<Integer> elements, int k) {
        if(elements.size()==0) {done=false;}
        if(tree==null) {return;}
        if(!done) {
            findKthLargestValueInBst(tree.right, elements, k);
        } else {
            return;
        }
        if(!done) {
            elements.add(tree.value);
            if (elements.size() == k) {
                done = true;
                return;
            }
            findKthLargestValueInBst(tree.left, elements, k);
        }
        return;
    }


    //2nd method
    //O(h+k) || O(1)
    public static void findKthLargestValueInBst(BST tree, NodeInfo info, int k) {
        if(tree==null || info.noOfVisitedNodes>=k) {return;}

        findKthLargestValueInBst(tree.right, info , k);

        if(info.noOfVisitedNodes < k) {
            info.noOfVisitedNodes = info.noOfVisitedNodes +1;
            info.lastVisitedNode = tree.value;
            findKthLargestValueInBst(tree.left, info, k);
        }
    }

    static class BST {
        public int value;
        public BST left = null;

        public BST right = null;
        public BST(int value) {
            this.value = value;
        }

    }

    static class NodeInfo {
        public int noOfVisitedNodes;
        public int lastVisitedNode;

        public NodeInfo(int noOfVisitedNodes, int lastVisitedNode) {
            this.noOfVisitedNodes = noOfVisitedNodes;
            this.lastVisitedNode = lastVisitedNode;
        }
    }
}
