package br.eduprivate.dswalgol.priority_queue;

import br.eduprivate.dswalgol.net.datastructures.ArrayList;
import br.eduprivate.dswalgol.net.datastructures.Position;
import br.eduprivate.dswalgol.tree.gen.EmptyTreeException;
import br.eduprivate.dswalgol.vector.BoundaryViolationException;
import br.eduprivate.dswalgol.vector.InvalidPositionException;

import java.util.Iterator;

public class ArrayListCompleteBinaryTree<E> implements CompleteBinaryTree<E> {

    protected ArrayList<BTPos<E>> T;

    protected static class BTPos<E> implements Position<E> {
        E element;
        int index;

        public BTPos(E elt, int i) {
            element = elt;
            index = i;
        }

        @Override
        public E getElement() throws IllegalStateException {
            return element;
        }

        public E setElement(E elt) {
            E temp = elt;
            this.element = elt;
            return temp;
        }
    }

    public ArrayListCompleteBinaryTree() {
        T = new ArrayList<BTPos<E>>();
        T.add(0, null);
    }

    @Override
    public E remove() {
        return null;
    }

    @Override
    public Position<E> left(Position<E> p) throws IllegalArgumentException {
        if (!hasLeft(p)) throw new BoundaryViolationException("Sem filho a esquerda");
        BTPos<E> vv = checkPosition(p);
        return T.get(2*vv.index);
    }

    @Override
    public Position<E> right(Position<E> p) throws IllegalArgumentException {
        if (!hasRight(p)) throw new BoundaryViolationException("Sem filho a direita");
        BTPos<E> vv = checkPosition(p);
        return T.get(2*vv.index+1);
    }

    @Override
    public Position<E> sibling(Position<E> p) throws IllegalArgumentException {
        return null;
    }

    @Override
    public Position<E> root() throws EmptyTreeException {
        return null;
    }

    @Override
    public Position<E> parent(Position<E> p) throws IllegalArgumentException {
        if (isRoot(p)) throw new BoundaryViolationException("Sem pai");
        BTPos<E> vv = checkPosition(p);
        return T.get(2*vv.index/2);
    }

    @Override
    public Iterable<Position<E>> children(Position<E> p) throws IllegalArgumentException {
        return null;
    }

    @Override
    public int numChildren(Position<E> p) throws IllegalArgumentException {
        return 0;
    }

    @Override
    public boolean isInternal(Position<E> p) throws IllegalArgumentException {
        return hasLeft(p);
    }

    private boolean hasLeft(Position<E> p) {
        BTPos<E> vv = checkPosition(p);
        return 2*vv.index <= size();
    }

    private BTPos<E> checkPosition(Position<E> p) {
        if (p == null || !(p instanceof BTPos)) {
            throw new InvalidPositionException("A posição é inválida");
        }
        return (BTPos<E>) p;
    }

    public boolean hasRight(Position<E> p) {
        BTPos<E> vv = checkPosition(p);
        return 2*vv.index + 1 <= size();
    }

    @Override
    public boolean isExternal(Position<E> p) throws IllegalArgumentException {
        return !isInternal(p);
    }

    @Override
    public boolean isRoot(Position<E> p) throws IllegalArgumentException {
        BTPos<E> vv = checkPosition(p);
        return 2*vv.index <= size();
    }

    @Override
    public int size() {
        return T.size() - 1;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    public E replace(Position<E> v, E o) throws InvalidPositionException {
        BTPos<E> vv = checkPosition(v);
        return vv.setElement(o);
    }

    @Override
    public Position<E> add(E elem) {
        int i = size() + 1;
        BTPos<E> p = new BTPos<E>(elem,i);
        T.add(i, p);
        return p;
    }

    @Override
    public Iterator<E> iterator() {
        ArrayList<E> list = new ArrayList<E>();
        Iterator<BTPos<E>> iter = T.iterator();
        iter.next();
        while (iter.hasNext()){
            list.add(iter.next().element);
        }
        return list.iterator();
    }

    @Override
    public Iterable<Position<E>> positions() {
        return null;
    }
}
