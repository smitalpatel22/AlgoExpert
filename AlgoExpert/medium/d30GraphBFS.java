package com.algoexpert.medium;

import java.util.*;

public class d30GraphBFS {



    static class Node {
        String name;
        List<Node> children = new ArrayList<Node>();

        public Node(String name) {
            this.name = name;
        }

        public Node addChild(String name) {
            Node child = new Node(name);
            children.add(child);
            return this;
        }

        public List<String> breadthFirstSearch(List<String> array) {
            Queue<Node> queue = new LinkedList<>();
            queue.add(this);

            while(queue.size() != 0) {
                Node current = queue.remove();
                array.add(current.name);
                queue.addAll(current.children);
            }
            return array;
        }
    }

    public static void main(String[] args) {
        Node graph = new Node("A");
        graph.addChild("B").addChild("C").addChild("D");
        graph.children.get(0).addChild("E").addChild("F");
        graph.children.get(2).addChild("G").addChild("H");
        graph.children.get(0).children.get(1).addChild("I").addChild("J");
        graph.children.get(2).children.get(0).addChild("K");
        List<String> inputAndOutput = new ArrayList();
        graph.breadthFirstSearch(inputAndOutput);
        System.out.println(inputAndOutput);
    }

}
