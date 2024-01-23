package br.eduprivate.dswalgol.priority_queue;

import br.eduprivate.dswalgol.net.datastructures.Position;
import br.eduprivate.dswalgol.tree.gen.BinaryTree;

public interface CompleteBinaryTree<E> extends BinaryTree<E> {
    public Position<E> add(E elem);
    public E remove();
}
