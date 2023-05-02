package br.eduprivate.concurrency;

/**
 * NonreentrantDeadlock
 * <p/>
 * Code that would deadlock if intrinsic locks were not reentrant
 *
 */

class Widget {
    public synchronized void doSomething() {
    }
}

class LoggingWidget extends Widget {
    public synchronized void doSomething() {
        System.out.println(this + ": calling doSomething");
        super.doSomething();
    }
}
