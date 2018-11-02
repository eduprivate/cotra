package br.eduprivate.dswalgol.list;

import br.eduprivate.dswalgol.stack.Stack;
import br.eduprivate.dswalgol.stack.StackEmptyException;

public class LinkedStack implements Stack {
	
	private Node top;
	private int size;
	
	public LinkedStack() {
		this.top = null;
		this.size = 0;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		if (top == null) {
			return true;
		}
		return false;
	}

	@Override
	public Object top() throws StackEmptyException {
		if (isEmpty()) {
			throw new StackEmptyException("Stack is empty.");
		}
		return top.getElement();
	}

	@Override
	public void push(Object element) {
		Node v =  new Node();
		v.setElement(element);
		v.setNext(top);
		top = v;
		size++;
	}

	@Override
	public Object pop() throws StackEmptyException {
		if (isEmpty()) {
			throw new StackEmptyException("Stack is empty");
		}
		Object temp = top.getElement();
		top = top.getNext();
		size--;
		return temp;
	}
}