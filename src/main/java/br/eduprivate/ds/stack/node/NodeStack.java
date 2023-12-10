package br.eduprivate.ds.stack.node;

import br.eduprivate.ds.Node;
import br.eduprivate.ds.stack.EmptyStackException;
import br.eduprivate.ds.stack.FullStackException;
import br.eduprivate.ds.stack.Stack;

public class NodeStack<E> implements Stack<E> {

    protected Node<E> top;
    protected int size;

    public NodeStack() {
        this.top = null;
        this.size = 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        if(top == null) return true;
        return false;
    }

    @Override
    public E top() throws EmptyStackException {
        if (isEmpty()) throw new EmptyStackException("Stack is empty");
        return top.getElement();
    }

    @Override
    public void push(E element) throws FullStackException {
        Node<E> v = new Node<E>(element, top);
        top = v;
        size++;
    }

    @Override
    public E pop() throws EmptyStackException {
        if (isEmpty()) throw new EmptyStackException("Stack is empty");
        E temp = top.getElement();
        top = top.getNext();
        size--;
        return temp;
    }

    public static void main(String[] args) throws FullStackException, EmptyStackException {
        NodeStack<Integer> nodes = new NodeStack<>();

        nodes.push(1);
        nodes.push(2);
        nodes.push(3);
        nodes.push(4);
        Integer e = nodes.pop();

    }
}
