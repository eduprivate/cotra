package br.eduprivate.problems_solving.sliding;

public class NSlidingWindow {
        private static int maxSum(int arr[], int k)
        {
            int max_sum = 0;

            for (int i = 0; i < arr.length - k + 1; i++) {
                int currentSum = 0;
                for (int j = 0; j < k; j++) {
                    currentSum = currentSum + arr[j+i];
                }
                max_sum = Math.max(currentSum, max_sum);
            }

            return max_sum;
        }

        // Driver code
        public static void main(String[] args)
        {
            int arr[] = { 1, 4, 2, 10, 2, 3, 1, 0, 20 };
            int k = 4;
            System.out.println(maxSum(arr, k));
        }
}
