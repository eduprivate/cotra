package br.eduprivate.problems_solving.topkelements;

import java.util.*;

// see geeksforgeeks

class BucketSort {

    // Function to print the k numbers with most occurrences
    static void print_N_mostFrequentNumber(int arr[], int N,
                                           int K)
    {

        // HashMap to store count of the elements
        HashMap<Integer, Integer> elementCount
                = new HashMap<>();

        for (int i = 0; i < N; i++) {
            elementCount.put(
                    arr[i],
                    elementCount.getOrDefault(arr[i], 0) + 1);
        }

        // Array to store the elements according
        // to their frequency
        List<List<Integer> > frequency = new ArrayList<>();

        for (int i = 0; i < N + 1; i++) {
            frequency.add(new ArrayList<>());
        }

        // Inserting elements in the frequency array
        for (int element : elementCount.keySet()) {
            frequency.get(elementCount.get(element))
                    .add(element);
        }

        int count = 0;
        System.out.println(
                K + " numbers with most occurrences are: ");

        for (int i = frequency.size() - 1; i >= 0; i--) {

            // if frequency is same,then take number with a
            // larger value
            // so,if more than 1 number present with same
            // frequency,then sort frequency[i] in
            // descending order
            if (frequency.get(i).size() > 1) {

                Collections.sort(
                        frequency.get(i),
                        Collections.reverseOrder());
            }

            for (int element : frequency.get(i)) {
                count++;
                System.out.print(element + " ");
                // if K elements have been printed
                if (count == K)
                    return;
            }
        }

        return;
    }

    public static void main(String[] args)
    {
        int arr[] = { 3, 1, 4, 4, 5, 2, 6, 1 };
        int N = arr.length;
        int K = 2;

        // Function call
        print_N_mostFrequentNumber(arr, N, K);
    }
}