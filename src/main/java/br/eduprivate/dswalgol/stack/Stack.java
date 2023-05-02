package br.eduprivate.dswalgol.stack;

public interface Stack {
	
	int size();
	
	boolean isEmpty();
	
	Object top() throws StackEmptyException;
	
	void push(Object element);
	
	Object pop() throws StackEmptyException;
	
}
