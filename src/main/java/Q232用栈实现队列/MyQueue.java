package Q232用栈实现队列;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/implement-queue-using-stacks
 *
 * <p>自己实现的版本: pop()个peek()代码重复，不够优雅
 *
 * <p>该版本中: 当s2为空时才考虑将s1中的元素转入s2
 */
public class MyQueue {
  private Stack<Integer> s1;
  private Stack<Integer> s2;

  /** Initialize your data structure here. */
  public MyQueue() {
    s1 = new Stack<>();
    s2 = new Stack<>();
  }

  /** Push element x to the back of queue. O(1) */
  public void push(int x) {
    s1.push(x);
  }

  /**
   * Removes the element from in front of queue and returns that element. O(1):
   * 均摊复杂度，因为并不是每次pop()都会导致元素从s1移动到s2
   */
  public int pop() {
    if (!s2.empty()) {
      return s2.pop();
    } else if (!s1.empty() && s2.empty()) {
      push2s2();
      return s2.pop();
    }
    return -1;
  }

  /** Get the front element. O(1): 同样是均摊复杂度 */
  public int peek() {
    if (!s2.empty()) {
      return s2.peek();
    } else if (!s1.empty() && s2.empty()) {
      push2s2();
      return s2.peek();
    }
    return -1;
  }

  /** Returns whether the queue is empty. */
  public boolean empty() {
    return s1.empty() && s2.empty();
  }

  private void push2s2() {
    while (!s1.empty()) {
      s2.push(s1.pop());
    }
  }
}

/**
 * Your MyQueue object will be instantiated and called as such: MyQueue obj = new MyQueue();
 * obj.push(x); int param_2 = obj.pop(); int param_3 = obj.peek(); boolean param_4 = obj.empty();
 */
