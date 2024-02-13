package Q155MinStack;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/min-stack
 *
 * <p>Using 2 stacks https://www.youtube.com/watch?v=5h42eila268
 */
public class MinStack {
  private Stack<Integer> stack;
  private Stack<Integer> helperStack; // 记录对应长度的栈的最小值

  /** initialize your data structure here. */
  public MinStack() {
    stack = new Stack<>();
    helperStack = new Stack<>();
  }

  public void push(int x) {
    stack.push(x);
    if (helperStack.empty() || x < helperStack.peek()) {
      helperStack.push(x);
    } else {
      helperStack.push(helperStack.peek());
    }
  }

  public void pop() {
    stack.pop();
    helperStack.pop();
  }

  public int top() {
    return stack.peek();
  }

  public int getMin() {
    return helperStack.peek();
  }
}

/**
 * Your MinStack object will be instantiated and called as such: MinStack obj = new MinStack();
 * obj.push(x); obj.pop(); int param_3 = obj.top(); int param_4 = obj.getMin();
 */
