package br.eduprivate.dswalgol.tree.gen;

import java.util.Iterator;
import java.util.function.Consumer;

public class NodePositionIterator<E> implements Iterator<E> {
    public NodePositionIterator(NodePositionList<E> es) {
    }

    @Override
    public void remove() {
        Iterator.super.remove();
    }

    @Override
    public void forEachRemaining(Consumer<? super E> action) {
        Iterator.super.forEachRemaining(action);
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public E next() {
        return null;
    }
}
