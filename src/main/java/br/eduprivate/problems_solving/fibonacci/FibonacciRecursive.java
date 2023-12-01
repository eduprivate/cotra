package br.eduprivate.problems_solving.fibonacci;

import java.io.*;
class FibonacciRecursive {
    static int fib(int n)
    {
        if (n <= 1)
            return n;
        return fib(n - 1) + fib(n - 2);
    }

    public static void main(String args[])
    {
        int n = 9;
        System.out.println(
                n + "th Fibonacci Number: " + fib(n));
    }
}