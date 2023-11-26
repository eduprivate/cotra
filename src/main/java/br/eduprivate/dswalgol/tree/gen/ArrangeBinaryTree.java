package br.eduprivate.dswalgol.tree.gen;

import java.io.*;
import java.lang.*;
import java.util.*;

// Class 1
// Helper class (Node class)
public class ArrangeBinaryTree {
    public static void main(String[] args)
    {

        // Creating object of class 2 inside main() method
        ArrayBinaryTree obj = new ArrayBinaryTree();

        // Setting root node
        obj.root("A");
        obj.setLeft("B", 0);
        obj.setRight("C", 0);
        obj.setLeft("D", 1);
        obj.setRight("E", 1);
        obj.setRight("F", 2);
        obj.printTree();
    }
}

class ArrayBinaryTree {
    static int root = 0;
    private String[] str = new String[10];

    public void root(String key) { str[0] = key; }

    public void setLeft(String key, int root)
    {
        int t = (root * 2) + 1;

        if (str[root] == null) {
            System.out.printf(
                    "Can't set child at %d, no parent found\n",
                    t);
        }
        else {
            str[t] = key;
        }
    }

    public void setRight(String key, int root)
    {
        int t = (root * 2) + 2;

        if (str[root] == null) {
            System.out.printf(
                    "Can't set child at %d, no parent found\n",
                    t);
        }
        else {
            str[t] = key;
        }
    }

    public void printTree()
    {
        // Iterating using for loop
        for (int i = 0; i < 10; i++) {
            if (str[i] != null)
                System.out.print(str[i]);
            else
                System.out.print("-");
        }
    }
}