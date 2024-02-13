package jianzhioffer.Q2nd44数字序列中某一位数字;

public class Solution {
  public int findNthDigit(int n) {
    if (n < 0) {
      return 0;
    }

    StringBuilder sb = new StringBuilder();
    int current = 0;
    while (sb.length() < n + 1) {
      sb.append(current);
      current++;
    }

    int diff = sb.length() - (n + 1);
    return sb.charAt(sb.length() - 1 - diff);
  }
}
