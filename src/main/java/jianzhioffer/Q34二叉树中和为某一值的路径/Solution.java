package jianzhioffer.Q34二叉树中和为某一值的路径;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        return null;
    }

    public List<List<Integer>> getAllPaths(TreeNode root) {
        // Traversal
        /*List<List<Integer>> paths = new ArrayList<>();
        getAllPaths(root, paths, new ArrayList<>());
        return paths;*/

        // Divide & Conquer
        return getAllPathsDC(root);
    }

    /**
     * Traversal
     */
    private void getAllPaths(TreeNode node, List<List<Integer>> paths, List<Integer> path) {
        if (node == null) {
            return;
        }

        path = new ArrayList<>(path);
        path.add(node.val);
        if (node.left == null && node.right == null) { // 叶子节点
            paths.add(path);
        }

        getAllPaths(node.left, paths, path);
        getAllPaths(node.right, paths, path);
    }

    /**
     * Divide & Conquer: 时间复杂度高于Traversal方法
     */
    private List<List<Integer>> getAllPathsDC(TreeNode node) {
        List<List<Integer>> paths = new ArrayList<>();
        if (node == null) {
            return paths;
        }
        if (node.left == null && node.right == null) {
            List<Integer> path = new ArrayList<>();
            path.add(node.val);
            paths.add(path);
            return paths;
        }

        List<List<Integer>> leftPaths = getAllPathsDC(node.left);
        List<List<Integer>> rightPaths = getAllPathsDC(node.right);

        for (List<Integer> leftPath : leftPaths) {
            List<Integer> path = new ArrayList<>();
            path.add(node.val);
            path.addAll(leftPath);
            paths.add(path);
        }

        for (List<Integer> rightPath : rightPaths) {
            List<Integer> path = new ArrayList<>();
            path.add(node.val);
            path.addAll(rightPath);
            paths.add(path);
        }

        return paths;
    }

}


