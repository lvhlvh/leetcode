package Q125验证回文串;

public class Solution3 {
    public boolean isPalindrome(String s) {
        if (s.isEmpty()) {
            return true;
        }

        int head = 0;
        int tail = s.length() - 1;
        // O(n)
        while (head < tail) {
            // 一次只移动一个指针一步
            char chHead = s.charAt(head);
            char chTail = s.charAt(tail);
            if (!Character.isLetterOrDigit(chHead)) {
                head++;
            } else {
                if (!Character.isLetterOrDigit(chTail)) {
                    tail--;
                } else {
                    // 都是字母
                    if (Character.toLowerCase(chHead) != Character.toLowerCase(chTail)) {
                        return false;
                    }
                    head++;
                    tail--;
                }
            }
        }
        return true;
    }

}
