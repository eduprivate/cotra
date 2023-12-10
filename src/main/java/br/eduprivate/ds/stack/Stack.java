package br.eduprivate.ds.stack;

public interface Stack<E> {

    public int size();

    public boolean isEmpty();

    public E top() throws EmptyStackException;

    public void push(E element) throws FullStackException;

    public E pop() throws EmptyStackException;
}
