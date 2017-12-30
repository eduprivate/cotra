package br.eduprivate.concurrency;

/**
 * Holder
 * <p/>
 * Class at risk of failure if not properly published
 *
 */
public class Holder {
    private int n;

    public Holder(int n) {
        this.n = n;
    }

    public void assertSanity() {
        if (n != n)
            throw new AssertionError("This statement is false.");
    }
}
