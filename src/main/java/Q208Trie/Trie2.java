package Q208Trie;

import java.util.HashMap;
import java.util.Map;

class Trie2 {

  private class Node {
    private boolean isWordEnd;
    Map<Character, Node> next;

    public Node() {
      this(false);
    }

    public Node(boolean isWordEnd) {
      this.isWordEnd = isWordEnd;
      this.next = new HashMap<>();
    }
  }

  private Node root;

  /** Initialize your data structure here. */
  public Trie2() {
    root = new Node();
  }

  /** Inserts a word into the trie. */
  public void insert(String word) {
    Node cur = root;
    int wordLen = word.length();
    for (int i = 0; i < wordLen; ++i) {
      char ch = word.charAt(i);
      if (cur.next.get(ch) == null) cur.next.put(ch, new Node());
      cur = cur.next.get(ch);
    }

    if (!cur.isWordEnd) cur.isWordEnd = true;
  }

  /** Returns if the word is in the trie. */
  public boolean search(String word) {
    int wordLen = word.length();
    Node cur = root;
    for (int i = 0; i < wordLen; ++i) {
      char ch = word.charAt(i);
      Node chNode = cur.next.get(ch);
      if (chNode == null) return false;
      cur = chNode;
    }

    return cur.isWordEnd;
  }

  /** Returns if there is any word in the trie that starts with the given prefix. */
  public boolean startsWith(String prefix) {
    int prefixLen = prefix.length();
    Node cur = root;
    for (int i = 0; i < prefixLen; ++i) {
      char ch = prefix.charAt(i);
      Node chNode = cur.next.get(ch);
      if (chNode == null) return false;
      cur = chNode;
    }

    return true;
  }
}

/**
 * Your Trie object will be instantiated and called as such: Trie obj = new Trie();
 * obj.insert(word); boolean param_2 = obj.search(word); boolean param_3 = obj.startsWith(prefix);
 */
