package br.eduprivate.problems_solving.sliding;

public class SlidingWindow3 {

    private static int maxSum(int[] arr, int k) {
        if (k > arr.length){
            return -1;
        }
        int max_sum = 0;

        for (int i = 0; i < k; i++) {
            max_sum += arr[i];
        }

        int window_sum = max_sum;
        for (int i = k; i < arr.length; i++){
            max_sum += arr[i] - arr[i-k];
            window_sum = Math.max(window_sum, max_sum);
        }
        return window_sum;
    }
    public static void main(String[] args)
    {
        int arr[] = { 1, 4, 2, 10, 2, 3, 1, 0, 20, 2, 3, 4, 20, 4, 6, 2, 0, 40 };
        int k = 4;
        int n = arr.length;
        System.out.println(maxSum(arr, k));
    }

}
