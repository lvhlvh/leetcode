package lintcode.Q370表达值转逆波兰;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 从左到右遍历中缀表达式:
 *
 * <p>如果碰到 数字, 直接追加到 RPN 末尾. 如果碰到 左括号, 入栈 如果碰到 右括号, 弹栈, 并将弹出的元素依次追加到 RPN 末尾, 直至左括号弹出(左括号不追加至PN) 如果碰到
 * 运算符, 弹栈直至栈顶元素优先级 小于 当前运算符, 所有弹出的元素依次追加到 RPN 末尾, 最后再将该运算符入栈 出于方便, 我们设定所有元素的优先级: 乘除 最高,+-次之,最后是括号.
 * (把括号设为最低是因为,碰到运算符弹栈时,遇到括号也要停止,所以可以直接设为最低)
 *
 * <p>易错的点！！ 最后,如果栈还有剩余,弹栈,依次追加到 RPN 末尾,然后我们就得到了正确结果 RPN.
 */
public class Solution {
  /**
   * @param expression: A string array
   * @return: The Reverse Polish notation of this expression
   */
  public List<String> convertToRPN(String[] expression) {
    List<String> res = new ArrayList<>();
    Stack<String> stack = new Stack<>();

    for (int i = 0; i < expression.length; ++i) {
      String s = expression[i];
      if ("+-*/()".contains(s)) {
        res.add(s);
      } else if (s.equals("(")) {
        stack.push(s);
      } else if (s.equals(")")) {
        while (!stack.isEmpty() && !stack.peek().equals("(")) {
          res.add(stack.pop());
        }
        if (stack.isEmpty()) throw new IllegalArgumentException("invalid expression");
        stack.pop();
      } else {
        while (!stack.isEmpty() && (getPriority(stack.peek()) >= getPriority(s))) {
          res.add(stack.pop());
        }
        stack.push(s);
      }
    }

    while (!stack.isEmpty()) {
      res.add(stack.pop());
    }

    return res;
  }

  private int getPriority(String s) {
    switch (s) {
      case "*":
      case "/":
        return 3;
      case "+":
      case "-":
        return 2;
      case "(":
        return 1;
      default:
        return 0;
    }
  }
}
