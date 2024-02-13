package Q232用栈实现队列;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/implement-queue-using-stacks
 *
 * 更优雅的版本: 每次pop()或peek()之前如果s2为空的话，都将s1中的所有元素转移到s2
 * (如果转移后s2还是空，说明队列空了；否则)
 * https://leetcode-cn.com/problems/implement-queue-using-stacks/solution/shi-yong-liang-ge-zhan-yi-ge-zhuan-men-ru-dui-yi-g/
 */
public class MyQueue2 {
    private Stack<Integer> s1;
    private Stack<Integer> s2;

    /** Initialize your data structure here. */
    public MyQueue2() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    /** Push element x to the back of queue.
     *  O(1)
     * */
    public void push(int x) {
        s1.push(x);
    }

    /** Removes the element from in front of queue and returns that element.
     *  O(1): 均摊复杂度，因为并不是每次pop()都会导致元素从s1移动到s2
     * */
    public int pop() {
        shift();
        if (!s2.empty()) {
            return s2.pop();
        }
        return -1;
    }

    /** Get the front element.
     * O(1): 同样是均摊复杂度
     * */
    public int peek() {
        shift();
        if (!s2.empty()) {
            return s2.peek();
        }
        return -1;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.empty() && s2.empty();
    }

    private void shift() {
        if (s2.empty()) {
            while (!s1.empty()) {
                s2.push(s1.pop());
            }
        }
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */