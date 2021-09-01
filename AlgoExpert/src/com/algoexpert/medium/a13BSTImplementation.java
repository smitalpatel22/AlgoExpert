package com.algoexpert.medium;

public class a13BSTImplementation {
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

        root.insert(12);

        boolean contains = root.contains(12);
        System.out.println(contains);
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }

        public BST insert(int value) {
            insert(this,value);
            return this;
        }

        public BST insert(BST root, int value) {

            if (root == null) {
                root = new BST(value);
                return root;
            }

            if(value > root.value) {
                if(root.right == null) {
                    root.right = new BST(value);
                    return this;
                }
                insert(root.right, value);
            } else {
                if(root.left == null) {
                    root.left = new BST(value);
                    return this;
                }
                insert(root.left,value);
            }
            return this;
        }

        public boolean contains(int value) {
            return contains(this, value);
        }

        public boolean contains(BST root, int value) {
            if (root == null) {
                return false;
            }

            if(value > root.value) {
                if(root.right != null) {
                    return contains(root.right, value);
                }
            } else if(value < root.value) {
                if(root.left != null) {
                    return contains(root.left, value);
                }
            } else {
                return true;
            }
            return false;
        }

        public BST remove(int value) {
            remove(this, value);
            return this;
        }

        private BST remove(BST root, int value) {
            if (root == null) {
                return this;
            }

            if(value > root.value) {
                if(root.right != null) {
                    return remove(root.right, value);
                }
            } else if(value < root.value) {
                if(root.left != null) {
                    return remove(root.left, value);
                }
            } else {
                return this;
            }
            return this;
        }
    }
}
