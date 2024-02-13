package Q752打开转盘锁;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution {
  public int openLock(String[] deadends, String target) {
    Queue<String> q = new LinkedList<>();
    Set<String> visited = new HashSet<>();
    // 防止每次都遍历deadends数组进行寻找，以空间换时间，可以在O(1)时间复杂度内找到
    Set<String> deadendsSet = new HashSet<>();
    for (String d : deadends) deadendsSet.add(d);

    q.offer("0000");
    visited.add("0000");
    int step = 0;

    while (!q.isEmpty()) {
      int sz = q.size();
      for (int i = 0; i < sz; ++i) {
        String tmp = q.poll();
        if (tmp.equals(target)) return step;
        for (int j = 0; j < 4; ++j) {
          String next = turnGreater(tmp, j);
          String previous = turnSmaller(tmp, j);
          if (!deadendsSet.contains(next) && !visited.contains(next)) {
            q.offer(next);
            visited.add(next);
          }
          if (!deadendsSet.contains(previous) && !visited.contains(previous)) {
            q.offer(previous);
            visited.add(previous);
          }
        }
      }
      step++;
    }

    return -1;
  }

  private String turnGreater(String m, int index) {
    char[] chs = m.toCharArray();
    if (chs[index] == '9') chs[index] = '0';
    else chs[index]++;
    return new String(chs);
  }

  private String turnSmaller(String m, int index) {
    char[] chs = m.toCharArray();
    if (chs[index] == '0') chs[index] = '9';
    else chs[index]--;
    return new String(chs);
  }
}
