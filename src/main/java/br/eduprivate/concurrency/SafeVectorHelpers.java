package br.eduprivate.concurrency;

import java.util.Vector;

/**
 * SafeVectorHelpers
 * <p/>
 * Compound actions on Vector using client-side locking
 *
 */
public class SafeVectorHelpers {
    public static Object getLast(Vector list) {
        synchronized (list) {
            int lastIndex = list.size() - 1;
            return list.get(lastIndex);
        }
    }

    public static void deleteLast(Vector list) {
        synchronized (list) {
            int lastIndex = list.size() - 1;
            list.remove(lastIndex);
        }
    }
}
