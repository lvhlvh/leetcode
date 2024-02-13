package Q150逆波兰表达式求值;

import java.util.Stack;

public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < tokens.length; ++i) {
            String s = tokens[i];
            if (!"+-*/".contains(s)) { // 注意数字有可能有多位
                stack.push(Integer.parseInt(s));
            } else {
                int result = 0;
                int op2 = stack.pop(), op1 = stack.pop();
                switch (s) {
                    case "+":
                        result = op1 + op2;
                        break;
                    case "-":
                        result = op1 - op2;
                        break;
                    case "*":
                        result = op1 * op2;
                        break;
                    case "/":
                        result = op1 / op2;
                        break;
                    default:
                        break;
                }
                stack.push(result);
            }
        }

        return stack.pop();
    }
}
