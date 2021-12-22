package com.algoexpert.medium;

import java.util.HashMap;

public class d32YoungestCommonAncestor {

    public static AncestralTree getYoungestCommonAncestor(
            AncestralTree topAncestor, AncestralTree descendantOne, AncestralTree descendantTwo) {

        int depth1 = getDepth(topAncestor, descendantOne);
        int depth2 =  getDepth(topAncestor, descendantTwo);

        if(depth1 > depth2) {
            return backTrackTree(descendantOne, descendantTwo, depth1-depth2);
        } else {
            return backTrackTree(descendantTwo, descendantOne, depth2-depth1);
        }
    }

    private static AncestralTree backTrackTree(AncestralTree lowerDescendent, AncestralTree higherDescendent, int changeDepthNeeded) {
        while(changeDepthNeeded>0) {
            lowerDescendent = lowerDescendent.ancestor;
            changeDepthNeeded--;
        }

        while(lowerDescendent != higherDescendent) {
            lowerDescendent = lowerDescendent.ancestor;
            higherDescendent = higherDescendent.ancestor;
        }
        return lowerDescendent;
    }

    public static int getDepth(AncestralTree topAncestor, AncestralTree node) {
        AncestralTree curreAncestor = node;
        int depth = 0;
        while(curreAncestor != topAncestor) {
            depth++;
            curreAncestor = curreAncestor.ancestor;
        }
        return depth;
    }

    static class AncestralTree {
        public char name;
        public AncestralTree ancestor;

        AncestralTree(char name) {
            this.name = name;
            this.ancestor = null;
        }

        @Override
        public String toString() {
            if(ancestor != null) {
                return "AncestralTree{" +
                        "name=" + name +
                        ", ancestor=" + ancestor.name +
                        '}';
            }
            else {
                return "AncestralTree{" +
                        "name=" + name +
                        ", ancestor=null}";
            }
        }

        // This method is for testing only.
        void addAsAncestor(AncestralTree[] descendants) {
            for (AncestralTree descendant : descendants) {
                descendant.ancestor = this;
            }
        }
    }

    public static HashMap<Character, AncestralTree> getTrees() {
        HashMap<Character, AncestralTree> trees = new HashMap<Character, AncestralTree>();
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (char a : alphabet.toCharArray()) {
            trees.put(a, new AncestralTree(a));
        }

        trees.get('A')
                .addAsAncestor(
                        new AncestralTree[] {
                                trees.get('B'), trees.get('C'), trees.get('D'), trees.get('E'), trees.get('F')
                        });
        return trees;
    }

//    @Test
    public void TestCase1() {
        HashMap<Character, AncestralTree> trees = getTrees();
        trees.get('A').addAsAncestor(new AncestralTree[] {trees.get('B'), trees.get('C')});
        trees.get('B').addAsAncestor(new AncestralTree[] {trees.get('D'), trees.get('E')});
        trees.get('D').addAsAncestor(new AncestralTree[] {trees.get('H'), trees.get('I')});
        trees.get('C').addAsAncestor(new AncestralTree[] {trees.get('F'), trees.get('G')});

        AncestralTree yca = getYoungestCommonAncestor(trees.get('A'), trees.get('E'), trees.get('I'));
//        Utils.assertTrue(yca == trees.get('B'));
    }

    public static void main(String[] args) {
        HashMap<Character, AncestralTree> trees = getTrees();
        trees.get('A').addAsAncestor(new AncestralTree[] {trees.get('B'), trees.get('C')});
        trees.get('B').addAsAncestor(new AncestralTree[] {trees.get('D'), trees.get('E')});
        trees.get('D').addAsAncestor(new AncestralTree[] {trees.get('H'), trees.get('I')});
        trees.get('C').addAsAncestor(new AncestralTree[] {trees.get('F'), trees.get('G')});

        AncestralTree yca = getYoungestCommonAncestor(trees.get('A'), trees.get('E'), trees.get('I'));
    }
}
