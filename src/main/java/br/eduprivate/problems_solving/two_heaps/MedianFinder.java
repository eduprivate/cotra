package br.eduprivate.problems_solving.two_heaps;

import java.util.PriorityQueue;

// see stephen joel
class MedianFinder {

    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
    PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> a - b);

    //Copy-paste function from the pattern
    public void insert(int x){
        if (maxHeap.isEmpty() || maxHeap.peek() >= x)
            maxHeap.add(x);
        else
            minHeap.add(x);

        balanceHeaps();
    }

    //Copy-paste function from the pattern
    public double findMedian(){
        if(maxHeap.size() == minHeap.size())
            return ((double) maxHeap.peek() + minHeap.peek())/2;
        else
            return maxHeap.peek();
    }

    //Copy-paste function from the pattern
    public void balanceHeaps(){
        if (maxHeap.size() > minHeap.size() + 1)
            minHeap.add(maxHeap.poll());
        else if (maxHeap.size() < minHeap.size())
            maxHeap.add(minHeap.poll());
    }
}