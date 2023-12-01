package br.eduprivate.problems_solving.unboundedknapsack;

// see geeksforgeeks

class UnboundedKnapsackDP {

    // A utility function that returns
    // maximum of two integers
    static int max(int a, int b) { return (a > b) ? a : b; }

    // Returns the maximum value that
    // can be put in a knapsack of
    // capacity W
    static int unboundedKnapsack(int W, int wt[], int val[],
                                 int idx)
    {
        // Base Case
        // if we are at idx 0.
        if (idx == 0) {
            return (W / wt[0]) * val[0];
        }
        // There are two cases either take element or not
        // take. If not take then
        int notTake
                = 0 + unboundedKnapsack(W, wt, val, idx - 1);
        // if take then weight = W-wt[idx] and index will
        // remain same.
        int take = Integer.MIN_VALUE;
        if (wt[idx] <= W) {
            take = val[idx]
                    + unboundedKnapsack(W - wt[idx], wt, val,
                    idx);
        }
        return max(take, notTake);
    }

    // Driver code
    public static void main(String args[])
    {
        int W = 100;
        int val[] = { 10, 30, 20 };
        int wt[] = { 5, 10, 15 };
        int n = val.length;
        System.out.println(
                unboundedKnapsack(W, wt, val, n - 1));
    }
}