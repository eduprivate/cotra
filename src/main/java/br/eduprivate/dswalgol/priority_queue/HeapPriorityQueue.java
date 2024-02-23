package br.eduprivate.dswalgol.priority_queue;

import br.eduprivate.dswalgol.net.datastructures.DefaultComparator;
import br.eduprivate.dswalgol.net.datastructures.Entry;
import br.eduprivate.dswalgol.net.datastructures.Position;
import br.eduprivate.dswalgol.tree.gen.EmptyListException;
import br.eduprivate.dswalgol.tree.gen.EmptyTreeException;
import br.eduprivate.dswalgol.vector.InvalidPositionException;

import java.security.InvalidKeyException;
import java.util.Comparator;

public class HeapPriorityQueue<K, V> implements PriorityQueue<K, V> {

    protected CompleteBinaryTree<Entry<K, V>> heap;
    protected Comparator<K> comp;

    protected static class MyEntry<K, V> implements Entry<K, V> {
        protected K key;
        protected V value;
        public MyEntry(K k, V v) {
            key = k;
            value = v;
        }

        @Override
        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        @Override
        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }

    public HeapPriorityQueue() {
        heap = new ArrayListCompleteBinaryTree<Entry<K, V>>();
        comp = new DefaultComparator<K>();
    }

    public HeapPriorityQueue(Comparator<K> comp) {
        heap = new ArrayListCompleteBinaryTree<Entry<K, V>>();
        this.comp = comp;
    }

    @Override
    public int size() {
        return heap.size();
    }

    @Override
    public boolean isEmpty() {
        return heap.size() == 0;
    }

    @Override
    public Entry<K, V> min() throws EmptyPriorityQueueException, EmptyListException, EmptyTreeException {
        if (isEmpty()) {
            throw new EmptyPriorityQueueException("PriorityQueue is empty");
        }
        return heap.root().getElement();
    }

    @Override
    public Entry<K, V> insert(K key, V value) throws EmptyListException, InvalidKeyException {
        checkKey(key);
        Entry<K, V> entry = new MyEntry<K, V>(key, value);
        upHeap(heap.add(entry));
        return entry;
    }

    private void checkKey(K key) throws InvalidKeyException {
        try {
            comp.compare(key, key);
        }catch (Exception e) {
            throw new InvalidKeyException("Chave inválida");
        }
    }

    @Override
    public Entry<K, V> removeMin() throws EmptyPriorityQueueException, EmptyListException, EmptyTreeException {
        if (isEmpty()) {
            throw new EmptyPriorityQueueException("PriorityQueue is empty");
        }
        Entry<K, V> min = heap.root().getElement();
        if (size() == 1) {
            heap.remove();
        } else {
            heap.replace(heap.root(), heap.remove());
            downHeap(heap.root());
        }
        return min;
    }

    private void downHeap(Position<Entry<K,V>> r) {
        while(heap.isInternal(r)) {
            Position<Entry<K,V>> s;
            if (!heap.hasRight(r))
                s = heap.left(r);
            else if (comp.compare(heap.left(r).getElement().getKey(), heap.right(r).getElement().getKey()) <= 0) {
                s = heap.left(r);
            } else {
                s = heap.right(r);
            }
            if (comp.compare(s.getElement().getKey(), r.getElement().getKey()) < 0) {
                swap(r,s);
                r = s;
            } else break;
        }
    }

    private void upHeap(Position<Entry<K,V>> v) {
        Position<Entry<K, V>> u;
        while(!heap.isRoot(v)) {
            u = heap.parent(v);
            if (comp.compare(u.getElement().getKey(), v.getElement().getKey()) <= 0) break;
            swap(u, v);
        }
    }

    private void swap(Position<Entry<K,V>> x, Position<Entry<K,V>> y) {
        Entry<K, V> temp = x.getElement();
        heap.replace(x, y.getElement());
        heap.replace(y, temp);

    }

    @Override
    public String toString() {
        return heap.toString();
    }
}
