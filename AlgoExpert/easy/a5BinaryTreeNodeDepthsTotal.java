package com.algoexpert.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class a5BinaryTreeNodeDepthsTotal {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(1).insert(Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9, 10));
        int sum = nodeDepths(tree);
        System.out.println("Expected: " + 19 + "\nActual: " + sum);
    }

    public static int nodeDepths(BinaryTree root) {
        // Write your code here.
        Integer sum = new Integer(0);
        sum = nodeDepths(root, sum);
        return sum;
    }

    //Time : O(n) and space : O(n)
    public static int nodeDepths(BinaryTree tree, int sum) {
        int incomingSum = sum;
        if(tree == null) {
            return 0;
        }
        if(tree.left == null && tree.right == null) {
            return sum;
        }
        sum = sum + nodeDepths(tree.left, incomingSum+1);
        sum = sum + nodeDepths(tree.right, incomingSum+1);
        return sum;
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
                queue.add(current.left);
                if (current.right == null) {
                    current.right = new BinaryTree(values.get(i));
                    break;
                }
                queue.add(current.right);
            }
            insert(values, i + 1);
            return this;
        }
    }
}
