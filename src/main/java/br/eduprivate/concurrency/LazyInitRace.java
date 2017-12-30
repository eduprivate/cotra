package br.eduprivate.concurrency;

/**
 * LazyInitRace
 *
 * Race condition in lazy initialization
 *
 */

@NotThreadSafe
public class LazyInitRace {
    private ExpensiveObject instance = null;

    public ExpensiveObject getInstance() {
        if (instance == null)
            instance = new ExpensiveObject();
        return instance;
    }
}

class ExpensiveObject { }

