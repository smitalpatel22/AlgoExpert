package com.algoexpert.medium;

public class c21BinaryTreeDiameter {
    public static int binaryTreeDiameter(BinaryTree tree) {

        return binaryTreeDiameterInternal(tree).diameter;

    }

    public static TreeInfo binaryTreeDiameterInternal(BinaryTree tree) {

        if(tree == null) {
            return new TreeInfo(0,0);
        }

        TreeInfo leftInfo = binaryTreeDiameterInternal(tree.left);
        TreeInfo rightInfo = binaryTreeDiameterInternal(tree.right);

        int longestPathSoFar = leftInfo.height + rightInfo.height;
        int maxDiameterSoFar = Math.max(leftInfo.diameter, rightInfo.diameter);
        int currentDiameter = Math.max(longestPathSoFar, maxDiameterSoFar);
        int currentHeight = Math.max(leftInfo.height, rightInfo.height);

        return new TreeInfo(currentDiameter, currentHeight);

    }

    /*
    My Solution:
    public static TreeInfo binaryTreeDiameterInternal(BinaryTree tree) {

        if(tree == null) {
            return new TreeInfo(0,0);
        }

        TreeInfo leftDia = binaryTreeDiameterInternal(tree.left);
        TreeInfo rightDia = binaryTreeDiameterInternal(tree.right);

        if(tree.left != null) {
            leftDia.height += 1;
        }
        if(tree.right != null) {
            rightDia.height +=1;
        }
        int diameter = Math.max(Math.max(leftDia.diameter, rightDia.diameter), leftDia.height + rightDia.height);
        return new TreeInfo(diameter, Math.max(leftDia.height, rightDia.height));

    }
     */

    static class BinaryTree {
        public int value;
        public BinaryTree left;
        public BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "BinaryTree{" +
                    "value=" + value +
                    '}';
        }
    }

    static class TreeInfo {
        public int diameter;
        public int height;

        public TreeInfo(int diameter, int height) {
            this.diameter = diameter;
            this.height = height;
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

        System.out.println(binaryTreeDiameter(root));
    }


}
