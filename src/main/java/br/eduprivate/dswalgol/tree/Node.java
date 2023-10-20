package br.eduprivate.dswalgol.tree;

import br.eduprivate.dswalgol.vector.Position;
import com.sun.source.tree.BinaryTree;
import com.sun.source.tree.Tree;

import java.util.List;

public class Node {
    int value;
    Node left;
    Node right;

    Node(int value) {
        this.value = value;
        right = null;
        left = null;
    }
}
