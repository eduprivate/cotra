package br.eduprivate.problems_solving.backtracking;

import java.util.ArrayList;
import java.util.List;
// see geeksforgeeks

public class SubsetSum {

    // Flag to check if there exists a subset with the given
    // sum
    static boolean flag = false;

    // Print all subsets if there is at least one subset of
    // set[] with the sum equal to the given sum
    static void printSubsetSum(int i, int n, int[] set,
                               int targetSum,
                               List<Integer> subset)
    {
        // If targetSum is zero, then there exists a subset.
        if (targetSum == 0) {
            // Prints a valid subset
            flag = true;
            System.out.print("[ ");
            for (int j = 0; j < subset.size(); j++) {
                System.out.print(subset.get(j) + " ");
            }
            System.out.print("]");
            return;
        }

        if (i == n) {
            // Return if we have reached the end of the
            // array
            return;
        }

        // Not considering the current element
        printSubsetSum(i + 1, n, set, targetSum, subset);

        // Consider the current element if it is less than
        // or equal to the targetSum
        if (set[i] <= targetSum) {
            // Push the current element in the subset
            subset.add(set[i]);

            // Recursive call for considering the current
            // element
            printSubsetSum(i + 1, n, set,
                    targetSum - set[i], subset);

            // Pop-back element after the recursive call to
            // restore the subset's original configuration
            subset.remove(subset.size() - 1);
        }
    }

    // Driver code
    public static void main(String[] args)
    {
        // Test case 1
        int[] set1 = { 1, 2, 1 };
        int sum1 = 3;
        int n1 = set1.length;
        List<Integer> subset1 = new ArrayList<>();
        System.out.println("Output 1:");
        printSubsetSum(0, n1, set1, sum1, subset1);
        System.out.println();
        flag = false;

        // Test case 2
        int[] set2 = { 3, 34, 4, 12, 5, 2 };
        int sum2 = 30;
        int n2 = set2.length;
        List<Integer> subset2 = new ArrayList<>();
        System.out.println("Output 2:");
        printSubsetSum(0, n2, set2, sum2, subset2);
        if (!flag) {
            System.out.println("There is no such subset");
        }
    }
}
