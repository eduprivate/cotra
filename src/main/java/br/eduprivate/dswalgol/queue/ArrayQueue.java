package br.eduprivate.dswalgol.queue;

public class ArrayQueue implements Queue {
	
public static final int CAPACITY = 1000;
	
	private int capacity;
	
	private Object S[];
	
	private int f, r = -1;
	
	public ArrayQueue() {
		this(CAPACITY);
	}
	
	public ArrayQueue(int cap) {
		this.capacity = cap;
		S = new Object[capacity];
	}

	@Override
	public int size() {
		return (capacity - f + r) % capacity;
	}

	@Override
	public boolean isEmpty() {
		return (f == r);
	}

	@Override
	public Object front() throws QueueEmptyException {
		if(isEmpty()) {
			throw new QueueEmptyException("Queue is Empty.");
		}
		return S[f];
	}

	@Override
	public void enqueue(Object element) {
		if (size() == capacity - 1) {
			throw new QueueFullException("Queue is full");
		}
		S[r] = element;
		r = (r+1) % capacity;
	}

	@Override
	public Object dequeue() throws QueueEmptyException {
		if (isEmpty()) {
			throw new QueueEmptyException("Queue is Empty.");
		}
		Object temp = S[f];
		S[f] = null;
		f = (f +1) % capacity;
		return temp;
	}
	
}