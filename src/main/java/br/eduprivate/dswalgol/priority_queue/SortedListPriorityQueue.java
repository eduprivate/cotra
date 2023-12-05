package br.eduprivate.dswalgol.priority_queue;

import br.eduprivate.dswalgol.net.datastructures.DefaultComparator;
import br.eduprivate.dswalgol.net.datastructures.Entry;
import br.eduprivate.dswalgol.net.datastructures.Position;
import br.eduprivate.dswalgol.tree.gen.NodePositionList;
import br.eduprivate.dswalgol.tree.gen.PositionList;

import java.util.Comparator;

public class SortedListPriorityQueue<K, V> implements PriorityQueue<K, V> {

    protected PositionList<Entry<K, V>> entries;
    protected Comparator<K> c;
    protected Position<Entry<K, V>> actionPos;
    ;

    protected static class MyEntry<K, V> implements Entry<K, V> {
        protected K k;
        protected V v;

        public MyEntry(K k, V v) {
            this.k = k;
            this.v = v;
        }

        @Override
        public K getKey() {
            return null;
        }

        @Override
        public V getValue() {
            return null;
        }
    }

    public SortedListPriorityQueue() {
        this.entries = new NodePositionList<>();
        c = new DefaultComparator<K>();
    }

    public SortedListPriorityQueue(Comparator<K> comp) {
        this.entries = new NodePositionList<>();
        c = comp;
    }

    public class DefaultComparator<E> implements Comparator<E> {
        public int compare(E o1, E o2) throws ClassCastException{
            return ((Comparable<E>)o1).compareTo(o2);
        }
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Entry<K, V> min() throws EmptyPriorityQueueException {
        if (entries.isEmpty())
            throw new EmptyPriorityQueueException("Fila de prioridade esta vazia");
        else
            return entries.first().getElement();
    }

    @Override
    public Entry<K, V> insert(K key, V value) throws EmptyPriorityQueueException {
        checkKey(key);
        Entry<K, V> entry = new MyEntry<>(key,value);
        insertEntry(entry);
        return entry;

    }

    private void insertEntry(Entry<K,V> entry) {
        if (entries.isEmpty()) {
            entries.addFirst(entry);
            actionPos = entries.first();
        } else if (c.compare(entry.getKey(), entries.last().getElement().getKey())>0) {
            entries.addLast(entry);
            actionPos = entries.last();
        } else {
            Position<Entry<K, V>> curr = entries.first();
            while(c.compare(entry.getKey(), curr.getElement().getKey())>0){
                curr = entries.next(curr);
            }
            entries.addBefore(curr, entry);
            actionPos = entries.prev(curr);
        }
    }

    private void checkKey(K key) throws EmptyPriorityQueueException{
        if (key == null) {
            throw new EmptyPriorityQueueException();
        }
    }

    @Override
    public Entry<K, V> removeMin() throws EmptyPriorityQueueException {
        if (entries.isEmpty())
            throw new EmptyPriorityQueueException("Fila de prioridade esta vazia");
        else
            return entries.remove(entries.first());
    }
}
