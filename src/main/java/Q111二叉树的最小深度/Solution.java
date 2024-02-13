package Q111二叉树的最小深度;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
  public int minDepth(TreeNode root) {
    if (root == null) return 0;

    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);
    int nNodes = 1;

    while (!q.isEmpty()) {
      int sz = q.size();
      for (int i = 0; i < q.size(); ++i) {
        TreeNode tmp = q.poll();
        if (tmp.left == null && tmp.right == null) return nNodes;
        if (tmp.left != null) q.offer(tmp.left);
        if (tmp.right != null) q.offer(tmp.right);
      }

      nNodes++;
    }

    return -1;
  }
}

class TreeNode {
  int val;
  TreeNode left, right;

  TreeNode(int x) {
    val = x;
  }
}
