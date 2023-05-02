package br.eduprivate.dswalgol.deque;

public interface Deque {
	
	void insertFirst(Object e);
	
	void insertLast(Object e);
	
	Object removeFirst();
	
	Object removeLast();
	
	Object first();
	
	Object last();
	
	int size();
	
	boolean isEmpty();
}
