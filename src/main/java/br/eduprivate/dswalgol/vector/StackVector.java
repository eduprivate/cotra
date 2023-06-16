package br.eduprivate.dswalgol.vector;

import br.eduprivate.dswalgol.stack.Stack;
import br.eduprivate.dswalgol.stack.StackEmptyException;

public class StackVector implements Stack {
    private ArrayVector vector;

    public StackVector() {
        this.vector = new ArrayVector();
    }
    @Override
    public int size() {
        return this.vector.size();
    }

    @Override
    public boolean isEmpty() {
        return this.vector.isEmpty();
    }

    @Override
    public Object top() throws StackEmptyException {
        return this.vector.elemAtRank(0);
    }

    @Override
    public void push(Object element) {
        this.vector.insertAtRank(0, element);
    }
    @Override
    public Object pop() throws StackEmptyException {
        return this.vector.elemAtRank(0);
    }
}
