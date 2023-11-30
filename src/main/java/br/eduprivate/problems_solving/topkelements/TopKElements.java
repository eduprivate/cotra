package br.eduprivate.problems_solving.topkelements;


import java.util.*;

// see geeksforgeeks

public class TopKElements {
    static void print_N_mostFrequentNumber(int[] arr, int N,
                                           int K)
    {

        Map<Integer, Integer> mp
                = new HashMap<Integer, Integer>();

        // Put count of all the
        // distinct elements in Map
        // with element as the key &
        // count as the value.
        for (int i = 0; i < N; i++) {

            // Get the count for the
            // element if already present in the
            // Map or get the default value which is 0.
            mp.put(arr[i], mp.getOrDefault(arr[i], 0) + 1);
        }

        // Create a list from elements of HashMap
        List<Map.Entry<Integer, Integer> > list
                = new ArrayList<Map.Entry<Integer, Integer> >(
                mp.entrySet());

        // Sort the list
        Collections.sort(
                list,
                new Comparator<Map.Entry<Integer, Integer> >() {
                    public int compare(
                            Map.Entry<Integer, Integer> o1,
                            Map.Entry<Integer, Integer> o2)
                    {
                        if (o1.getValue() == o2.getValue())
                            return o2.getKey() - o1.getKey();
                        else
                            return o2.getValue()
                                    - o1.getValue();
                    }
                });

        for (int i = 0; i < K; i++)
            System.out.print(list.get(i).getKey() + " ");
    }

    // Driver's Code
    public static void main(String[] args)
    {
        int arr[] = { 3, 1, 4, 4, 5, 2, 6, 1 };
        int N = arr.length;
        int K = 2;

        // Function call
        System.out.println(
                K + " numbers with most occurrences are:");
        print_N_mostFrequentNumber(arr, N, K);
    }
}