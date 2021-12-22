package com.algoexpert.medium;

import java.util.ArrayDeque;

public class c20InvertBinaryTree {

    //Time: O(n) Space: O(d)     ==> Better solution
    public static void invertBinaryTreeRecursion(BinaryTree tree) {

        if(tree == null) {
            return;
        }

        swapLeftAndRight(tree);
        invertBinaryTreeRecursion(tree.left);
        invertBinaryTreeRecursion(tree.right);
    }

    private static void swapLeftAndRight(BinaryTree tree) {
        BinaryTree left = tree.left;
        tree.left = tree.right;
        tree.right = left;
    }

    //Time: O(n) Space: O(n)
    public static void invertBinaryTreeIterative(BinaryTree tree) {

        ArrayDeque<BinaryTree> queue = new ArrayDeque<>();
        queue.addLast(tree);
        while(queue.size()>0) {
            BinaryTree current = queue.pollFirst();
            swapLeftAndRight(current);
            if(current.left != null) {
                queue.addLast(current.left);
            }
            if(current.right != null) {
                queue.addLast(current.right);
            }
        }
    }

    public static void main(String[] args) {
        BinaryTree root = new BinaryTree(1);
        root.left = new BinaryTree(3);
        root.left.left = new BinaryTree(7);
        root.left.left.left = new BinaryTree(8);
        root.left.left.left.left = new BinaryTree(9);
        root.left.right = new BinaryTree(4);
        root.left.right.right = new BinaryTree(5);
        root.left.right.right.right = new BinaryTree(6);
        root.right = new BinaryTree(2);

        invertBinaryTreeRecursion(root);
        invertBinaryTreeIterative(root);
        System.out.println(root.value);
    }

    static class BinaryTree {
        public int value;
        public BinaryTree left;
        public BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
        }
    }
}