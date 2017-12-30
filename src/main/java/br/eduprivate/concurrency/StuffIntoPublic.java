package br.eduprivate.concurrency;

/**
 * StuffIntoPublic
 * <p/>
 * Unsafe publication
 *
 */
public class StuffIntoPublic {
    public Holder holder;

    public void initialize() {
        holder = new Holder(42);
    }
}
