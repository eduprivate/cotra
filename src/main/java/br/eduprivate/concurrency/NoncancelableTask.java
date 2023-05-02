package br.eduprivate.concurrency;

import java.util.concurrent.BlockingQueue;

/**
 * NoncancelableTask
 * <p/>
 * Noncancelable task that restores interruption before exit
 *
 */
public class NoncancelableTask {
    public Task getNextTask(BlockingQueue<Task> queue) {
        boolean interrupted = false;
        try {
            while (true) {
                try {
                    return queue.take();
                } catch (InterruptedException e) {
                    interrupted = true;
                    // fall through and retry
                }
            }
        } finally {
            if (interrupted)
                Thread.currentThread().interrupt();
        }
    }

    interface Task {
    }
}
