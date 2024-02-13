package Q307;

class NumArray2 {
    private SegmentTree<Integer> tree;

    @FunctionalInterface
    private interface Merger<E> {
        /**
         * 定义线段树中如何由一个结点的左右孩子结点融合出该节点的值。
         * 例如：
         * - 是左右结点中的最小值
         * - 是左右结点值之和
         * - ....
         * @param left
         * @param right
         * @return
         */
        E merge(E left, E right);
    }

    private class SegmentTree<E> {
        private E[] data; // 区间元素
        private E[] tree; // 线段树
        private Merger<E> merger; // 如何由一个结点的左右孩子结点的值求出该节点的值

        public SegmentTree(E[] arr, Merger<E> merger) {
            this.merger = merger;
            data = (E[]) new Object[arr.length];
            for (int i = 0; i < arr.length; i++) {
                data[i] = arr[i];
            }

            tree = (E[]) new Object[4 * arr.length];

            if (data.length > 0) {
                buildSegmentTree(0, 0, data.length - 1);
            }
        }

        /**
         * 构建线段树
         * base case: 区间只有一个元素，即 l == r
         * recursion:
         * 对左半个区间[l, mid]建立左子树
         * 对右半个区间[mid + 1, r]建立右子树
         * 树 = 根节点 + 左子树 + 右子树
         *
         * @param treeIndex 线段树中结点的下标
         * @param l         index节点表示区间的左边界
         * @param r         index节点表示区间的右边界
         */
        private void buildSegmentTree(int treeIndex, int l, int r) {
            // base case
            if (l == r) {
                tree[treeIndex] = data[l];
                return;
            }

            // recursion
            int leftChild = leftChild(treeIndex); // 线段树中当前节点(treeIndex)的左孩子下标
            int rightChild = rightChild(treeIndex); // 线段树中当前节点(treeIndex)的右孩子下标
            int mid = l + (r - l) / 2;
            buildSegmentTree(leftChild, l, mid);
            buildSegmentTree(rightChild, mid + 1, r);

            tree[treeIndex] = merger.merge(tree[leftChild], tree[rightChild]);
        }

        /**
         * 查询区间[queryL, queryR]的指标值(之和，最小值，最大值...)
         *
         * @param queryL 区间左边界 0 <= queryL <= queryR <= data.length - 1
         * @param queryR 区间右边界 0 <= queryL <= queryR <= data.length - 1
         * @return 区间[queryL, queryR]的指标值(之和，最小值，最大值...)
         */
        public E query(int queryL, int queryR) {
            if (queryL < 0 || queryL >= data.length || queryR < 0 || queryR >= data.length || queryL > queryR) {
                throw new IllegalArgumentException("查询区间错误!");
            }

            return query(0, 0, data.length - 1, queryL, queryR);
        }

        /**
         * @param treeIndex 线段树中结点的下标
         * @param l         treeIndex节点表示区间的左边界
         * @param r         treeIndex节点表示区间的右边界
         * @param queryL    查询区间的左边界
         * @param queryR    查询区间的右边界
         */
        private E query(int treeIndex, int l, int r, int queryL, int queryR) {
            // base case
            if (l == queryL && r == queryR) {
                return tree[treeIndex];
            }

            // recursion
            int mid = l + (r - l) / 2;
            int leftChild = leftChild(treeIndex);
            int rightChild = rightChild(treeIndex);
            if (queryR <= mid) { // 区间全在左半部分
                return query(leftChild, l, mid, queryL, queryR);
            } else if (queryL > mid) { // 区间全在右半部分
                return query(rightChild, mid + 1, r, queryL, queryR);
            } else { // 区间横跨左右两部分
                return merger.merge(
                        query(leftChild, l, mid, queryL, mid),
                        query(rightChild, mid + 1, r, mid + 1, queryR)
                );
            }
        }

        /**
         * 更新区间index处的值为val
         *
         * @param index 区间某元素的下标
         * @param val   新的值
         */
        public void set(int index, E val) {
            set(0, 0, data.length - 1, index, val);
        }

        private void set(int treeIndex, int l, int r, int index, E val) {
            if (l == r) {
                tree[treeIndex] = val;
                return;
            }

            int mid = l + (r - l) / 2;
            int leftChild = leftChild(treeIndex);
            int rightChild = rightChild(treeIndex);
            if (index <= mid) {
                set(leftChild, l, mid, index, val);
            } else {
                set(rightChild, mid + 1, r, index, val);
            }

            tree[treeIndex] = merger.merge(tree[leftChild], tree[rightChild]);
        }


        /**
         * 获取区间中index位置的元素
         *
         * @param index
         * @return
         */
        public E get(int index) {
            if (index < 0 || index >= data.length) {
                throw new IllegalArgumentException("Index is error.");
            }
            return data[index];
        }

        /**
         * 获取区间长度（元素个数）
         *
         * @return 区间长度
         */
        public int getSize() {
            return data.length;
        }

        /**
         * 求线段树中索引为index的结点的左孩子的索引 (线段树是满二叉树)
         *
         * @param index
         * @return
         */
        private int leftChild(int index) {
            return 2 * index + 1;
        }

        private int rightChild(int index) {
            return 2 * index + 2;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            for (int i = 0; i < tree.length; i++) {
                if (tree[i] != null) {
                    sb.append(tree[i]);
                } else {
                    sb.append("null");
                }

                if (i != tree.length - 1) {
                    sb.append(", ");
                }
            }
            sb.append("]");
            return sb.toString();
        }
    }

    public NumArray2(int[] nums) {
        int numsLen = nums.length;
        Integer[] newNums = new Integer[numsLen];
        for (int i = 0; i < numsLen; ++i) {
            newNums[i] = Integer.valueOf(nums[i]);
        }
        tree = new SegmentTree<>(newNums, (a, b) -> a + b);
    }

    public void update(int i, int val) {
        tree.set(i, val);
    }

    public int sumRange(int i, int j) {
        return tree.query(i, j);
    }
}
