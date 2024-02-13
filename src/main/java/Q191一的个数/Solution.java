package Q191一的个数;

public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int hm = 0;
        while (n > 0) {
            hm += n & 1;
            n >>= 1;
        }

        return hm;
    }
}