package br.eduprivate.ds.stack.algol;

import br.eduprivate.ds.stack.ArrayStack;
import br.eduprivate.ds.stack.EmptyStackException;
import br.eduprivate.ds.stack.FullStackException;
import br.eduprivate.ds.stack.Stack;

import java.util.Arrays;

public class ReverseAlgo {

    public static <E> void reverse(E[] a) throws FullStackException, EmptyStackException {
        Stack<E> S = new ArrayStack<>(a.length);

        for (int i = 0; i < a.length; i++) {
            S.push(a[i]);
        }
        for (int i = 0; i < a.length; i++) {
            a[i] = S.pop();
        }
    }

    public static void main(String[] args) throws EmptyStackException, FullStackException {
        Integer[] a = {4, 8, 15, 16, 23, 42};
        System.out.println("a = "+ Arrays.toString(a));
        reverse(a);
        System.out.println("a = "+ Arrays.toString(a));
    }
}
