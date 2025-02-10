package com.vachna.tree;

import com.vachna.modals.TreeNode;

public class MaximumDepthofBinaryTree {

    public MaximumDepthofBinaryTree() {
        Integer[] tree = {3,9,20,null,null,15,7};
        TreeNode root = TreeNode.arrayToTree(tree);
        TreeNode.printTree(root);
        System.out.println("Depth: " + maxDepth(root));

        System.out.println("isSameTree: "+ isSameTree(root, root));
    }

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }


    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        return (p.val == q.val) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        new MaximumDepthofBinaryTree();
    }
}
