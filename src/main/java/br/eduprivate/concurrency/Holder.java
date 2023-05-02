package br.eduprivate.concurrency;

/**
 * Holder
 * <p/>
 * Class at risk of failure if not properly published
 *
 */
public class Holder {
    private final int n;

    public Holder(int n) {
        this.n = n;
    }

    public void assertSanity() {
        if (n != 0)
            throw new AssertionError("This statement is false.");
    }
}
