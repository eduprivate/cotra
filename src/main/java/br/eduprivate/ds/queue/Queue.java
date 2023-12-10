package br.eduprivate.ds.queue;

public interface Queue<E> {
    public int size();

    public boolean isEmpty();

    public E front() throws EmptyQueueException;

    public void enqueue(E element);

    public  E dequeue() throws EmptyQueueException;
}
