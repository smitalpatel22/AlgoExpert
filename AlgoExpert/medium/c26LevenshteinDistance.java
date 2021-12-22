package com.algoexpert.medium;

public class c26LevenshteinDistance {


    //Time: O(nm) Space: O(nm)
    public static int levensteinDistance(String inp1, String inp2) {

        int [][] edits = new int[inp1.length()+1][inp2.length()+1];
        int r,c;

        for(r=0,c=0;r<inp1.length()+1;r++) {
            edits[r][c] = r;
        }
        for(r=0,c=1;c<inp2.length()+1;c++) {
            edits[r][c] = c;
        }

        for(r=1; r<inp1.length()+1; r++) {
            for(c=1; c<inp2.length()+1; c++) {
                if(inp1.charAt(r-1)==inp2.charAt(c-1)) {            //if the row & column chars are same
                    edits[r][c] = edits[r-1][c-1];                  //set the value same as diagonal
                } else {                                            //else
                    edits[r][c] = 1 + Math.min(edits[r-1][c-1], Math.min(edits[r-1][c],edits[r][c-1])); //set min of 3 neighbouring cells
                }
            }
        }
        return edits[inp1.length()][inp2.length()];
    }

    //Time: O(nm) Space: O(min(n, m))
    public static int levensteinDistanceOptimized(String str1, String str2) {
        String small = str1.length() > str2.length() ? str2 : str1;
        String big = str1.length() > str2.length() ? str1 : str2;
        int[] evenEdits = new int[small.length()+1];
        int[] oddEdits = new int[small.length()+1];

        for(int c=0; c<small.length()+1; c++) {
            evenEdits[c] = c;
        }

        for(int r=1; r<big.length()+1; r++) {
            int[] prevEdits;
            int[] currEdits;
            if(r%2==1) {
                currEdits = oddEdits;
                prevEdits = evenEdits;
            } else {
                currEdits = evenEdits;
                prevEdits = oddEdits;
            }
            currEdits[0] = r;
            for(int c=1; c<small.length()+1; c++) {
                if(big.charAt(r-1)==small.charAt(c-1)) {
                    currEdits[c] = prevEdits[c-1];
                } else {
                    currEdits[c] = 1 + Math.min(currEdits[c-1], Math.min(prevEdits[c-1],prevEdits[c]));
                }
            }
        }
        return big.length()%2==0 ? evenEdits[small.length()] : oddEdits[small.length()];
    }

        public static void main(String[] args) {

        System.out.println(levensteinDistanceOptimized("abs", "yabd"));

    }

}
