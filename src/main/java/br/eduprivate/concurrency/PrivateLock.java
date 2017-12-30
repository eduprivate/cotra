package br.eduprivate.concurrency;


/**
 * PrivateLock
 * <p/>
 * Guarding state with a private lock
 *
 */
public class PrivateLock {
    private final Object myLock = new Object();
    @GuardedBy("myLock") Widget widget;

    void someMethod() {
        synchronized (myLock) {
            // Access or modify the state of widget
        }
    }
}
