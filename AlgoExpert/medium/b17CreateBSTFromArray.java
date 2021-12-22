package com.algoexpert.medium;

import java.util.Arrays;
import java.util.List;

public class b17CreateBSTFromArray {


    public static void main(String[] args) {
        List<Integer> array = Arrays.asList(1, 2, 5, 7, 10, 13, 14, 15, 22);
        BST tree = minHeightBst(array);
    }

    private static BST minHeightBst(List<Integer> array) {

        BST bst = minHeightBst(array, null, 0, array.size() - 1);
        return bst;
    }

    private static BST minHeightBst(List<Integer> array, BST root, int left, int right) {

        if(right<left) { return null;}

        int mid = (left+right) / 2;
        Integer midValue = array.get(mid);
        BST newNode = new BST(midValue);
        if(root==null) {
            root = newNode;
        } else {
            if(midValue < root.value) {
                root.left = newNode;
                root = root.left;
            } else {
                root.right = newNode;
                root = root.right;
            }
        }

        minHeightBst(array, root, left, mid-1);
        minHeightBst(array, root, mid+1, right);
        return root;
    }

    private static BST minHeightBst(List<Integer> array, int left, int right) {

        if(right<left) { return null;}

        int mid = (left+right) / 2;
        Integer midValue = array.get(mid);
        BST newNode = new BST(midValue);

        newNode.left = minHeightBst(array, left, mid-1);
        newNode.right = minHeightBst(array, mid+1, right);
        return newNode;
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
            left = null;
            right = null;
        }

        public void insert(int value) {
            if (value < this.value) {
                if (left == null) {
                    left = new BST(value);
                } else {
                    left.insert(value);
                }
            } else {
                if (right == null) {
                    right = new BST(value);
                } else {
                    right.insert(value);
                }
            }
        }
    }
}
