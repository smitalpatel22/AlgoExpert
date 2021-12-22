package com.algoexpert.medium;

public class b16ValidateBST {
    public static void main(String[] args) {
        BST root = new BST(10);
        root.left = new BST(5);
        root.left.left = new BST(2);
        root.left.left.left = new BST(1);
        root.left.right = new BST(5);
        root.right = new BST(15);
        root.right.left = new BST(13);
        root.right.left.right = new BST(14);
        root.right.right = new BST(22);

        boolean isValidBST = validateBst(root);
        System.out.println(isValidBST);

        root = new BST(10);
        root.left = new BST(5);
        root.left.right = new BST(10);
        root.right = new BST(15);

        isValidBST = validateBst(root);
        System.out.println(isValidBST);
    }

    private static boolean validateBst(BST root) {

        return validateBst(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean validateBst(BST root,int minValue, int maxValue) {

        if(!(root.value>=minValue && root.value<maxValue)) {
            return false;
        }

        if(root.left != null ) {
            boolean flag = validateBst(root.left, minValue, root.value);
            if(!flag) {
                return flag;
            }
        }

        if(root.right != null ) {
            boolean flag = validateBst(root.right, root.value, maxValue);
            if(!flag) {
                return flag;
            }
        }
        return true;
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }

    }
}
