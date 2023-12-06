package br.eduprivate.problems_solving.topkelements;


import java.util.*;

public class MostFrequent {

    public static void main(String[] args)
    {
        int arr[] = { 3, 1, 4, 4, 5, 2, 6, 1 };
        int K = 2;

        // Function call
        print_N_mostFrequentNumber(arr, K);
    }

    private static void print_N_mostFrequentNumber(int[] arr, int k) {
        Map<Integer, Integer> quantity = new HashMap<Integer, Integer>();

        for (int i = 0; i < arr.length; i++) {
            int current = arr[i];

            if(quantity.containsKey(current)) {
               int total = quantity.get(current);
               total = total + 1;
               quantity.put(current, total);
            } else {
                quantity.put(current, 1);
            }
        }

        Set<Map.Entry<Integer, Integer>> set = quantity.entrySet();
        List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>(set);
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            public int compare(Map.Entry<Integer, Integer> o1,
                               Map.Entry<Integer, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        int count = 0;
        for (Map.Entry<Integer, Integer> entry : list) {
            ++count;
            System.out.println(entry.getKey());

            if(count == k) {
                break;
            }
        }

    }
}
