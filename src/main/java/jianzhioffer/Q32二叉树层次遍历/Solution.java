package jianzhioffer.Q32二叉树层次遍历;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
  public int[] levelOrder(TreeNode root) {
    if (root == null) {
      return new int[0];
    }

    List<Integer> result = new ArrayList<>();
    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);
    while (!q.isEmpty()) {
      TreeNode node = q.poll();
      result.add(node.val);
      if (node.left != null) {
        q.add(node.left);
      }
      if (node.right != null) {
        q.add(node.right);
      }
    }

    return result.stream().mapToInt(i -> i).toArray();
  }
}
