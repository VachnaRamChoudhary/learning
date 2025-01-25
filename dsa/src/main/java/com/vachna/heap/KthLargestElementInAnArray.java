package com.vachna.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargestElementInAnArray {

    /**
     * Given an integer array nums and an integer k, return the kth largest element in the array.
     *
     * Note that it is the kth largest element in the sorted order, not the kth distinct element.
     *
     * Can you solve it without sorting?
     *
     * https://leetcode.com/problems/kth-largest-element-in-an-array/
     */

    public KthLargestElementInAnArray(){
        int[] arr = {3,2,3,1,2,4,5,5,6};
        System.out.println(findKthLargest(arr, 14));
    }

    public int findKthLargest(int[] nums, int k) {
        // Min-Heap with size k
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int x : nums) {
            minHeap.add(x);

            // Ensure the heap size does not exceed k
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // The root of the heap is the k-th largest element
        return minHeap.peek();
    }


    public static void main(String[] args) {
        new KthLargestElementInAnArray();
    }
}
