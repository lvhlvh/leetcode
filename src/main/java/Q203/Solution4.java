package Q203;

/** 递归 */
public class Solution4 {
  /**
   * @param head
   * @param val
   * @param depth 递归深度
   * @return
   */
  public ListNode removeElements(ListNode head, int val, int depth) {
    String depthString = generateDepthString(depth);
    System.out.println(depthString + " Call remove " + val + " to " + head);

    if (head == null) {
      System.out.println(depthString + " Return null");
      return null;
    }

    ListNode remaining = removeElements(head.next, val, depth + 1);
    System.out.println(depthString + " After remove " + val + ": " + remaining);

    ListNode ret;
    if (head.val == val) {
      ret = remaining;
    } else {
      head.next = remaining;
      ret = head;
    }
    System.out.println(depthString + " Return " + ret);
    return ret;
  }

  private String generateDepthString(int depth) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < depth; i++) {
      sb.append("--");
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    ListNode head = new ListNode(1, 2, 6, 3, 4, 5, 6);
    System.out.println(head);

    System.out.println(new Solution4().removeElements(head, 6, 0));
  }
}
