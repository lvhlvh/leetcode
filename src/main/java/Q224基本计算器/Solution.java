package Q224基本计算器;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
  public int calculate(String s) {
    List<String> rpn = convertToRPN(s);
    return evaluateRPN(rpn);
  }

  public List<String> convertToRPN(String s) {
    List<String> exp = new ArrayList<>();
    Stack<String> stack = new Stack<>();
    List<String> rpn = new ArrayList<>();

    for (int i = 0; i < s.length(); ++i) {
      if (Character.isDigit(s.charAt(i))) {
        StringBuilder sb = new StringBuilder();
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
          sb.append(s.charAt(i));
          i++;
        }
        i--; // 很重要
        exp.add(sb.toString());
      } else if (s.charAt(i) == ' ') {
        continue;
      } else {
        exp.add(String.valueOf(s.charAt(i)));
      }
    }

    for (String token : exp) {
      if (!"+-()".contains(token)) {
        rpn.add(token);
      } else if (token.equals("(")) {
        stack.push(token);
      } else if (token.equals(")")) {
        while (!stack.isEmpty() && !stack.peek().equals("(")) {
          rpn.add(stack.pop());
        }
        stack.pop();
      } else {
        while (!stack.isEmpty() && (getPriority(stack.peek()) >= getPriority(token))) {
          rpn.add(stack.pop());
        }
        stack.push(token);
      }
    }

    // 别忘了!
    while (!stack.isEmpty()) {
      rpn.add(stack.pop());
    }

    return rpn;
  }

  public int evaluateRPN(List<String> rpn) {
    Stack<Integer> stack = new Stack<>();

    for (String token : rpn) {
      if (!"+-".contains(token)) {
        stack.push(Integer.parseInt(token));
      } else {
        int op2 = stack.pop(), op1 = stack.pop();
        if (token.equals("+")) {
          stack.push(op1 + op2);
        } else {
          stack.push(op1 - op2);
        }
      }
    }

    return stack.pop();
  }

  public int getPriority(String s) {
    switch (s) {
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
