package br.eduprivate.problems_solving.subsets;

import java.io.*;
import java.util.*;

// geeksforgeeks

class Subsets2 {

    // Function to find the subsets of
    // the given array
    public static void findSubsets(int[] nums)
    {
        // Get the length of the input array
        int n = nums.length;

        // Loop through all possible subsets
        // using bit manipulation
        for (int i = 0; i < (1 << n); i++) {

            // Loop through all elements
            // of the input array
            for (int j = 0; j < n; j++) {

                // Check if the jth bit is set
                // in the current subset
                if ((i & (1 << j)) != 0) {

                    // If the jth bit is set,
                    // add the jth
                    // element to the subset
                    System.out.print(nums[j] + " ");
                }
            }

            System.out.println();
        }
    }

    // Driver Code
    public static void main(String[] args)
    {
        int[] arr = new int[] { 1, 2, 3 };
        findSubsets(arr);
    }
}
