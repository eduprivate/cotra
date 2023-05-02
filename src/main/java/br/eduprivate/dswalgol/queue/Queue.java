package br.eduprivate.dswalgol.queue;

public interface Queue {
	
	int size();
	
	boolean isEmpty();
	
	Object front() throws QueueEmptyException;
	
	void enqueue(Object element);
	
	Object dequeue() throws QueueEmptyException;
}
