package br.eduprivate.dswalgol.queue;

public interface Queue {
	
	public int size();
	
	public boolean isEmpty();
	
	public Object front() throws QueueEmptyException;
	
	public void enqueue(Object element);
	
	public Object dequeue() throws QueueEmptyException;
}
