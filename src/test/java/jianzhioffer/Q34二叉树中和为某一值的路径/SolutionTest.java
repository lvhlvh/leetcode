package jianzhioffer.Q34二叉树中和为某一值的路径;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;


class SolutionTest {

    private TreeNode tree;

    @BeforeEach
    void init() {
        TreeNode levelFour1 = new TreeNode(7);
        TreeNode levelFour2 = new TreeNode(2);
        TreeNode levelFour3 = new TreeNode(5);
        TreeNode levelFour4 = new TreeNode(1);

        TreeNode levelTree1 = new TreeNode(11, levelFour1, levelFour2);
        TreeNode levelTree2 = new TreeNode(13);
        TreeNode levelTree3 = new TreeNode(4, levelFour3, levelFour4);

        TreeNode levelTwo1 = new TreeNode(4, levelTree1 ,null);
        TreeNode levelTwo2 = new TreeNode(8, levelTree2 ,levelTree3);

        tree = new TreeNode(5, levelTwo1, levelTwo2);
    }

    @Test
    void getAllPaths() {
        List<List<Integer>> paths = new Solution().getAllPaths(tree);
        for (List<Integer> path : paths) {
            System.out.println(path);
        }
    }
}