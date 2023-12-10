package br.eduprivate.ds.queue;

public class EmptyQueueException extends Exception {

    public EmptyQueueException() {
    }

    public EmptyQueueException(String message) {
        super(message);
    }
}
