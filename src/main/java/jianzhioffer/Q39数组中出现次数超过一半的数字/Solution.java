package jianzhioffer.Q39数组中出现次数超过一半的数字;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
  public int majorityElement(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();

    int n = nums.length;
    for (int num : nums) {
      map.merge(num, 1, Integer::sum);
      if (map.get(num) > n / 2) {
        return num;
      }
    }

    return -1;
  }

  public int majorityElement2(int[] nums) {
    Arrays.sort(nums);
    return nums[nums.length / 2];
  }

  public int majorityElement3(int[] nums) {
    return quickSearch(nums, 0, nums.length - 1, nums.length / 2);
  }

  private int quickSearch(int[] nums, int from, int to, int mid) {
    int pivotIndex = partition(nums, from, to);
    if (pivotIndex == mid) {
      return nums[pivotIndex];
    }

    return pivotIndex > mid
        ? quickSearch(nums, from, pivotIndex - 1, mid)
        : quickSearch(nums, pivotIndex + 1, to, mid);
  }

  private int partition(int[] nums, int from, int to) {
    int pivot = nums[to];
    int pivotIndex = from;

    for (int i = from; i < to; ++i) {
      if (nums[i] <= pivot) {
        swap(nums, i, pivotIndex++);
      }
    }

    swap(nums, pivotIndex, to);
    return pivotIndex;
  }

  private void swap(int[] nums, int i, int j) {
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }
}
