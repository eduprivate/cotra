package br.eduprivate.dswalgol.list;

public class DLNode {
	private Object element;
	private DLNode next, prev;
	
	public DLNode() {
		this(null, null, null);
	}
	
	public DLNode(Object e, DLNode p, DLNode n) {
		element = e;
		next = n;
		prev = p;
	}
	
	public void setElement(Object element) {
		this.element = element;
	}
	
	public void setNext(DLNode next) {
		this.next = next;
	}
	
	public void setPrev(DLNode prev) {
		this.prev = prev;
	}
	
	public DLNode getNext() {
		return next;
	}
	
	public DLNode getPrev() {
		return prev;
	}
	
	public Object getElement() {
		return element;
	}
}
