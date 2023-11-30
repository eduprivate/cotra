package br.eduprivate.problems_solving.binarysearch;

// see geeksforgeeks

import java.util.*;
class FirstLastOccurrence {

    // if x is present in arr[] then
    // returns the index of FIRST
    // occurrence of x in arr[0..n-1],
    // otherwise returns -1
    static int first(int arr[], int x, int n)
    {
        int low = 0, high = n - 1, res = -1;
        while (low <= high) {
            // Normal Binary Search Logic
            int mid = (low + high) / 2;
            if (arr[mid] > x)
                high = mid - 1;
            else if (arr[mid] < x)
                low = mid + 1;

                // If arr[mid] is same as
                // x, we update res and
                // move to the left half.
            else {
                res = mid;
                high = mid - 1;
            }
        }
        return res;
    }

    // If x is present in arr[] then returns
    // the index of LAST occurrence of x in
    // arr[0..n-1], otherwise returns -1
    static int last(int arr[], int x, int n)
    {
        int low = 0, high = n - 1, res = -1;
        while (low <= high) {
            // Normal Binary Search Logic
            int mid = (low + high) / 2;
            if (arr[mid] > x)
                high = mid - 1;
            else if (arr[mid] < x)
                low = mid + 1;

                // If arr[mid] is same as x,
                // we update res and move to
                // the right half.
            else {
                res = mid;
                low = mid + 1;
            }
        }
        return res;
    }

    // Driver program
    public static void main(String[] args)
    {
        int arr[] = { 1, 2, 2, 2, 2, 3, 4, 7, 8, 8 };
        int n = arr.length;
        int x = 8;
        System.out.println("First Occurrence = "
                + first(arr, x, n));
        System.out.println("Last Occurrence = "
                + last(arr, x, n));
    }
}