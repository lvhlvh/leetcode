package Q120三角形最小路径和;

import java.util.List;

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0) return 0;

        return minimumTotal(triangle, -1, 0);
    }

    private int minimumTotal(List<List<Integer>> triangle, int lastLevelIndex, int currentLevel) {
        if (currentLevel >= triangle.size())
            return 0;

        int min, minIndex;
        if (currentLevel == 0) {
            min = triangle.get(0).get(0);
            minIndex = 0;
        } else {
            int left = triangle.get(currentLevel).get(lastLevelIndex);
            int right = triangle.get(currentLevel).get(lastLevelIndex + 1);
            if (left <= right) {
                minIndex = lastLevelIndex;
                min = left;
            } else {
                minIndex = lastLevelIndex + 1;
                min = right;
            }
        }

        return min + minimumTotal(triangle, minIndex, currentLevel + 1);
    }
}