package br.eduprivate.concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * InterruptibleLocking
 *
 */
public class InterruptibleLocking {
    private final Lock lock = new ReentrantLock();

    public boolean sendOnSharedLine(String message)
            throws InterruptedException {
        lock.lockInterruptibly();
        try {
            return cancellableSendOnSharedLine(message);
        } finally {
            lock.unlock();
        }
    }

    private boolean cancellableSendOnSharedLine(String message) throws InterruptedException {
        /* send something */
        return true;
    }

}
