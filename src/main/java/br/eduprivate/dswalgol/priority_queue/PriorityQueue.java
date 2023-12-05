package br.eduprivate.dswalgol.priority_queue;

import br.eduprivate.dswalgol.net.datastructures.Entry;

public interface PriorityQueue<K,V> {
    public int size();

    public boolean isEmpty();

    public Entry<K, V> min() throws EmptyPriorityQueueException;

    public Entry<K, V> insert(K key, V value) throws EmptyPriorityQueueException;

    public Entry<K, V> removeMin() throws EmptyPriorityQueueException;

}
