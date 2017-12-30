package br.eduprivate.concurrency;

/**
 * CountingSheep
 * <p/>
 * Counting sheep
 *
 */
public class CountingSheep {
    volatile boolean asleep;

    void tryToSleep() {
        while (!asleep)
            countSomeSheep();
    }

    void countSomeSheep() {
        // One, two, three...
    }
}








