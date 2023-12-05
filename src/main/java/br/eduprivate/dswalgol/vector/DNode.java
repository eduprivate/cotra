package br.eduprivate.dswalgol.vector;

public class DNode<E> implements Position<E> {
	private DNode<E> prev;
	private DNode<E> next;
	private E element;
	
	public DNode(DNode<E> newPrev, DNode<E> newNext, E elem) {
		prev = newPrev;
		next = newNext;
		element = elem;
	}
	
	public E element() throws InvalidPositionException {
		if ((prev == null) && (next == null)) {
			throw new InvalidPositionException("Position is not a list!");
		}
		return element;
	}

	public void setNext(DNode<E> next){
		this.next = next;
	}

	public void setPrev(DNode<E> prev) {
		this.prev = prev;
	}
	
	public DNode<E> getNext() {return next;}
	public DNode<E> getPrev() {return prev;}
	public void setElement(E newElement) {element = newElement;}
	
}
