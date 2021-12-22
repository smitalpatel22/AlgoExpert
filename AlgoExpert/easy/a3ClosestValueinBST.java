package com.algoexpert.easy;

public class a3ClosestValueinBST {

    static class TreeNode {
        public int value;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

//     Iteratively :
//     Avg: O(log(n)) Worst: O(n)
//     Space: Avg: O(1)  Worst : O(1) as we only store 2 values
    public static int findClosestValueInBst(TreeNode tree, int target) {
        if(target == tree.value) return target;

        int diff = target;
        int closest = tree.value;
        while((tree != null && (tree.left != null || tree.right != null))
                || (tree != null && Math.abs(target-tree.value) < diff)) {
            if(Math.abs(target-closest) > Math.abs(target-tree.value)) {
                diff = Math.abs(target-tree.value);
                closest = tree.value;
            }
            if(target > tree.value) {
                tree = tree.right;
            } else if(target < tree.value) {
                tree = tree.left;
            }
        }
        if(tree != null && (tree.left == null || tree.right == null) && target == tree.value) {
            return target;
        }
        return closest;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(2);
        root.left.left.left = new TreeNode(1);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(13);
        root.right.left.right = new TreeNode(14);
        root.right.right = new TreeNode(22);

        int expected = 13;
        int actual = findClosestValueInBst(root, 12);
        System.out.println("Expected: "+expected+"\nActual:"+actual);

        root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(2);
        root.left.left.left = new TreeNode(1);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(12);
        root.right.left = new TreeNode(11);
//        root.right.left.right = new BST(14);
        root.right.right = new TreeNode(13);

        expected = 13;
        actual = findClosestValueInBst(root, 13);
        System.out.println("Expected: "+expected+"\nActual:"+actual);

        root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(2);
        root.left.left.left = new TreeNode(-2);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(12);
        root.right.left = new TreeNode(11);
        root.right.right = new TreeNode(13);

        expected = -2;
        actual = findClosestValueInBst(root, -3);
        System.out.println("Expected: "+expected+"\nActual:"+actual);
    }

// Recursive:
// Avg: O(log(n))  Worst: O(n) if only 1 long branch
// Space : Same as above as we save stack of calls
    public static int findClosestValueInBstHelper(TreeNode tree, int target, int closest) {
        if(tree == null) {
            return closest;
        }
        if(Math.abs(closest-target) > Math.abs(tree.value-target)) {
            closest = tree.value;
        }
        if(target<tree.value) {
            return findClosestValueInBstHelper(tree.left, target, closest);
        } else if (target>tree.value) {
            return findClosestValueInBstHelper(tree.right, target, closest);
        } else {
            return closest;
        }
    }
}













