package com.vachna.tree;

import dsa.src.main.java.com.vachna.modals.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {


    public ConstructBinaryTreeFromInorderAndPostorderTraversal() {
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};

        TreeNode root = buildTree(inorder, postorder);
        TreeNode.printTree(root);

    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length) return null;

        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            mp.put(inorder[i], i);
        }

        return constructTree(0, inorder.length - 1, inorder,
                0, postorder.length - 1, postorder, mp);
    }

    private TreeNode constructTree(int is, int ie, int[] inorder,
                                   int ps, int pe, int[] postorder,
                                   Map<Integer, Integer> mp) {
        if (is > ie || ps > pe) return null;

        TreeNode root = new TreeNode(postorder[pe]);

        int rootInInOrder = mp.get(root.val);
        int leftSubtreeSize = rootInInOrder - is;

        root.left = constructTree(is, rootInInOrder - 1, inorder,
                ps, ps + leftSubtreeSize - 1, postorder, mp);
        root.right = constructTree(rootInInOrder + 1, ie, inorder,
                ps + leftSubtreeSize, pe - 1, postorder, mp);

        return root;
    }


    public static void main(String[] args) {
        new ConstructBinaryTreeFromInorderAndPostorderTraversal();
    }
}
