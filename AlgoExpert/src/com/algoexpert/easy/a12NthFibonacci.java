package com.algoexpert.easy;

public class a12NthFibonacci {
    public static void main(String[] args) {
        System.out.println(getNthFib(3));
    }

    public static int getNthFib(int n) {
        int i = 3;
        int a=0,b=1,c=0;
        if(n<3) {
            return n-1;
        }
        while(i<=n) {
            c = a + b;
            a = b;
            b = c;
            i++;
        }
        return c;
    }
}
