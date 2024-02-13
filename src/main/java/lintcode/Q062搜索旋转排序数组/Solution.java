package lintcode.Q062搜索旋转排序数组;

public class Solution {
    public int search(int[] A, int target) {
        if (A == null || A.length == 0) {
            return -1;
        }

        int start = 0, end = A.length - 1;
        int mid;
        int lastVal = A[end];
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (A[mid] == target) {
                return mid;
            } else if (A[mid] > lastVal) { // 只在区间横跨两部分时才真正有效
                if (target >= A[start] && target <= A[mid]) {
                    end = mid;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target >= A[mid] && target <= A[end]) {
                    start = mid;
                } else {
                    end = mid - 1;
                }
            }
        }

        if (A[start] == target) {
            return start;
        }

        if (A[end] == target) {
            return end;
        }

        return -1;
    }
}
