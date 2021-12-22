package com.algoexpert.hard;

import java.util.*;

public class a3FindNodesDistanceK {
    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    static class Pair<U, V> {
        public final U first;
        public final V second;

        Pair(U first, V second) {
            this.first = first;
            this.second = second;
        }
    }

    //Time: 4n~n || Space: 2n~n
    //Time : 4n ==> BFS takes Vertices+Edge time, but E is less than V in binary tree. So V+E < 2n as lead nodes dont have Edges.
    //Also we did DFS for populating parents which will take another 2n time.
    //So total time = 2n+2n = 4n ~~ n
    //Space : 2n ==> Visited set n + Parents n
    public static ArrayList<Integer> findNodesDistanceK(BinaryTree tree, int target, int k) {
        HashMap<Integer, BinaryTree> nodeToParents = new HashMap<>();
        populateParents(tree, nodeToParents, null);
        BinaryTree targetNode = getNodeFromValue(target, tree, nodeToParents);
        return bfsForNodesDistance(targetNode, nodeToParents, k);
    }

    private static ArrayList<Integer> bfsForNodesDistance(BinaryTree targetNode, HashMap<Integer, BinaryTree> nodeToParents, int k) {
        Set<Integer> visited = new HashSet<>();
        Queue<Pair<BinaryTree, Integer>> queue = new ArrayDeque<>();
        queue.offer(new Pair<>(targetNode, 0));
        visited.add(targetNode.value);

        while(!queue.isEmpty()) {
            Pair<BinaryTree, Integer> currentPair = queue.poll();
            BinaryTree currentNode = currentPair.first;
            Integer currentDistance = currentPair.second;

            if(currentDistance==k) {
                ArrayList<Integer> kDistancedNodeValues = new ArrayList<>();
                kDistancedNodeValues.add(currentNode.value);
                while(!queue.isEmpty()) {
                    kDistancedNodeValues.add(queue.poll().first.value);
                }
                return kDistancedNodeValues;
            }

            List<BinaryTree> toBeVisited = new ArrayList<>();
            toBeVisited.add(currentNode.left);
            toBeVisited.add(currentNode.right);
            toBeVisited.add(nodeToParents.get(currentNode.value));

            for(BinaryTree node : toBeVisited) {
                if(node == null || visited.contains(node.value)){
                    continue;
                }
                visited.add(node.value);
                queue.offer(new Pair<>(node, currentDistance+1));
            }
        }
        return new ArrayList<>();
    }

    private static BinaryTree getNodeFromValue(int target, BinaryTree tree, HashMap<Integer, BinaryTree> nodeToParents) {
        if(tree.value == target) {
            return tree;
        }
        BinaryTree parentNode = nodeToParents.get(target);
        if(parentNode.left != null && parentNode.left.value == target) {
            return parentNode.left;
        }
        return parentNode.right;
    }

    private static void populateParents(BinaryTree node, HashMap<Integer, BinaryTree> nodeToParents, BinaryTree parent) {
        if(node == null) return;
        nodeToParents.put(node.value, parent);
        populateParents(node.left, nodeToParents, node);
        populateParents(node.right, nodeToParents, node);
    }

    public static void main(String[] args) {
        BinaryTree root = new BinaryTree(1);
        root.left = new BinaryTree(2);
        root.right = new BinaryTree(3);
        root.left.left = new BinaryTree(4);
        root.left.right = new BinaryTree(5);
        root.right.right = new BinaryTree(6);
        root.right.right.left = new BinaryTree(7);
        root.right.right.right = new BinaryTree(8);
        int target = 3;
        int k = 2;
        System.out.println(findNodesDistanceK(root, target, k));
    }
}
