package com.fanjavaid.algorithms.others;

public class CascadeRecursive {
    public static void main(String[] args) {
        new CascadeRecursive().cascade(Integer.valueOf(args[0]));
    }

    public void cascade(int n) {
        // Base case
        if (n < 10) {
            System.out.println(n);
        } else {
            System.out.println(n);
            cascade(n/10);
            System.out.println(n);
        }
    }
}
