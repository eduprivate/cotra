package br.eduprivate.ds.queue;

import br.eduprivate.dswalgol.queue.QueueEmptyException;
import br.eduprivate.dswalgol.queue.QueueFullException;

public class ArrayQueue<E> implements Queue<E> {

    protected int capacity;

    public static final int CAPACITY = 1000;

    protected E S[];

    protected int top = -1;

    private int f, r = -1;

    public ArrayQueue() {
        this(CAPACITY);
    }

    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        S = (E[])new Object[this.capacity];
    }

    @Override
    public int size() {
        return (capacity - f + r) % capacity;
    }

    @Override
    public boolean isEmpty() {
        return f == r;
    }

    @Override
    public E front() throws EmptyQueueException {
        if(isEmpty()) {
            throw new QueueEmptyException("Queue is Empty.");
        }
        return S[f];
    }

    @Override
    public void enqueue(E element) {
        if (size() == capacity - 1) {
            throw new QueueFullException("Queue is full");
        }
        S[r] = element;
        r = (r+1) % capacity;
    }

    @Override
    public E dequeue() throws EmptyQueueException {
        if (isEmpty()) {
            throw new QueueEmptyException("Queue is Empty.");
        }
        E temp = S[f];
        S[f] = null;
        f = (f +1) % capacity;
        return temp;
    }
}
