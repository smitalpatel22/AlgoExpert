package com.algoexpert.medium;

public class c23BinaryTreeNodeInorderSuccessor {
    public static boolean heightBalancedBinaryTree(BinaryTree tree) {

        TreeInfo treeInfo = getTreeInfo(tree);
        return treeInfo.isBalanced;
    }

    public static TreeInfo getTreeInfo(BinaryTree tree) {

        if(tree == null) {
            return new TreeInfo(0,true);
        }

        TreeInfo leftInfo = getTreeInfo(tree.left);
        TreeInfo rightInfo = getTreeInfo(tree.right);
        if(!leftInfo.isBalanced || !rightInfo.isBalanced) {
            return new TreeInfo(0, false);
        }

        if(tree.left != null) {
            leftInfo.height += 1;
        }
        if(tree.right != null) {
            rightInfo.height +=1;
        }
        if(Math.abs(leftInfo.height-rightInfo.height)>1) {
            return new TreeInfo(0, false);
        }

        return new TreeInfo(Math.max(leftInfo.height, rightInfo.height), true);
    }

    public static TreeInfo getTreeInfoTheirSolution(BinaryTree tree) {

        if(tree == null) {
            return new TreeInfo(-1,true);
        }

        TreeInfo leftInfo = getTreeInfoTheirSolution(tree.left);
        TreeInfo rightInfo = getTreeInfoTheirSolution(tree.right);

        boolean isBalanced = leftInfo.isBalanced && rightInfo.isBalanced && Math.abs(leftInfo.height-rightInfo.height)<=1;

        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        return new TreeInfo(height, isBalanced);
    }

    static class BinaryTree {
        public int value;
        public BinaryTree left;
        public BinaryTree right;

        public BinaryTree(Integer value) {
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
        public int height;
        public boolean isBalanced;
        public TreeInfo(int height, boolean isBalanced) {
            this.height = height;
            this.isBalanced = isBalanced;
        }
    }

    public static void main(String[] args) {
        BinaryTree root = new BinaryTree(1);
        root.left = new BinaryTree(2);
        root.left.left = new BinaryTree(4);
        root.left.right = new BinaryTree(5);
        root.left.right.left = new BinaryTree(7);
        root.left.right.right = new BinaryTree(8);
        root.right = new BinaryTree(3);
        root.right.right = new BinaryTree(6);
        System.out.println(heightBalancedBinaryTree(root));

        BinaryTree root2 = new BinaryTree(1);
        root2.left = new BinaryTree(2);
        root2.left.left = new BinaryTree(4);
        root2.left.right = new BinaryTree(5);
        root2.left.right.left = new BinaryTree(7);
        root2.left.right.left.left = new BinaryTree(9);
        root2.left.right.right = new BinaryTree(8);
        root2.right = new BinaryTree(3);
        root2.right.right = new BinaryTree(6);
        System.out.println(heightBalancedBinaryTree(root2));

        BinaryTree root3 = new BinaryTree(1);
        System.out.println(heightBalancedBinaryTree(root3));

        BinaryTree root4 = new BinaryTree(1);
        root4.left = new BinaryTree(2);
        root4.left.left = new BinaryTree(3);
        System.out.println(heightBalancedBinaryTree(root4));
    }


}
