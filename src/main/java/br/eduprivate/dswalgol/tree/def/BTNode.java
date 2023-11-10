package br.eduprivate.dswalgol.tree.def;

import br.eduprivate.dswalgol.net.datastructures.Position;

public class BTNode implements Position {
    private Object element;
    private BTNode left, right, parent;

    public BTNode() {

    }

    public BTNode(Object o, BTNode u, BTNode v, BTNode w){
        setElement(o);
        setParent(u);
        setLeft(v);
        setRight(w);
    }

    public Object element() {return element;}
    public void setElement(Object o) {element = o;}
    public BTNode getLeft() {return left;}
    public void setLeft(BTNode v) {left = v;}
    public BTNode getRight() {return right;}
    public void setRight(BTNode v) {right=v;}
    public BTNode getParent() {return parent;}

    public void setParent(BTNode parent) {
        this.parent = parent;
    }

    @Override
    public Object getElement() throws IllegalStateException {
        return element;
    }
}
