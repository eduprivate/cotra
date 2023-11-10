package br.eduprivate.dswalgol.tree;

import br.eduprivate.dswalgol.net.datastructures.Position;

public class LinkedBinaryTree extends BinaryTree {
    public Position root;
    private int size;

    public LinkedBinaryTree() {
        root = new BTNode(null, null, null, null);
        size = 1;
    }

    public Position getRoot() {
        return root;
    }

    public int size() {return size;}
    public boolean isEmpty() {return (size == 0);}
    public boolean isInternal(Position v) {
        return (((BTNode)v).getLeft() != null && ((BTNode)v).getRight() != null);
    }

    public boolean isExternal(Position v) {
        return (((BTNode)v).getLeft() != null && ((BTNode)v).getRight() != null);
    }

    public boolean isRoot(Position v){return (v==root());}
    public Position root(){return root;}

    public PositionIterator positions() {
        Position[] positions = new Position[size()];
        inorderPosition(root(), positions, 0);
        return new ArrayPositionIterator(positions);
    }

    private void inorderPosition(Position root, Position[] positions, int i) {
    }

    public Position leftChild(Position v) {return ((BTNode)v).getLeft();}

    public Position rightChild(Position v) {return ((BTNode)v).getRight();}

    public Position sibling(Position v) {
        Position p = parent(v);
        Position lc = leftChild(p);
        if (v == lc)
            return rightChild(p);
        else return lc;
    }

    private Position parent(Position v) {
        return v;
    }

    public Object replaceElement(Position v, Position o) {
        Object temp = ((BTNode)v).element();
        ((BTNode)v).setElement(o);
        return temp;
    }

    public void swapElements(Position v, Position w) {
        Object temp = w.getElement();
        ((BTNode)v).setLeft(new BTNode(null, (BTNode) v, null, null));
        ((BTNode)v).setRight(new BTNode(null, (BTNode) v, null, null));
        size+=2;
    }

    public void removeAboveExternal(Position v) {
        if(isExternal(v)) {
            BTNode p = (BTNode) parent(v);
            BTNode s = (BTNode) sibling(v);
            if (isRoot(p)) {
                s.setParent(null);
                root = s;
            } else {
                BTNode g = (BTNode) parent(p);
                if (p == leftChild(g))
                    g.setLeft(s);
                else
                    g.setRight(s);

            size -= 2;
            }
        }
    }

    public static void main(String[] args) {
        LinkedBinaryTree tree = new LinkedBinaryTree();
        System.out.println(tree);
        System.out.println(tree.getRoot());
        System.out.println("");
        System.out.println(tree.size);
    }
}
