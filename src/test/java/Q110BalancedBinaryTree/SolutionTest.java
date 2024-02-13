package Q110BalancedBinaryTree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

  private TreeNode tree = null;

  @BeforeEach
  void init() {
    TreeNode leaf1 = new TreeNode(4);
    TreeNode leaf2 = new TreeNode(4);
    TreeNode leaf3 = new TreeNode(3);
    TreeNode leaf4 = new TreeNode(2);
    TreeNode levelM1 = new TreeNode(3, leaf1, leaf2);
    TreeNode levelM2 = new TreeNode(2, levelM1, leaf3);
    tree = new TreeNode(1, levelM2, leaf4);
  }

  @Test
  void isBalanced() {
    System.out.println(new Solution().isBalanced(tree));
  }

  @Test
  void test() {
    inOrderTraversal(tree);
  }

  private void inOrderTraversal(TreeNode node) {
    if (node == null) {
      return;
    }

    inOrderTraversal(node.left);
    System.out.print(node.val + " ");
    inOrderTraversal(node.right);
  }
}
