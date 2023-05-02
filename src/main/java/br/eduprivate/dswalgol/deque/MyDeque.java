package br.eduprivate.dswalgol.deque;

import br.eduprivate.dswalgol.list.DLNode;

public class MyDeque implements Deque {
	
	DLNode header, trailer;
	int size;
	
	public MyDeque() {
		header = new DLNode();
		trailer = new DLNode();
		header.setNext(trailer);
		trailer.setPrev(header);
		size = 0;
	}

	public void insertFirst(Object e) {
		DLNode second = header.getNext();
		DLNode first = new DLNode(e, header, second);
		second.setPrev(first);
		second.setNext(first);
		size++;
	}

	public void insertLast(Object e) {
		
	}

	public Object removeFirst() {
		// TODO Auto-generated method stub
		return null;
	}
	public Object removeLast() {
		if (isEmpty()) {
			throw new DequeEmptyException("Deque is empty.");
		}
		DLNode last = trailer.getPrev();
		Object o = last.getElement();
		DLNode secondToLast = last.getPrev();
		trailer.setPrev(secondToLast);
		secondToLast.setNext(trailer);
		size--;
		return o;
	}

	public Object first() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object last() {
		// TODO Auto-generated method stub
		return null;
	}
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

}
