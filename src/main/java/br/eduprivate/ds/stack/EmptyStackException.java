package br.eduprivate.ds.stack;

public class EmptyStackException extends Exception {
    public EmptyStackException() {
    }

    public EmptyStackException(String message) {
        super(message);
    }
}
