package Q225队列实现栈;

import java.util.LinkedList;
import java.util.Queue;

/** Version B: Efficient Pop */
public class MyStack2 {
  private Queue<Integer> q1;
  private Queue<Integer> q2;

  /** Initialize your data structure here. */
  public MyStack2() {
    q1 = new LinkedList<>();
    q2 = new LinkedList<>();
  }

  /** Push element x onto stack. */
  public void push(int x) {
    q1.offer(x);
    while (!q2.isEmpty()) {
      q1.offer(q2.poll());
    }

    Queue<Integer> tmp = q1;
    q1 = q2;
    q2 = tmp;
  }

  /** Removes the element on top of the stack and returns that element. */
  public int pop() {
    return q2.poll();
  }

  /** Get the top element. */
  public int top() {
    return q2.peek();
  }

  /** Returns whether the stack is empty. */
  public boolean empty() {
    return q1.isEmpty() && q2.isEmpty();
  }
}
