package br.eduprivate.dswalgol.priority_queue;

import br.eduprivate.dswalgol.net.datastructures.AdaptablePriorityQueue;
import br.eduprivate.dswalgol.net.datastructures.Entry;
import br.eduprivate.dswalgol.net.datastructures.Position;
import br.eduprivate.dswalgol.tree.gen.EmptyListException;
import br.eduprivate.dswalgol.tree.gen.EmptyTreeException;

import java.util.Comparator;

public class SortedListAdaptablePriorityQueue<K, V> extends SortedListPriorityQueue<K, V> implements AdaptablePriorityQueue<K, V> {


    public SortedListAdaptablePriorityQueue() {
    }

    public SortedListAdaptablePriorityQueue(Comparator<K> comp) {
        super(comp);
    }

    @Override
    public Entry<K, V> insert(K key, V value) throws InvalidKeyException, EmptyListException {
        checkKey(key);
        LocationAwareEntry<K, V> entry = new LocationAwareEntry<K, V>(key,value);
        insertEntry(entry);
        entry.setLocation(actionPos);
        return entry;
    }

    public Entry<K, V> remove(Entry<K, V> entry) throws IllegalArgumentException, InvalidEntryException {
        checkEntry(entry);
        LocationAwareEntry<K, V> e = (LocationAwareEntry<K,V>) entry;
        Position<Entry<K,V>> p = e.location();
        entries.remove(p);
        e.setLocation(null);
        return e;

    }

    private void checkEntry(Entry<K,V> entry) throws InvalidEntryException {
        if (entry == null || !(entry instanceof LocationAwareEntry))
            throw new InvalidEntryException("Invalid exception");
    }

    public K replaceKey(Entry<K, V> entry, K key) throws IllegalArgumentException, InvalidKeyException, InvalidEntryException, EmptyListException {
        checkKey(key);
        checkEntry(entry);
        LocationAwareEntry<K, V> e = (LocationAwareEntry<K,V>) remove(entry);
        K oldKey = e.setKey(key);
        insertEntry(e);
        e.setLocation(actionPos);
        return oldKey;
    }

    public V replaceValue(Entry<K, V> entry, V value) throws IllegalArgumentException, InvalidEntryException {
        checkEntry(entry);
        V oldValue = ((LocationAwareEntry<K,V>)entry).setValue(value);
        return oldValue;
    }

    protected static class LocationAwareEntry<K, V> extends MyEntry<K, V> implements Entry<K, V>{
        private Position<Entry<K, V>> loc;

        public LocationAwareEntry(K k, V v, Position<Entry<K, V>> loc) {
            super(k, v);
            this.loc = loc;
        }

        protected Position<Entry<K, V>> location() {
            return loc;
        }

        protected Position<Entry<K, V>> setLocation(Position<Entry<K,V>> pos) {
            Position<Entry<K,V>> oldPosition = location();
            loc = pos;
            return oldPosition;
        }

        protected K setKey(K key) {
            K oldKey = getKey();
            k = key;
            return oldKey;
        }

        protected V setValue(V value) {
            V oldValue = getValue();
            v = value;
            return oldValue;
        }
    }
}
