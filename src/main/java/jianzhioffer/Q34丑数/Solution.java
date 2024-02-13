package jianzhioffer.Q34丑数;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int nthUglyNumber(int n) {
        if (n <= 0)  return -1;

        List<Integer> uglyNums = new ArrayList<>();
        for (int i = 1; i <= Integer.MAX_VALUE; i *= 2) {
            for (int j = i; j <= Integer.MAX_VALUE; j *= 3) {
                for (int k = j; k <= Integer.MAX_VALUE; k *= 5) {
                    uglyNums.add(k);
                }
            }
        }

        uglyNums.sort((o1, o2) -> o1 - o2);
        return uglyNums.get(n - 1);
    }
}
