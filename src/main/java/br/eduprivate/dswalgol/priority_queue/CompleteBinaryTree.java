package br.eduprivate.dswalgol.priority_queue;

import br.eduprivate.dswalgol.net.datastructures.Position;
import br.eduprivate.dswalgol.tree.gen.BinaryTree;
import br.eduprivate.dswalgol.vector.InvalidPositionException;

public interface CompleteBinaryTree<E> extends BinaryTree<E> {
    public Position<E> add(E elem);
    public E remove();

    public E replace(Position<E> v, E o) throws InvalidPositionException;

    boolean hasRight(Position<E> p);
}