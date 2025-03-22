package com.vachna.tree;

import dsa.src.main.java.com.vachna.modals.TreeNode;

import java.util.concurrent.atomic.AtomicInteger;

public class KthSmallestElementInABST {
    public KthSmallestElementInABST() {
        Integer[] tree = {3,1,4,null,2};
        TreeNode root = TreeNode.arrayToTree(tree);
        Integer kthSmallest = kthSmallest(root, 1);
        System.out.println(kthSmallest);
    }

    private Integer kthSmallest(TreeNode root, int k) {
        AtomicInteger kthSmallest = new AtomicInteger(Integer.MIN_VALUE);
        AtomicInteger counter = new AtomicInteger(0);
        kthSmallestEle(root, k, counter,kthSmallest);
        return kthSmallest.get();
    }

    private void kthSmallestEle(TreeNode root, int k, AtomicInteger counter, AtomicInteger kthSmallest) {
        if(root == null) return;

        kthSmallestEle(root.left, k, counter, kthSmallest);

        counter.addAndGet(1);
        if(counter.get() == k) {
            kthSmallest.set(root.val);
            return;
        }

        kthSmallestEle(root.right, k, counter, kthSmallest);
    }

    public static void main(String[] args) {
        new KthSmallestElementInABST();
    }
}
