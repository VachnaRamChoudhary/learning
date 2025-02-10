package com.vachna.tree;

import com.vachna.modals.TreeNode;

public class InvertBinaryTree {

    public InvertBinaryTree() {
        Integer[] tree = {4,2,7,1,3,6,9};
        TreeNode root = TreeNode.arrayToTree(tree);
        TreeNode.printTree(root);
        root = invertTree(root);
        TreeNode.printTree(root);
    }

    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

    public static void main(String[] args) {
        new InvertBinaryTree();
    }
}
