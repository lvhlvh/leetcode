package Q300最长上升子序列;

import java.util.Arrays;

/**
 * 递归 + 记忆化 (自顶向下)
 *
 * 直接求整个数组的LIS不好求，我们可以分别求出 “以num[i]结尾的数组的LIS (i = 0...n-1), 记作lis[i]”，
 * 然后求出这n个LIS中的最值即可。
 *
 * (显然lis[i]的初始值应该是1, 因为以nums[i]结尾的LIS至少长度为1)
 *
 * 如何求以nums[i]结尾的LIS的值lis[i]呢? 显然可以用递归来实现。
 *
 * lis[i] 可以由子问题 lis[j] (j < i) 得到, 它们之间的关系是:
 *      lis[i] = max(lis[j] + 1), j = 0,...,i-1
 *
 * 我们可以将求lis[i]的任务抽象成一个方法helper(i), helper(i)递归调用helper(j), j=0,...,n-1
 * 并求最值即可。
 *
 * 显然这是一种 “自顶向下” 的方法。
 *
 * 为了防止重复的递归调用, 下面代码中引入了一个mark标记, mark[i]用于标记lis[i]是否已经计算过了。
 *
 * 时间复杂度为 O(n^2): helper的调用次数为O(n)级别, 每次调用helper(i)需要遍历j=0,...,i-1的lis[j]
 * 寻找最大值, 因此每次操作数一次为1, 2, 3, ..., n-1, 所以时间复杂度为 O(n^2)
 */
public class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int[] lis = new int[nums.length]; // 以nums[i]结尾的最长上升子序列的长度
        boolean[] mark = new boolean[nums.length];
        Arrays.fill(lis, 1);
        for (int i = 0; i < nums.length; ++i) {
            helper(nums, i, lis, mark);
        }

        return max(lis);
    }

    private void helper(int[] nums, int i, int[] lis, boolean[] mark) {
        if (mark[i]) return;

        System.out.println("helper " + i);

        if (i == 0) {
            lis[i] = 1;
            mark[i] = true;
            return;
        }

        for (int j = 0; j < i; ++j) {
            if (nums[i] > nums[j]) {
                helper(nums, j, lis, mark);
                lis[i] = Math.max(lis[i], lis[j] + 1);
            }
        }

        mark[i] = true;
    }

    private int max(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num > max)
                max = num;
        }

        return max;
    }
}