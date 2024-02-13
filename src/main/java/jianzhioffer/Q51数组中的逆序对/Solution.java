package jianzhioffer.Q51数组中的逆序对;

public class Solution {
  private int pairCount = 0;

  public int reversePairs(int[] nums) {
    mergeSort(nums, 0, nums.length - 1);
    return pairCount;
  }

  private void mergeSort(int[] nums, int l, int r) {
    if (l >= r) return;

    int mid = l + (r - l) / 2;
    mergeSort(nums, l, mid);
    mergeSort(nums, mid + 1, r);

    int[] tmp = new int[r - l + 1];
    int i = l, j = mid + 1, k = 0;
    while (i <= mid && j <= r) {
      if (nums[i] <= nums[j]) {
        tmp[k++] = nums[i++];
      } else {
        tmp[k++] = nums[j++];
        pairCount += (mid - i + 1);
      }
    }
    while (i <= mid) {
      tmp[k++] = nums[i++];
    }
    while (j <= r) {
      tmp[k++] = nums[j++];
    }
    for (i = l, j = 0; i <= r; ++i, ++j) {
      nums[l] = tmp[j];
    }
  }
}
