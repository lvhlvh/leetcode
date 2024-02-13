package Q018四数之和;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        // 别忘了排序!
        Arrays.sort(nums);
        return nSum(nums, 4, 0, target);
    }

    public List<List<Integer>> nSum(int[] nums, int n, int start, int target) {
        List<List<Integer>> res = new LinkedList<>();

        if (n < 2 || nums.length < n) return res;

        if (n == 2) {
            int l = start, r = nums.length - 1;
            while (l < r) {
                int lval = nums[l], rval = nums[r];
                int sum = lval + rval;
                if (sum == target) {
                    List<Integer> entry = new LinkedList<>();
                    entry.add(lval); entry.add(rval);
                    res.add(entry);
                    while (l < r && nums[l] == lval) l++;
                    while (l < r && nums[r] == rval) r--;
                } else if (sum < target) {
                    while (l < r && nums[l] == lval) l++;
                } else {
                    while (l < r && nums[r] == rval) r--;
                }
            }
        } else {
            for (int i = start; i < nums.length; ++i) {
                List<List<Integer>> lists =
                        nSum(nums, n - 1, i + 1, target - nums[i]);

                for (List<Integer> list : lists) {
                    list.add(0, nums[i]);
                    res.add(list);
                }

                while (i < nums.length - 1 && nums[i] == nums[i + 1]) i++;
            }
        }

        return res;
    }
}