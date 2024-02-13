package Q046全排列;

import java.util.ArrayList;
import java.util.List;

public class Solution {
  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> cur = new ArrayList<>();
    boolean[] used = new boolean[nums.length];
    permute(nums, res, cur, used);
    return res;
  }

  private void permute(int[] nums, List<List<Integer>> res, List<Integer> cur, boolean[] used) {
    if (cur.size() == nums.length) {
      res.add(new ArrayList<>(cur));
      return;
    }

    for (int i = 0; i < nums.length; ++i) {
      if (!used[i]) {
        used[i] = true;
        cur.add(nums[i]);
        permute(nums, res, cur, used);
        cur.remove(cur.size() - 1);
        used[i] = false;
      }
    }
  }
}
