package br.eduprivate.dswalgol.priority_queue;

public class InvalidKeyException extends Exception {

    public InvalidKeyException() {
    }

    public InvalidKeyException(String message) {
        super(message);
    }

    public InvalidKeyException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidKeyException(Throwable cause) {
        super(cause);
    }

    public InvalidKeyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
