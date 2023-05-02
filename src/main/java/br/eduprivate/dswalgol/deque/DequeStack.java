package br.eduprivate.dswalgol.deque;

import br.eduprivate.dswalgol.stack.Stack;
import br.eduprivate.dswalgol.stack.StackEmptyException;

public class DequeStack implements Stack {
	
	private final Deque D;
	
	public DequeStack() {
		D = new MyDeque();
	}

	@Override
	public int size() {
		return D.size();
	}

	@Override
	public boolean isEmpty() {
		return D.isEmpty();
	}

	@Override
	public Object top() throws StackEmptyException {
		try {
			return D.last();
		} catch (DequeEmptyException e) {
			throw new StackEmptyException("Stack is Empty");
		}
	}

	@Override
	public void push(Object element) {
		D.insertLast(element);
	}

	@Override
	public Object pop() throws StackEmptyException {
		try {
			return D.removeLast();
		} catch (DequeEmptyException e) {
			throw new StackEmptyException("Stack is Empty");
		}
	}
}