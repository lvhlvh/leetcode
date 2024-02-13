package jianzhioffer.Q38字符串的排列;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public String[] permutation(String s) {
        List<String> resultList = new ArrayList<>();

        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        boolean[] used = new boolean[chars.length];
        List<Character> permutation = new ArrayList<>();
        permutationHelper(chars, used, permutation, resultList);

        String[] result = new String[resultList.size()];
        for (int i = 0; i < resultList.size(); ++i) {
            result[i] = resultList.get(i);
        }
        return result;
    }
    

    private void permutationHelper(char[] chars, boolean[] used, List<Character> permutation, List<String> resultList) {
        if (permutation.size() == chars.length) {
            resultList.add(charListToString(permutation));
            return;
        }

        for (int i = 0; i < chars.length; ++i) {
            if (!used[i]) {
                if (i > 0 && chars[i] == chars[i-1] && !used[i-1]) {
                    continue;
                }

                permutation.add(chars[i]);
                used[i] = true;
                permutationHelper(chars, used, permutation, resultList);
                permutation.remove(permutation.size() - 1);
                used[i] = false;
            }
        }
    }

    private String charListToString(List<Character> permutation) {
        StringBuffer sb = new StringBuffer();
        for (Character ch : permutation) {
            sb.append(ch);
        }
        return sb.toString();
    }
}