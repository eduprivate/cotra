package br.eduprivate.dswalgol.vector;

public class DNode{
	private DNode prev, next;
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
	
	public DNode getNext() {return next;}
	public DNode getPrev() {return prev;}
	public void setElement(Object newElement) {element = newElement;}
	
}
