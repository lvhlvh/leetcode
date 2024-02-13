package jianzhioffer.Q36二叉树与双向链表;

public class Solution {
    public Node treeToDoublyList(Node root) {
        return treeToDoublyListHelper(root);
    }

    private Node treeToDoublyListHelper(Node node) {
        if (node == null) {
            return null;
        }

        Node leftList = treeToDoublyListHelper(node.left);
        Node rightList = treeToDoublyListHelper(node.right);
        node.left = node.right = node;

        return concatList(concatList(leftList, node), rightList);
    }

    // 拼接两个双向循环链表
    private Node concatList(Node a, Node b) {
        if (a == null) return b;
        if (b == null) return a;

        Node aEnd = a.left;
        Node bEnd = b.left;
        a.left = bEnd;
        bEnd.right = a;
        aEnd.right = b;
        b.left = aEnd;

        return a;
    }
}
