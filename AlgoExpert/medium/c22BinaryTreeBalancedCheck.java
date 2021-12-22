package com.algoexpert.medium;

public class c22BinaryTreeBalancedCheck {
    public static BinaryTree findSuccessor(BinaryTree tree, BinaryTree predecessor) {

        TreeInfo info = new TreeInfo();
        findSuccessorInternal(tree, predecessor, info);
        return info.successor;
    }

    public static void findSuccessorInternal(BinaryTree tree, BinaryTree predecessor, TreeInfo info) {

        if(tree == null) {
            return;
        }
        if(info.found && info.successor!=null) {
            return;
        }

        findSuccessorInternal(tree.left, predecessor, info);
        if(info.found && info.successor==null) {
            info.successor = tree;
        }
        if(tree.value == predecessor.value) {
            info.found = true;
        }
        findSuccessorInternal(tree.right, predecessor, info);

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
        public boolean found;
        public BinaryTree successor;
    }

    public static void main(String[] args) {
        BinaryTree root = new BinaryTree(1);
        root.left = new BinaryTree(2);
        root.left.left = new BinaryTree(4);
        root.left.left.left = new BinaryTree(6);
        root.left.right = new BinaryTree(5);
        root.right = new BinaryTree(3);

        System.out.println(findSuccessor(root, root.left.right));

        BinaryTree root2 = new BinaryTree(1);
        root2.left = new BinaryTree(2);
        root2.left.left = new BinaryTree(4);
        root2.left.right = new BinaryTree(5);
        root2.left.right.left = new BinaryTree(6);
        root2.left.right.right = new BinaryTree(7);
        root2.left.right.right.left = new BinaryTree(8);
        root2.right = new BinaryTree(3);

        System.out.println(findSuccessor(root2, root2.left.right));

        BinaryTree root3 = new BinaryTree(1);

        System.out.println(findSuccessor(root3, root3));
    }


}
