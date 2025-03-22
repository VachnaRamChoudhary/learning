package com.vachna.tree;

import dsa.src.main.java.com.vachna.modals.TreeNode;

public class LcsOfBst {

    public LcsOfBst() {
        Integer[] tree = {6,2,8,0,4,7,9,null,null,3,5};
        TreeNode root = TreeNode.arrayToTree(tree);
        TreeNode.printTree(root);
        System.out.println("LCS: " + lowestCommonAncestor(root, new TreeNode(7), new TreeNode(9)).val);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return root;
        }
    }

    public static void main(String[] args) {
        new LcsOfBst();
    }
}
