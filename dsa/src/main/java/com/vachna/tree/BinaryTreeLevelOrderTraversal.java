package com.vachna.tree;

import com.vachna.modals.ListNode;
import com.vachna.modals.TreeNode;
import com.vachna.utill.HelperUtil;

import java.util.*;

public class BinaryTreeLevelOrderTraversal {
    public BinaryTreeLevelOrderTraversal() {
        Integer[] tree = {-10,9,20,null,null,15,7};
        TreeNode root = TreeNode.arrayToTree(tree);
        TreeNode.printTree(root);
//        System.out.println("Max sum: " + maxPathSum(root));
        List<List<Integer>> levelOrder = levelOrder(root);
        HelperUtil.print(levelOrder);
    }


    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levelOrder = new ArrayList<>();
        return getLevels(root, levelOrder);
    }

    private List<List<Integer>> getLevels(TreeNode root, List<List<Integer>> levelOrder) {
        if(root == null) return levelOrder;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while(queue.size() > 0){
            int size = queue.size();
            List<Integer> subList = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                subList.add(node.val);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            levelOrder.add(subList);
        }
        return levelOrder;
    }

    public static void main(String[] args) {
        new BinaryTreeLevelOrderTraversal();
    }
}
