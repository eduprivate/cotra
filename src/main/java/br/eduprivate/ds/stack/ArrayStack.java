package br.eduprivate.ds.stack;

public class ArrayStack<E> implements Stack<E>{

    protected int capacity;
    public static final int CAPACITY = 1000;

    protected E S[];

    protected int top = -1;

    public ArrayStack() {
        this(CAPACITY);
    }

    public ArrayStack(int capacity) {
        this.capacity = capacity;
        S = (E[])new Object[this.capacity];
    }

    @Override
    public int size() {
        return top + 1;
    }

    @Override
    public boolean isEmpty() {
        return top < 0;
    }

    @Override
    public E top() throws EmptyStackException {
        if (isEmpty()){
            throw new EmptyStackException("Stack is empty");
        }
        return S[top];

    }

    @Override
    public void push(E element) throws FullStackException {
        if(size() == capacity) {
            throw new FullStackException("Stack is full");
        }
        S[++top] = element;
    }

    @Override
    public E pop() throws EmptyStackException {
       E element;

       if (isEmpty()) {
           throw new EmptyStackException("Stack is empty");
       }
       element = S[top];
       S[top--] = null;
       return element;
    }

    public String toString() {
        String s;
        s = "[ ";
        if (size() > 0) {
            s += S[0];
        }
        if (size() > 1) {
            for(int i = 1; i <= size()-1; i++){
                s += ", " + S[i];
            }
        }
        return s + "]";
    }

    public void status(String op, Object element) {
        System.out.print("------->" + op);
        System.out.println(", returns " + element);
        System.out.print("result: size = " + size() + ", isEmpty = " + isEmpty());
        System.out.println(", stack: " + this);
    }

    public static void main(String[] args) throws FullStackException, EmptyStackException {
        Object o;
        ArrayStack<Integer> A = new ArrayStack<>(20);
        A.status("new ArrayStack<Integer> A", null);
        A.push(7);
        A.status("A.push(7)", null);
        o = A.pop();
        A.status("A.pop", o);
        A.push(9);
        A.status("A.push(9)", null);
        o = A.pop();
        A.status("A.pop", o);

        A.push(5);
        A.push(7);
        A.push(9);
    }
}
