package Q125验证回文串;

import java.util.ArrayList;
import java.util.List;

public class Solution {
  public boolean isPalindrome(String s) {
    s = s.toLowerCase();
    List<Character> list = new ArrayList<>();
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      if (isAlphaDigit(ch)) {
        list.add(ch);
      }
    }
    int front = 0;
    int end = list.size() - 1;
    while (front < end) {
      if (list.get(front) != list.get(end)) {
        return false;
      }
      front++;
      end--;
    }
    return true;
  }

  private boolean isAlphaDigit(char ch) {
    return (ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'z');
  }

  public static void main(String[] args) {
    System.out.println(new Solution().isPalindrome("A man, a plan, a canal: Panama"));
  }
}
