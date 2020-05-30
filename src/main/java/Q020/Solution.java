package Q020;

import java.util.*;

class Solution {
	private Map<Character, Character> bracketMap;

	public Solution() {
		bracketMap = new HashMap<>();
		bracketMap.put('(',')');
		bracketMap.put('{','}');
		bracketMap.put('[',']');
	}

	public boolean isValid2(String s) {
		Stack<Character> stack = new Stack<>();
        for (int i=0; i < s.length(); ++i) {
        	Character c = s.charAt(i);

        	if (bracketMap.containsKey(c)) { // 左括号
        		stack.push(c);
        	} else { // 右括号
        		Character topChar = stack.empty() ? '#' : stack.pop();
        		if (bracketMap.get(topChar) != c) return false;
        	}
        }

        if (stack.empty()) {
        	return true;
        } else {
        	return false;
        }
	}


    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i=0; i < s.length(); ++i) {
        	Character c = s.charAt(i);

        	if (c == '(' || c == '{' || c == '[') { // 左括号
        		stack.push(c);
        	} else { // 右括号
        		if (stack.empty()) return false;

        		Character topChar = stack.pop();
        		if (c == ')' && topChar != '(') return false;
        		if (c == '}' && topChar != '{') return false;
        		if (c == ']' && topChar != '[') return false;
        	}
        }

        if (stack.empty()) {
        	return true;
        } else {
        	return false;
        }
    }



    public static void main(String[] args) {
    	while (true) {
    		Scanner scanner = new Scanner(System.in);
    		String s = scanner.nextLine();
    		System.out.println(new Solution().isValid(s));
    	}
    }
}