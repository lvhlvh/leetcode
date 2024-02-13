package Q239滑动窗口的最大值;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int left = 0, right = 0;
        int[] maxNums = new int[nums.length - k + 1];
        // 存下标
        Deque<Integer> deque = new LinkedList<>();

        int i = 0;
        while (right < nums.length) {
            int num1 = nums[right];

            while (!deque.isEmpty() && deque.getFirst().compareTo(left) < 0)
                left++;
            while (!deque.isEmpty() && nums[deque.getLast()] <= num1)
                deque.removeLast();
            deque.addLast(right);
            right++;

            if (right < k) continue;

            maxNums[i++] = nums[deque.getFirst()];
            left++;
        }

        return maxNums;
    }
}
