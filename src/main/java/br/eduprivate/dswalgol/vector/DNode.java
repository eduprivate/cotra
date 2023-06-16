package br.eduprivate.dswalgol.vector;

public class DNode implements Position {
	private DNode prev;
	private DNode next;
	private Object element;
	
	public DNode(DNode newPrev, DNode newNext, Object elem) {
		prev = newPrev;
		next = newNext;
		element = elem;
	}
	
	public Object element() throws InvalidPositionException {
		if ((prev == null) && (next == null)) {
			throw new InvalidPositionException("Position is not a list!");
		}
		return element;
	}

	public void setNext(DNode next){
		this.next = next;
	}

	public void setPrev(DNode prev) {
		this.prev = prev;
	}
	
	public DNode getNext() {return next;}
	public DNode getPrev() {return prev;}
	public void setElement(Object newElement) {element = newElement;}
	
}
