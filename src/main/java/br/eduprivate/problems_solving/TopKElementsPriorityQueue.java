package br.eduprivate.problems_solving;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

class MyEntry<K, V> implements Comparable {
    protected K key;
    protected V value;

    public MyEntry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public int compareTo(Object o) {
        if (this.value == null || o == null) {
            return -1;
        }
        MyEntry other = (MyEntry)o;
        Integer actual = (Integer)this.getValue();
        Integer otherValue = (Integer)(other.getValue());

        if (actual > otherValue ) {
            return -1;
        } else {
            return 1;
        }

    }
}

public class TopKElementsPriorityQueue {

    public PriorityQueue<MyEntry<String, Integer>> parseFile(String file) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(file));

        PriorityQueue<MyEntry<String, Integer>> queue = new PriorityQueue<>();
        HashMap<String, Integer> result = new HashMap<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            String name = line.substring(0, line.indexOf(">") + 1);
            String text = line.substring(line.indexOf(">") + 1);
            String[] arrayText = text.split(" ");

            if (result.containsKey(name)){
                Integer count = result.get(name);
                result.put(name, count+arrayText.length);
            } else {
                result.put(name, arrayText.length);
            }

        }

        for (Map.Entry<String, Integer> entry : result.entrySet()) {
            String name = entry.getKey();
            Integer count = entry.getValue();
            MyEntry<String, Integer> mapEntry = new MyEntry<String, Integer>(name, count);

            queue.add(mapEntry);
        }
        scanner.close();

        return queue;
    }

    public static void main(String[] args) throws FileNotFoundException {
        String file = "logs";
        int n = 2;
        TopKElementsPriorityQueue topKElements = new TopKElementsPriorityQueue();
        PriorityQueue<MyEntry<String, Integer>> queue = topKElements.parseFile(file);

        while(n > 0) {
            final MyEntry<String, Integer> poll = queue.poll();
            System.out.println(poll.getKey() + " : " + poll.getValue());
            n--;
        }
        queue.poll();


    }
}
