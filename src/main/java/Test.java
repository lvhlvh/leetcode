public class Test {
    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums = new int[nums1.length + nums2.length];

        int i = 0, j = 0, k = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] <= nums2[j]) nums[k++] = nums1[i++];
            else nums[k++] = nums2[j++];
        }

        if ((nums.length & 1) == 1) return (double) nums[nums.length >>> 1];
        else return (nums[nums.length >>> 1] * 1.0 + nums[(nums.length >>> 1) - 1]) / 2;
    }
}
