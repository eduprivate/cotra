package br.eduprivate.dswalgol.array;

public class DNode {
    protected String element;
    protected DNode next, prev;

    public DNode(String e, DNode p, DNode n) {
        this.element = e;
        this.prev = p;
        this.next = n;
    }

    public String getElement() {
        return element;
    }

    public DNode getNext() {
        return next;
    }

    public DNode getPrev() {
        return prev;
    }

    public void setElement(String element) {
        this.element = element;
    }

    public void setNext(DNode next) {
        this.next = next;
    }

    public void setPrev(DNode prev) {
        this.prev = prev;
    }
}
