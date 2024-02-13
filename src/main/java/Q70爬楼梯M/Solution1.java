package Q70爬楼梯M;

/**
 * https://leetcode-cn.com/problems/climbing-stairs/
 * 递归
 */
public class Solution1 {

    /**
     * 画调用树可以看出来: 数的深度是(n-2)+1, 即n-1, 所以树的节点大约2^n级别, 即复杂度为O(2^n)
     * <br> 性能太差!!! 提交超出时间限制!!!
     */
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }

        return climbStairs(n - 1) + climbStairs(n - 2);
    }
}
