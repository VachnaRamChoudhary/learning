package com.vachna.tree;

import dsa.src.main.java.com.vachna.modals.TreeNode;

public class ValidateBinarySearchTree {
    public ValidateBinarySearchTree() {
        Integer[] tree = {2,1,3,4};
        TreeNode root = TreeNode.arrayToTree(tree);
        System.out.println(isValidBST(root));
    }
    public boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    /**
     * Helper method to validate if the tree follows BST properties.
     * It ensures that all values in the left subtree are < root.val
     * and all values in the right subtree are > root.val.
     *
     * @param root Current node being validated
     * @param min  The minimum value allowed for this subtree
     * @param max  The maximum value allowed for this subtree
     * @return true if the subtree is a valid BST, otherwise false
     */
    private boolean validate(TreeNode root, long min, long max) {
        // Base case: If the node is null, return true (an empty tree is a BST)
        if (root == null) return true;

        // Check if the current node's value violates the BST property
        if (root.val <= min || root.val >= max) return false;

        // Recursively check the left and right subtrees:
        // Left subtree values must be strictly less than the current node's value
        // Right subtree values must be strictly greater than the current node's value
        return validate(root.left, min, root.val) && validate(root.right, root.val, max);
    }


    public static void main(String[] args) {
        new ValidateBinarySearchTree();
    }

}
