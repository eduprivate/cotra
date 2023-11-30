package br.eduprivate.problems_solving.topkelements;

import java.util.*;


// see geeksforgeeks

class QuickSelect {
    static List<Integer>
    print_N_mostFrequentNumber(List<Integer> nums, int k,
                               List<Integer> out)
    {
        // Map for counting the number of occurrences
        Map<Integer, Integer> counts = new HashMap<>();
        // Storing the frequency of each element
        for (int num : nums)
            counts.put(num,
                    counts.getOrDefault(num, 0) + 1);
        // Creating a list for storing the frequency
        List<Map.Entry<Integer, Integer> > freqs
                = new ArrayList<>(counts.entrySet());
        // Using the user-defined function Collections.sort
        // to sort by frequency
        Collections.sort(
                freqs, (a, b) -> b.getValue() - a.getValue());
        // Adding the k most frequent numbers to the output
        // list
        for (int i = 0; i < k; i++)
            out.add(freqs.get(i).getKey());
        // Returning the result in the out list
        return out;
    }

    // Driver's code
    public static void main(String[] args)
    {
        List<Integer> arr = new ArrayList<>(
                Arrays.asList(3, 1, 4, 4, 5, 2, 6, 1));
        int k = 2;

        // Function call
        List<Integer> ans = new ArrayList<>(k);
        print_N_mostFrequentNumber(arr, k, ans);
        System.out.println(
                k + " numbers with most occurrences are:");
        for (int i = ans.size() - 1; i >= 0; i--) {
            System.out.print(ans.get(i) + " ");
        }
    }
}
