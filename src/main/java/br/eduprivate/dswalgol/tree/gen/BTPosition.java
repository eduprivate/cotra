package br.eduprivate.dswalgol.tree.gen;
//begin#fragment BTPos

import br.eduprivate.dswalgol.net.datastructures.Position;

public interface BTPosition<E> extends Position<E> { 	// inherits element()
    public void setElement(E o);
    public BTPosition<E> getLeft();
    public void setLeft(BTPosition<E> v);
    public BTPosition<E> getRight();
    public void setRight(BTPosition<E> v);
    public BTPosition<E> getParent();
    public void setParent(BTPosition<E> v);
}
//end#fragment BTPos