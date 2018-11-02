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

	@Override
	public void insertFirst(Object e) {
		DLNode second = header.getNext();
		DLNode first = new DLNode(e, header, second);
		second.setPrev(first);
		second.setNext(first);
		size++;
	}

	@Override
	public void insertLast(Object e) {
		
	}

	@Override
	public Object removeFirst() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object removeLast() {
		if (isEmpty()) {
			throw new DequeEmptyException("Deque is empty.");
		}
		DLNode last = trailer.getPrev();
		Object o = last.getElement();
		DLNode secondtolast = last.getPrev();
		trailer.setPrev(secondtolast);
		secondtolast.setNext(trailer);
		size--;
		return o;
	}

	@Override
	public Object first() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object last() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

}
