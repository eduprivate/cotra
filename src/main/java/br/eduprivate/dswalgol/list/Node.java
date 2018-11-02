package br.eduprivate.dswalgol.list;

public class Node {
	
	private Object element;
	private Node next;
	
	public Node() {
		this(null, null);
	}
	
	public Node(Object e, Node n) {
		element = e;
		next = n;
	}
	
	public Object getElement() {
		return element;
	}
	
	public Node getNext() {
		return next;
	}
	
	public void setElement(Object element) {
		this.element = element;
	}
	
	public void setNext(Node next) {
		this.next = next;
	}
}