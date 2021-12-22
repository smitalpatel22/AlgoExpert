package com.algoexpert.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class b19ReconstructBST {

    public static int counter;

    public static void main(String[] args) {
        List<Integer> preOrderTraversalValues = null;

//        preOrderTraversalValues = new ArrayList<>(Arrays.asList(10, 4, 2, 1, 3, 17, 19, 18));
//        preOrderTraversalValues = new ArrayList<>(Arrays.asList(2,0,1,3,4,3));
        preOrderTraversalValues = new ArrayList<>(Arrays.asList(10, 4, 2, 1, 3, 5, 5, 6, 5, 5, 9, 7, 17, 19, 18, 18, 19));

        reconstructBst(preOrderTraversalValues);
    }

    public static BST reconstructBst(List<Integer> preOrderTraversalValues) {
        TreeInfo treeInfo = new TreeInfo(0);
        BST bst = reconstructBstMySolution(Integer.MIN_VALUE, Integer.MAX_VALUE, preOrderTraversalValues, treeInfo);
        return bst;
    }

    public static BST reconstructBstMySolution(int min, int max, List<Integer> values, TreeInfo info) {

        BST root = new BST(values.get(info.pointer));
        if(root.value < min || root.value >= max) { return null;}
        while(info.pointer+1 < values.size()) {

            if(values.get(info.pointer+1) < root.value && values.get(info.pointer+1)>=min && values.get(info.pointer+1)<root.value) {
                info.pointer = info.pointer + 1;
                root.left = reconstructBstMySolution(min, root.value, values, info);
            } else if(values.get(info.pointer+1) > root.value && values.get(info.pointer+1)>root.value && values.get(info.pointer+1)<=max) {
                info.pointer = info.pointer + 1;
                root.right = reconstructBstMySolution(root.value, max, values, info);
            } else {
                return root;
            }
        }
        return root;
    }

    public BST reconstructBst(ArrayList<Integer> preOrderTraversalValues) {
        TreeInfo treeInfo = new TreeInfo(0);
        BST bst = reconstructBst(Integer.MIN_VALUE, Integer.MAX_VALUE, preOrderTraversalValues, treeInfo);
        return bst;
    }

    public static BST reconstructBst(int min, int max, List<Integer> values, TreeInfo info) {

        if(info.pointer==values.size()) {
            return null;
        }

        Integer rootValue = values.get(info.pointer);
        if(rootValue<min || rootValue>=max) {
            return null;
        }

        info.pointer += 1;

        BST leftTree = reconstructBst(min, rootValue, values, info);
        BST rightTree = reconstructBst(rootValue, max, values, info);

        BST root = new BST(rootValue);
        root.left = leftTree;
        root.right = rightTree;
        return root;
    }


    static class TreeInfo {
        public int pointer;

        public TreeInfo(int pointer) {
            this.pointer = pointer;
        }
    }

    static class BST {
        public int value;
        public BST left = null;
        public BST right = null;

        public BST(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "value=" + value +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

}
