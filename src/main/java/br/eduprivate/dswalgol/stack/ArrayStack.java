package br.eduprivate.dswalgol.stack;

public class ArrayStack implements Stack {

	public static final int CAPACITY = 1000;
	
	private int capacity;
	
	private Object S[];
	
	private int top = -1;
	
	public ArrayStack() {
		this(CAPACITY);
	}
	
	public ArrayStack(int cap) {
		this.capacity = cap;
		S = new Object[capacity];
	}
	
	@Override
	public int size() {
		return (top + 1);
	}

	@Override
	public boolean isEmpty() {
		return (top < 0);
	}

	@Override
	public Object top() throws StackEmptyException {
		if (isEmpty()) {
			throw new StackEmptyException("Stack is empty");
		}
		return S[top];
	}

	@Override
	public void push(Object element) {
		if (size() == capacity) {
			throw new StackEmptyException("Stack overflow");
		}
		S[++top] = element;
	}

	@Override
	public Object pop() throws StackEmptyException {
		if (isEmpty()) {
			throw new StackEmptyException("Stack is Empty");
		}
		
		Object elem = S[top];
		S[top] = null;
		--top;
		return elem;
	}

}
