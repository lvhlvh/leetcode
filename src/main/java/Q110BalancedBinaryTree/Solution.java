package Q110BalancedBinaryTree;

public class Solution {
    private static class ResultType {
        int leftDepth;
        int rightDepth;

        ResultType() {
            leftDepth = rightDepth = 0;
        }

        int getMax() {
            return Math.max(leftDepth, rightDepth);
        }
    }

    public boolean isBalanced(TreeNode root) {
        ResultType result = helper(root);
        return Math.abs(result.leftDepth - result.rightDepth) <= 1;
    }

    public ResultType helper(TreeNode node) {
        ResultType result = new ResultType();
        if (node == null) {
            return result;
        }

        result.leftDepth = helper(node.left).getMax() + 1;
        result.rightDepth = helper(node.right).getMax() + 1;

        return result;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    TreeNode(int x, TreeNode left, TreeNode right) {
        this(x);
        this.left = left;
        this.right = right;
    }
}