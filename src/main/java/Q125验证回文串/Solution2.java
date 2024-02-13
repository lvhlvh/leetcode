package Q125验证回文串;

public class Solution2 {
  // 和反转后的字符串比较
  public boolean isPalindrome(String s) {
    String filteredS = filterNonAlphaNumeric(s);
    return filteredS.equalsIgnoreCase(reverseString2(filteredS));
  }

  private String filterNonAlphaNumeric(String s) {
    // 正则表达式替换很慢
    return s.replaceAll("[^0-9a-zA-Z]", "");
  }

  private String reverseString(String s) {
    return new StringBuilder(s).reverse().toString();
  }

  // 不用内置API, 自己反转字符串: O(n)
  private String reverseString2(String s) {
    char[] chArr = s.toCharArray();
    for (int i = 0, j = chArr.length - 1; i < j; i++, j--) {
      char tmp = chArr[i];
      chArr[i] = chArr[j];
      chArr[j] = tmp;
    }
    return new String(chArr);
  }

  public static void main(String[] args) {
    System.out.println(new Solution2().isPalindrome("A man, a plan, a canal: Panama"));
  }
}
