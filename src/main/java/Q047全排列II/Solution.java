package Q047全排列II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
  List<List<Integer>> result;

  /** 与全排列题目不同的是，这里每次选择不选重复的即可 (例如选第一个数时，可以选1, 2, 而不是1, 1, 2) */
  public List<List<Integer>> permuteUnique(int[] nums) {
    result = new ArrayList<>();
    if (nums == null || nums.length == 0) return result;

    // 先对nums排序，方便剪枝/去重
    Arrays.sort(nums);

    boolean[] used = new boolean[nums.length];
    List<Integer> list = new ArrayList<>();
    backtrack(nums, list, used);

    return result;
  }

  private void backtrack(int[] nums, List<Integer> list, boolean[] used) {
    if (list.size() == nums.length) {
      result.add(new ArrayList<>(list));
      return;
    }

    for (int i = 0; i < nums.length; ++i) {
      if (used[i]) continue;
      // 最关键的地方在这: 剪枝
      if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;

      used[i] = true;
      list.add(nums[i]);
      backtrack(nums, list, used);
      list.remove(list.size() - 1);
      used[i] = false;
    }
  }
}
