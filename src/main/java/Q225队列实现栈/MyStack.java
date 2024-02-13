package Q225队列实现栈;

import java.util.LinkedList;
import java.util.Queue;

/** Version A: Efficient Push */
public class MyStack {
  private Queue<Integer> q1;
  private Queue<Integer> q2;

  /** Initialize your data structure here. */
  public MyStack() {
    q1 = new LinkedList<>();
    q2 = new LinkedList<>();
  }

  /** Push element x onto stack. */
  public void push(int x) {
    q1.offer(x);
  }

  /** Removes the element on top of the stack and returns that element. */
  public int pop() {
    if (q1.size() == 0) {
      throw new RuntimeException("stack is empty!");
    }

    while (q1.size() > 1) {
      q2.offer(q1.poll());
    }

    int ret = q1.poll();
    // 交换q1, q2
    Queue<Integer> tmp = q1;
    q1 = q2;
    q2 = tmp;
    return ret;
  }

  /** Get the top element. */
  public int top() {
    if (q1.size() == 0) {
      throw new RuntimeException("stack is empty!");
    }

    while (q1.size() > 1) {
      q2.offer(q1.poll());
    }

    int ret = q1.poll();
    q2.offer(ret);
    // 交换q1, q2
    Queue<Integer> tmp = q1;
    q1 = q2;
    q2 = tmp;
    return ret;
  }

  /** Returns whether the stack is empty. */
  public boolean empty() {
    return q1.isEmpty() && q2.isEmpty();
  }
}

/**
 * Your MyStack object will be instantiated and called as such: MyStack obj = new MyStack();
 * obj.push(x); int param_2 = obj.pop(); int param_3 = obj.top(); boolean param_4 = obj.empty();
 */
