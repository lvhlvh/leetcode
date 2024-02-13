package lintcode.Q102有最小平均值的子树;

public class Solution {
    private static class TreeNodeInfo {
        int sum;
        int nodeCount;

        TreeNodeInfo(int sum, int nodeCount) {
            this.sum = sum;
            this.nodeCount = nodeCount;
        }
    }

    private double minAvg = Double.MAX_VALUE;
    private TreeNode minAvgNode;

    public TreeNode findSubtree(TreeNode root) {
        if (root == null) {
            return null;
        }
        findSubtreeHelper(root);
        return minAvgNode;
    }

    private TreeNodeInfo findSubtreeHelper(TreeNode node) {
        if (node == null) {
            return new TreeNodeInfo(0, 0);
        }

        TreeNodeInfo leftTreeNodeInfo = findSubtreeHelper(node.left);
        TreeNodeInfo rightTreeNodeInfo = findSubtreeHelper(node.right);
        int sum =  node.val + leftTreeNodeInfo.sum + rightTreeNodeInfo.sum;
        int nodeCount = leftTreeNodeInfo.nodeCount + rightTreeNodeInfo.nodeCount + 1;
        double avg = sum * 1.0 / nodeCount;
        if (avg < minAvg) {
            minAvg = avg;
            minAvgNode = node;
        }
        return new TreeNodeInfo(sum, nodeCount);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}