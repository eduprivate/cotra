package br.eduprivate.effective.c5.item27;
// Generic static factory method - Pages 130-131

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenericStaticFactory {
    // Generic static factory method
    public static <K,V> HashMap<K,V> newHashMap() {
        return new HashMap<K,V>();
    }

    public static void main(String[] args) {
        // Parameterized type instance creation with static factory
        Map<String, List<String>> anagrams = newHashMap();
    }
}
