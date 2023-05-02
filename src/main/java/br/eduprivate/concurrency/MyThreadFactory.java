package br.eduprivate.concurrency;

import java.util.concurrent.ThreadFactory;

/**
 * MyThreadFactory
 * <p/>
 * Custom thread factory
 *
 */
public class MyThreadFactory implements ThreadFactory {
    private final String poolName;

    public MyThreadFactory(String poolName) {
        this.poolName = poolName;
    }

    public Thread newThread(Runnable runnable) {
        return new MyAppThread(runnable, poolName);
    }
}
