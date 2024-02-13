[1. 两数之和](https://leetcode-cn.com/problems/two-sum/)

## 解法1：双重循环

```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; ++i) {
            for (int j = i + 1; j < nums.length; ++j) {
                if (nums[i] + nums[j] == target) return new int[]{i, j};
            }
        }
        return null;
    }
}

```

### 复杂度

时间 O(n^2)，空间 O(1)

## 解法2：借助HashMap

维护一个HashMap，存放**数组值**到**数组下标**的映射。

从头到尾遍历数组，对于当前元素`nums[i]`， 检查HashMap中是否存在`target - nums[i]`，若存在，返回`target - nums[i]`对应的下标和`i`；否则，将`nums[i] <-> i`的映射添加到HashMap。

```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        int[] result = new int[2];
        for (int i = 0; i < nums.length; ++i) {
            if (map.containsKey(target - nums[i])) {
                result[0] = map.get(target - nums[i]);
                result[1] = i;
                break;
            }
            map.put(nums[i], i);
        }

        return result;
    }
}
```

### 复杂度

时间O(n)，空间O(n)

## 额外说明

由于该题目中数组不是有序的，所以不适合使用双指针算法，使用双指针算法需要先排序，耗费O(nlogn)时间复杂度；而且还要开辟一个额外数组维护下标，耗费O(n)时间复杂度。