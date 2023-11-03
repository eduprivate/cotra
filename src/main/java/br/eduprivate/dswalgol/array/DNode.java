package br.eduprivate.dswalgol.array;

public class DNode<E> {
    protected E element;
    protected DNode next, prev;

    public DNode(E e, DNode p, DNode n) {
        this.element = e;
        this.prev = p;
        this.next = n;
    }

    public E getElement() {
        return element;
    }

    public DNode getNext() {
        return next;
    }

    public DNode getPrev() {
        return prev;
    }

    public void setElement(E element) {
        this.element = element;
    }

    public void setNext(DNode next) {
        this.next = next;
    }

    public void setPrev(DNode prev) {
        this.prev = prev;
    }
}
