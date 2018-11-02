package br.eduprivate.dswalgol.queue;

public class QueueEmptyException extends RuntimeException {
	
	public QueueEmptyException(String err) {
		super(err);
	}
}
