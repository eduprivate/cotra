package br.eduprivate.problems_solving.topkelements;

import java.util.*;

// see geeksforgeeks

public class KFrequentNumbers {
    static void print_N_mostFrequentNumber(int[] arr, int N,
                                           int K)
    {
        Map<Integer, Integer> mp
                = new HashMap<Integer, Integer>();

        for (int i = 0; i < N; i++) {
            mp.put(arr[i], mp.getOrDefault(arr[i], 0) + 1);
        }

        // Create a Priority Queue
        // to sort based on the
        // count or on the key if the
        // count is same
        PriorityQueue<Map.Entry<Integer, Integer>> queue
                = new PriorityQueue<>(
                (a, b)
                        -> a.getValue().equals(b.getValue())
                        ? Integer.compare(b.getKey(),
                        a.getKey())
                        : Integer.compare(b.getValue(),
                        a.getValue()));

        for (Map.Entry<Integer, Integer> entry :
                mp.entrySet())
            queue.offer(entry);

        // Print the top k elements
        for (int i = 0; i < K; i++) {
            System.out.print(queue.poll().getKey() + " ");
        }
    }

    // Driver's Code
    public static void main(String[] args)
    {
        int arr[] = { 3, 1, 4, 4, 5, 2, 6, 1 };
        int N = arr.length;
        int K = 2;

        System.out.println(
                K + " numbers with most occurrences are:");
        // Function call
        print_N_mostFrequentNumber(arr, N, K);
    }
}