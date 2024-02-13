package Q215第K个最大的元素;

import java.util.Random;

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        // 第k大等价于第nums.length - k + 1小
        return quickSelect(nums, 0, nums.length - 1, nums.length - k + 1);
    }

    private int quickSelect(int[] nums, int l, int r, int k) {
        if (l == r) return nums[l];

        int pivotIndex = partition(nums, l, r);

        // pivotIndex前面的都小于pivot, 且pivotIndex处的元素在它的最终位置
        int ord = pivotIndex - l + 1;
        if (ord == k) {
            return nums[pivotIndex];
        } else if (ord < k) {
            return quickSelect(nums, pivotIndex + 1, r, k - ord);
        } else {
            return quickSelect(nums, l, pivotIndex - 1, k);
        }
    }

    private int partition(int[] nums, int l, int r) {
        Random random = new Random();
        int index = l + random.nextInt(r - l + 1);
        int pivot = nums[index];
        swap(nums, index, r);
        int pivotIndex = l;

        for (int i = l; i < r; ++i) {
            if (nums[i] < pivot) {
                swap(nums, i, pivotIndex++);
            }
        }
        swap(nums, pivotIndex, r);

        return pivotIndex;
    }


    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
