package br.eduprivate.dswalgol.list;

import br.eduprivate.dswalgol.queue.Queue;
import br.eduprivate.dswalgol.queue.QueueEmptyException;

public class LinkedQueue implements Queue {
	
	private Node head;
	private Node tail;
	private int size;
	
	public LinkedQueue() {
		this.head = null;
		this.size = 0;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public Object front() throws QueueEmptyException {
		Object obj;
		if (size == 0) {
			throw new QueueEmptyException("Queue is empty.");
		}
		obj = head.getElement();
		return obj;
	}

	@Override
	public void enqueue(Object element) {
		Node node = new Node();
		node.setElement(element);
		node.setNext(null);
		
		if (size == 0) {
			head = node;
		} else {
			tail.setNext(node);
		}
		tail = node;
		size++;
	}

	@Override
	public Object dequeue() throws QueueEmptyException {
		Object obj;
		if (size == 0) {
			throw new QueueEmptyException("Queue is empty.");
		}
		obj = head.getElement();
		head = head.getNext();
		size--;
		
		if (size == 0) {
			tail = null;
		}
		return obj;
	}

}
