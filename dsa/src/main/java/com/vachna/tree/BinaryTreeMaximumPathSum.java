package com.vachna.tree;

import dsa.src.main.java.com.vachna.modals.TreeNode;

import java.util.concurrent.atomic.AtomicInteger;

public class BinaryTreeMaximumPathSum {


    /**
     * A path in a binary tree is a sequence of nodes where each pair
     * of adjacent nodes in the sequence has an edge connecting them.
     * A node can only appear in the sequence at most once.
     * Note that the path does not need to pass through the root.
     * The path sum of a path is the sum of the node's values in the path.
     * Given the root of a binary tree, return the maximum path sum of any non-empty path.
     *
     * https://leetcode.com/problems/binary-tree-maximum-path-sum/
     */


    public BinaryTreeMaximumPathSum() {
        Integer[] tree = {-10,9,20,null,null,15,7};
        TreeNode root = TreeNode.arrayToTree(tree);
         TreeNode.printTree(root);
         System.out.println("Max sum: " + maxPathSum(root));
    }

    public int maxPathSum(TreeNode root) {
        AtomicInteger maxSum = new AtomicInteger(Integer.MIN_VALUE); // Atomic reference
        updateMaxSum(root, maxSum);
        return maxSum.get();
    }

    private int updateMaxSum(TreeNode root, AtomicInteger maxSum) {
        if(root == null) return 0;

        // Compute max path sum from left and right, ignore negative sums
        int leftSum = Math.max(0, updateMaxSum(root.left, maxSum));
        int rightSum = Math.max(0, updateMaxSum(root.right, maxSum));

        maxSum.set(Math.max(maxSum.get(), leftSum + rightSum + root.val));
        return root.val + Math.max(leftSum, rightSum);
    }

    public static void main(String[] args) {
        new BinaryTreeMaximumPathSum();
    }
}
