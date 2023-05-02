package br.eduprivate.concurrency;

import java.util.concurrent.BlockingQueue;

/**
 * WorkerThread
 * <p/>
 * Serialized access to a task queue
 *
 */

public class WorkerThread extends Thread {
    private final BlockingQueue<Runnable> queue;

    public WorkerThread(BlockingQueue<Runnable> queue) {
        this.queue = queue;
    }

    public void run() {
        while (true) {
            try {
                Runnable task = queue.take();
                task.run();
            } catch (InterruptedException e) {
                break; /* Allow thread to exit */
            }
        }
    }
}
