package com.algoexpert.medium;

public class a14BSTImplementationIterative {
    public static void main(String[] args) {
        BST root = new BST(10);
//        root.left = new BST(5);
//        root.left.left = new BST(2);
//        root.left.left.left = new BST(1);
//        root.left.right = new BST(5);
//        root.right = new BST(15);
//        root.right.left = new BST(13);
//        root.right.left.right = new BST(14);
//        root.right.right = new BST(22);

        root.insert(5);
        root.insert(15);
        root.insert(2);
        root.insert(5);
        root.insert(13);
        root.insert(22);
        root.insert(1);
        root.insert(14);
        root.insert(12);
        root.remove(10);
        root.contains(15);


        boolean contains = root.contains(12);
        System.out.println(contains);
        root.remove(12);
        contains = root.contains(12);
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
                return new BST(value);
            }

            BST currentNode = root;

            while(true) {
                if(value < currentNode.value) {
                    if(currentNode.left == null) {
                        currentNode.left = new BST(value);
                        break;
                    } else {
                        currentNode=currentNode.left;
                    }
                } else {
                    if(currentNode.right == null) {
                        currentNode.right = new BST(value);
                        break;
                    } else {
                        currentNode=currentNode.right;
                    }
                }
            }
            return this;
        }

        public boolean contains(int value) {
            return contains(this, value);
        }

        public boolean contains(BST root, int value) {
            BST currentNode = this;

            while(currentNode != null) {
                if (value < currentNode.value) {
                    if (currentNode.left != null) {
                        currentNode = currentNode.left;
                    } else {
                        return false;
                    }
                } else if (value > root.value) {
                    if (currentNode.right != null) {
                        currentNode = currentNode.right;
                    } else {
                        return false;
                    }
                } else {
                    return true;
                }
            }
            return false;
        }

        public BST remove(int value) {
            remove(null, value);
            return this;
        }

        private void remove(BST parentNode, int value) {

            BST currentNode = this;

            while(currentNode != null) {
                if (value > currentNode.value) {
                    parentNode = currentNode;
                    currentNode = currentNode.right;
                } else if (value < currentNode.value) {
                    parentNode = currentNode;
                    currentNode = currentNode.left;
                } else {
                    if(currentNode.left!=null && currentNode.right != null) {
                        currentNode.value = currentNode.right.getMinimumValue();
                        currentNode.right.remove(currentNode, currentNode.value);
                    } else if (parentNode == null) {
                        if(currentNode.left != null) {
                            currentNode.value = currentNode.left.value;
                            currentNode.right = currentNode.left.right;
                            currentNode.left = currentNode.left.left;
                        } else if (currentNode.right != null) {
                            currentNode.value = currentNode.right.value;
                            currentNode.left = currentNode.right.left;
                            currentNode.right = currentNode.right.right;
                        } else {
                            //Do nothing
                        }
                    } else if (parentNode.left == currentNode) {
                        parentNode.left = currentNode.left != null ? currentNode.left : currentNode.right;
                    } else if(parentNode.right == currentNode) {
                        parentNode.right = currentNode.left != null ? currentNode.left : currentNode.right;
                    }
                    break;
                }
            }
        }

        private int getMinimumValue() {
            BST currentNode = this;
            while(currentNode != null) {
                currentNode = currentNode.left;
            }
            return currentNode.value;
        }
    }
}
