package com.vachna.heap;

import com.vachna.utill.HelperUtil;

import java.util.Collections;
import java.util.PriorityQueue;

public class FindMedianFromDataStream {
    /**
     * The median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value, and the median is the mean of the two middle values.
     *
     * For example, for arr = [2,3,4], the median is 3.
     * For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
     * Implement the MedianFinder class:
     *
     * MedianFinder() initializes the MedianFinder object.
     * void addNum(int num) adds the integer num from the data stream to the data structure.
     * double findMedian() returns the median of all elements so far. Answers within 10-5 of the actual answer will be accepted.
     */
    private final PriorityQueue<Integer> minHeap;
    private final PriorityQueue<Integer> maxHeap;

    public FindMedianFromDataStream() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }

    public void addNum(int num) {
        int a = maxHeap.size(), b = minHeap.size();
        if(a == 0){
            maxHeap.add(num);
        } else if(a <= b){
            if(minHeap.peek() < num){  // maxHeap-> 2 3 | 9 10 <-minHeap -> num = 11
                maxHeap.add(minHeap.poll());
                minHeap.add(num); //maxHeap-> 2 3 9 | 10 11 <-minHeap
            } else if(minHeap.peek() >= num) { // maxHeap-> 2 3 | 9 10 <-minHeap -> num = 8
                maxHeap.add(num);
            }
        } else if (a > b){// maxHeap-> 2 3 5 | 9 10 <-minHeap -> num = 11
            if(maxHeap.peek() <= num){
                minHeap.add(num);
            } else { // maxHeap-> 2 3 5 | 9 10 <-minHeap -> num = 4
                minHeap.add(maxHeap.poll());
                maxHeap.add(num);
            }
        }
    }

    public double findMedian() {
        int a = maxHeap.size(), b = minHeap.size();
        if(a == b){
            if(a == 0) return 0;
            return (maxHeap.peek() + minHeap.peek())/2.00;
        } else {
            return (a > b)? maxHeap.peek() : minHeap.peek();
        }
    }

    public static void main(String[] args) {
        FindMedianFromDataStream fun = new FindMedianFromDataStream();
        fun.addNum(4);
        HelperUtil.printTree(fun.maxHeap);
        HelperUtil.printTree(fun.minHeap);
        System.out.println("Median: " + fun.findMedian());
        fun.addNum(3);
        HelperUtil.printTree(fun.maxHeap);
        HelperUtil.printTree(fun.minHeap);
        System.out.println("Median: " + fun.findMedian());
        fun.addNum(2);
        HelperUtil.printTree(fun.maxHeap);
        HelperUtil.printTree(fun.minHeap);
        System.out.println("Median: " + fun.findMedian());
        fun.addNum(7);
        HelperUtil.printTree(fun.maxHeap);
        HelperUtil.printTree(fun.minHeap);
        System.out.println("Median: " + fun.findMedian());
        fun.addNum(8);
        HelperUtil.printTree(fun.maxHeap);
        HelperUtil.printTree(fun.minHeap);
        System.out.println("Median: " + fun.findMedian());
        fun.addNum(11);
        HelperUtil.printTree(fun.maxHeap);
        HelperUtil.printTree(fun.minHeap);
        System.out.println("Median: " + fun.findMedian());
        fun.addNum(1);
        HelperUtil.printTree(fun.maxHeap);
        HelperUtil.printTree(fun.minHeap);
        System.out.println("Median: " + fun.findMedian());
        fun.addNum(5);
        HelperUtil.printTree(fun.maxHeap);
        HelperUtil.printTree(fun.minHeap);
        System.out.println("Median: " + fun.findMedian());
        fun.addNum(6);
        HelperUtil.printTree(fun.maxHeap);
        HelperUtil.printTree(fun.minHeap);
        System.out.println("Median: " + fun.findMedian());
    }
}
