package com.algoexpert.hard;

public class a2Validate3Nodes {

    //Time : h || Space : 1 ==> h=height of tree
    public boolean validateThreeNodes(BST nodeOne, BST nodeTwo, BST nodeThree) {
        if(isDescendent(nodeOne, nodeTwo)) {
            return isDescendent(nodeTwo, nodeThree);
        }
        if(isDescendent(nodeThree, nodeTwo)) {
            return isDescendent(nodeTwo, nodeOne);
        }
        return false;
    }

    private boolean isDescendent(BST node, BST target) {
        while(node != null && node != target) {
            node = target.value < node.value ? node.left : node.right;
        }
        return node == target;
//        BST current = node;
//        while(current != null) {
//            if(target.value > current.value) {
//                current = current.right;
//            } else if(target.value < current.value) {
//                current = current.left;
//            } else {
//                return true;
//            }
//        }
//        return false;
    }

    // This is an input class. Do not edit.
    static class BST {
        public int value;
        public BST left = null;
        public BST right = null;

        public BST(int value) {
            this.value = value;
        }
    }
}
