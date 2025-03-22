package dsa.src.main.java.com.vachna.modals;

import java.util.*;

public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static void printTree(TreeNode root) {
        if (root == null) return;

        // Use a queue for level-order traversal
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        Map<TreeNode, Integer> depthMap = new HashMap<>();
        depthMap.put(root, 0);

        int maxDepth = 0;
        List<List<String>> levels = new ArrayList<>();

        // Level order traversal to store node values at each level
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int depth = depthMap.get(node);
            maxDepth = Math.max(maxDepth, depth);

            if (levels.size() == depth) {
                levels.add(new ArrayList<>());
            }

            levels.get(depth).add(node == null ? " " : String.valueOf(node.val));

            if (node != null) {
                queue.add(node.left);
                queue.add(node.right);
                depthMap.put(node.left, depth + 1);
                depthMap.put(node.right, depth + 1);
            }
        }

        // Print the tree in a structured format
        int maxWidth = (int) Math.pow(2, maxDepth) * 4; // Adjust width dynamically

        for (int i = 0; i < levels.size(); i++) {
            int spacing = maxWidth / (int) Math.pow(2, i + 1);
            StringBuilder levelString = new StringBuilder();

            for (String val : levels.get(i)) {
                levelString.append(" ".repeat(spacing)).append(val).append(" ".repeat(spacing));
            }

            System.out.println(levelString);
        }
    }


    public static TreeNode arrayToTree(Integer[] arr) {
        if (arr == null || arr.length == 0) return null;

        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        for (int i = 1; i < arr.length; ) {
            TreeNode parent = nodeQueue.poll();
            if (parent == null) continue;

            // Insert left child
            if (arr[i] != null) {
                parent.left = new TreeNode(arr[i]);
                nodeQueue.add(parent.left);
            }
            if (++i >= arr.length) break; // Move to the next index and check bounds

            // Insert right child
            if (arr[i] != null) {
                parent.right = new TreeNode(arr[i]);
                nodeQueue.add(parent.right);
            }
            i++;
        }
        return root;
    }

}
