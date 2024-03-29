package br.eduprivate.dswalgol.priority_queue;

import br.eduprivate.dswalgol.net.datastructures.Entry;
import br.eduprivate.dswalgol.tree.gen.EmptyListException;
import br.eduprivate.dswalgol.tree.gen.EmptyTreeException;


public interface PriorityQueue<K,V> {
    public int size();

    public boolean isEmpty();

    public Entry<K, V> min() throws EmptyPriorityQueueException, EmptyListException, EmptyTreeException;

    public Entry<K, V> insert(K key, V value) throws EmptyListException, InvalidKeyException, java.security.InvalidKeyException;

    public Entry<K, V> removeMin() throws EmptyPriorityQueueException, EmptyListException, EmptyTreeException;

}
