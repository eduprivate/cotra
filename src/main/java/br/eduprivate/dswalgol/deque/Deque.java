package br.eduprivate.dswalgol.deque;

public interface Deque {
	
	public void insertFirst(Object e);
	
	public void insertLast(Object e);
	
	public Object removeFirst();
	
	public Object removeLast();
	
	public Object first();
	
	public Object last();
	
	public int size();
	
	public boolean isEmpty();
}
