package Q307;

class NumArray3 {

  private class SegmentTreeLinked {
    private class Node {
      public int data;
      public int start, end;
      public Node left, right;

      public Node() {
        this(-1, -1, -1, null, null);
      }

      public Node(int data, int start, int end) {
        this(data, start, end, null, null);
      }

      public Node(int data, int start, int end, Node left, Node right) {
        this.data = data;
        this.start = start;
        this.end = end;
        this.left = left;
        this.right = right;
      }

      @Override
      public String toString() {
        return String.valueOf(data);
      }
    }

    private Node root;
    private int[] data;

    public SegmentTreeLinked(int[] arr) {
      data = arr;
      if (data.length > 0) {
        root = buildSegmentTreeLinked(root, 0, data.length - 1);
      } else {
        root = null;
      }
    }

    /**
     * 构建线段树
     *
     * @param node 结点
     * @param l 区间左index
     * @param r 区间右index
     * @return
     */
    private Node buildSegmentTreeLinked(Node node, int l, int r) {
      if (l == r) {
        return new Node(data[l], l, l);
      }

      int mid = l + (r - l) / 2;
      node = new Node(-1, l, r);
      node.left = buildSegmentTreeLinked(node.left, l, mid);
      node.right = buildSegmentTreeLinked(node.right, mid + 1, r);
      node.data = node.left.data + node.right.data;
      return node;
    }

    public int query(int queryL, int queryR) {
      int dataLen = data.length;
      if (queryL < 0 || queryL >= dataLen || queryR < 0 || queryR >= dataLen || queryL > queryR)
        throw new IllegalArgumentException("查询区间非法");
      return query(root, queryL, queryR);
    }

    private int query(Node node, int queryL, int queryR) {
      if (node == null) {
        return -1;
      }

      if (node.start == queryL && node.end == queryR) {
        return node.data;
      }

      int mid = node.start + (node.end - node.start) / 2;
      if (queryR <= mid) {
        return query(node.left, queryL, queryR);
      } else if (queryL > mid) {
        return query(node.right, queryL, queryR);
      } else {

        return query(node.left, queryL, mid) + query(node.right, mid + 1, queryR);
      }
    }

    public void set(int index, int val) {
      set(root, index, val);
    }

    private void set(Node node, int index, int val) {
      if (node == null) {
        return;
      }

      if (node.start == node.end && node.start == index) {
        node.data = val;
        return;
      }

      int mid = node.start + (node.end - node.start) / 2;
      if (index <= mid) {
        set(node.left, index, val);
      } else {
        set(node.right, index, val);
      }
      node.data = node.left.data + node.right.data;
    }
  }

  private SegmentTreeLinked tree;

  public NumArray3(int[] nums) {
    tree = new SegmentTreeLinked(nums);
  }

  public void update(int i, int val) {
    tree.set(i, val);
  }

  public int sumRange(int i, int j) {
    return tree.query(i, j);
  }
}
