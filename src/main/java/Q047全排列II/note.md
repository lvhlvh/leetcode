
该题目与[46.全排列](https://leetcode-cn.com/problems/permutations/)的区别在于**给定的数组存在重复元素**，
且要求**最终生成的排列不包含重复的排列**。

解答该问题的关键在于如何**确保不生成重复的排列**。

先看代码:

```java
 class Solution {
    List<List<Integer>> result;

    /**
     *   与全排列题目不同的是，这里每次选择不选重复的即可
     *   (例如选第一个数时，可以选1, 2, 而不是1, 1, 2)
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        result = new ArrayList<>();
        if (nums == null || nums.length == 0)   return result;

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
            if (i > 0 && nums[i] == nums[i-1] && !used[i - 1]) continue;

            used[i] = true;
            list.add(nums[i]);
            backtrack(nums, list, used);
            list.remove(list.size() - 1);
            used[i] = false;
        }
    }
}
```

确保不生成重复的排列的要点有2::

(1) 先对数组排序: `Arrays.sort(nums)`

(2) 如何剪枝确保不会出现重复的排列，上述代码中最核心的部分就是下面的剪枝代码:

```java
if (i > 0 && nums[i] == nums[i-1] && !used[i - 1]) continue;
```

可以参考下面的图来理解这句代码:

![](https://pic.leetcode-cn.com/0f1c183ceb7b634f8a527028afd4893e26dfe3796afce35cbb177b125939179b-LeetCode%20%E7%AC%AC%2047%20%E9%A2%98%EF%BC%9A%E2%80%9C%E5%85%A8%E6%8E%92%E5%88%97%20II%E2%80%9D%E9%A2%98%E8%A7%A3%E9%85%8D%E5%9B%BE.png)


`i > 0 && nums[i] == nums[i-1] && !used[i - 1]` 条件如果成立，说明树中**当前层次**已经存在**值相同的分支**了，因此跳过此次循环。

* `nums[i] == nums[i-1]`只能保证值相等，不能保证在同一层次。例如上图中从左往右第一条分支中，第3层有`nums[i] == nums[i-1]`，但是`nums[i-1]`
位于第2层，因此`nums[i]`也是可以选择的

* `!used[i-1]` 确保 `nums[i]` 和 `nums[i-1]` 位于同一层次，根据回溯的遍历过程，如果位于同一层，那么走到`nums[i]`时，之前选择的`nums[i-1]`已经撤销了，
所以`used[i-1]`为false


参考 https://leetcode-cn.com/problems/permutations-ii/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liwe-2/