package Q804;

import java.util.Set;
import java.util.TreeSet;

class Solution {
  private String[] morseCodes = {
    ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--",
    "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."
  };

  public int uniqueMorseRepresentations(String[] words) {
    Set<String> set = new TreeSet<>(); // 红黑树
    for (String word : words) {
      StringBuilder sb = new StringBuilder();
      for (char ch : word.toCharArray()) {
        sb.append(morseCodes[ch - 'a']);
      }
      set.add(sb.toString());
    }
    return set.size();
  }

  public static void main(String[] args) {
    String[] words = {"gin", "zen", "gig", "msg"};
    System.out.println(new Solution().uniqueMorseRepresentations(words));
  }
}
