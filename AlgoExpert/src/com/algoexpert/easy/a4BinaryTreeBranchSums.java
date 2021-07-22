package com.algoexpert.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class a4BinaryTreeBranchSums {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(1).insert(Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9, 10));
        List<Integer> expected = new ArrayList<>(Arrays.asList(15, 16, 18, 10, 11));

        List<Integer> actual = branchSums(tree);
        System.out.println("Expected: " + expected + "\nActual: " + actual);
    }

    public static List<Integer> branchSums(BinaryTree tree) {
        List<Integer> sums = new ArrayList<>();
        branchSumsHelper(tree, 0, sums);
        return sums;
    }

    //Time : O(n) and space : O(n)
    public static void branchSumsHelper(BinaryTree tree, int sum, List<Integer> sums) {
        if(tree == null) {
            return;
        }
        if(tree.left == null && tree.right == null) {
            sums.add(sum+tree.value);
            return;
        }
        branchSumsHelper(tree.left, sum+tree.value, sums);
        branchSumsHelper(tree.right, sum+tree.value, sums);
    }

    static class BinaryTree {
        public int value;
        public BinaryTree left;
        public BinaryTree right;
        BinaryTree(int value) {
            this.value = value;
            left = null;
            right = null;
        }

        BinaryTree insert(List<Integer> values) {
            return insert(values, 0);
        }

        BinaryTree insert(List<Integer> values, int i) {
            if (i >= values.size()) return null;

            List<BinaryTree> queue = new ArrayList<BinaryTree>();
            queue.add(this);
            while (queue.size() > 0) {
                BinaryTree current = queue.get(0);
                queue.remove(0);
                if (current.left == null) {
                    current.left = new BinaryTree(values.get(i));
                    break;
                }
                queue.add((BinaryTree) current.left);
                if (current.right == null) {
                    current.right = new BinaryTree(values.get(i));
                    break;
                }
                queue.add((BinaryTree) current.right);
            }
            insert(values, i + 1);
            return this;
        }
    }
}
