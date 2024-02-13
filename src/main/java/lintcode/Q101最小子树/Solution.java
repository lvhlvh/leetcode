package lintcode.Q101最小子树;

/** 求树root中节点值之和最小的子树 */
public class Solution {
  private TreeNode minNode = null;
  private int min = Integer.MAX_VALUE;

  public TreeNode findSubtree(TreeNode root) {
    helper(root);
    return minNode;
  }

  private int helper(TreeNode node) {
    if (node == null) {
      return 0;
    }

    // 以node为根的子树
    // divide & conquer
    int sum = helper(node.left) + helper(node.right) + node.val;

    // traverse
    if (sum < min) {
      min = sum;
      minNode = node;
    }

    return sum;
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
