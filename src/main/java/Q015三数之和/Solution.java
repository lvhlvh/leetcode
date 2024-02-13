package Q015三数之和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();

    Arrays.sort(nums);
    for (int i = 0; i < nums.length; ++i) {
      int target = 0 - nums[i];

      List<List<Integer>> twoSums = twoSum(nums, i + 1, target);
      for (List<Integer> twoSum : twoSums) {
        List<Integer> entry = new ArrayList<>();
        entry.add(nums[i]);
        entry.addAll(1, twoSum);
        res.add(entry);
      }

      // 跳过开头重复的
      while (i < nums.length - 1 && nums[i] == nums[i + 1]) i++;
    }

    return res;
  }

  public List<List<Integer>> twoSum(int[] nums, int index, int target) {
    List<List<Integer>> res = new ArrayList<>();

    int l = index, r = nums.length - 1;
    while (l < r) {
      int lval = nums[l], rval = nums[r];
      int sum = lval + rval;
      if (sum == target) {
        res.add(Arrays.asList(nums[l], nums[r]));
        l++;
        r--;
        // 已经选过了(如果值还相同的话)
        while (l < r && nums[l] == lval) l++;
        while (l < r && nums[r] == rval) r--;
      } else if (sum < target) {
        l++;
        // 已经确定左值不满足了
        while (l < r && nums[l] == lval) l++;
      } else {
        r--;
        // 已经确定右值不满足了
        while (l < r && nums[r] == rval) r--;
      }
    }

    return res;
  }
}
