package Q208Trie;

class Trie {
    private static class Node {
        private boolean isWordEnd;
        private Node[] next;

        public Node() {
            this(false);
        };

        public Node(boolean isWordEnd) {
            this.isWordEnd = isWordEnd;
            this.next = new Node[26];
        }
    }

    private Node root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new Node();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        int wordLen = word.length();
        Node cur = root;
        for (int i = 0; i < wordLen; ++i) {
            char ch = word.charAt(i);
            if (cur.next[ch - 'a'] == null)
                cur = cur.next[ch - 'a'] = new Node();
//            cur = cur.next[ch - 'a'];
        }

        if (!cur.isWordEnd) {
            cur.isWordEnd = true;
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        int wordLen = word.length();
        Node cur = root;
        for (int i = 0; i < wordLen; ++i) {
            char ch = word.charAt(i);
            if (cur.next[ch - 'a'] == null)
                return false;
            cur = cur.next[ch - 'a'];
        }

        return cur.isWordEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        int prefixLen = prefix.length();
        Node cur = root;
        for (int i = 0; i < prefixLen; ++i) {
            char ch = prefix.charAt(i);
            if (cur.next[ch - 'a'] == null)
                return false;
            cur = cur.next[ch - 'a'];
        }

        return true;
    }
}

/*
  Your Trie object will be instantiated and called as such:
  Trie obj = new Trie();
  obj.insert(word);
  boolean param_2 = obj.search(word);
  boolean param_3 = obj.startsWith(prefix);
 */