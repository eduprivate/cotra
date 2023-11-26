package br.eduprivate.problems_solving;

class TwoHeaps {

    // Standard heapify function to heapify a
    // subtree rooted under idx. It assumes
    // that subtrees of node are already heapified.
    public static void maxHeapify(int[] arr, int N, int i)
    {
        // Find largest of node and its children
        if (i >= N) {
            return;
        }
        int l = i * 2 + 1;
        int r = i * 2 + 2;
        int max;
        if (l < N && arr[l] > arr[i]) {
            max = l;
        }
        else
            max = i;
        if (r < N && arr[r] > arr[max]) {
            max = r;
        }

        // Put maximum value at root and
        // recur for the child with the
        // maximum value
        if (max != i) {
            int temp = arr[max];
            arr[max] = arr[i];
            arr[i] = temp;
            maxHeapify(arr, N, max);
        }
    }

    // Merges max heaps a[] and b[] into merged[]
    public static void mergeHeaps(int[] arr, int[] a,
                                  int[] b, int N, int M)
    {
        for (int i = 0; i < N; i++) {
            arr[i] = a[i];
        }
        for (int i = 0; i < M; i++) {
            arr[N + i] = b[i];
        }
        N = N + M;

        // Builds a max heap of given arr[0..n-1]
        for (int i = N / 2 - 1; i >= 0; i--) {
            maxHeapify(arr, N, i);
        }
    }

    // Driver's Code
    public static void main(String[] args)
    {
        int[] a = { 10, 5, 6, 2 };
        int[] b = { 12, 7, 9 };
        int N = a.length;
        int M = b.length;

        int[] merged = new int[M + N];

        // Function call
        mergeHeaps(merged, a, b, N, M);

        for (int i = 0; i < M + N; i++)
            System.out.print(merged[i] + " ");
        System.out.println();
    }
}