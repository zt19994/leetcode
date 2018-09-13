package Learn.queue;

import java.util.*;

/**
 * 开锁 使用BFS
 *
 * @author zhongtao on 2018/8/29
 */
public class OpenLock {

    /**
     * 容易理解
     * @param deadends
     * @param target
     * @return
     */
    public int openLock(String[] deadends, String target) {
        Queue<String> queue = new LinkedList<>();
        // 无效的死亡密码
        Set<String> deads = new HashSet<>(Arrays.asList(deadends));
        //  处理过的密码
        Set<String> visited = new HashSet<>();
        queue.add("0000");
        visited.add("0000");
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                String cur = queue.poll();
                if (deads.contains(cur)) {
                    size--;
                    continue;
                }
                if (Objects.equals(cur, target)) {
                    return level;
                }
                StringBuilder builder = new StringBuilder(cur);
                // 每个密码移动一位
                for (int i = 0; i < 4; i++) {
                    char c = builder.charAt(i);
                    String s1 = builder.substring(0, i) + (c == '9' ? 0 : c - '0' + 1) + builder.substring(i + 1);
                    String s2 = builder.substring(0, i) + (c == '0' ? 9 : c - '0' - 1) + builder.substring(i + 1);
                    //比较密码是否处理过或无效
                    if (!deads.contains(s1) && !visited.contains(s1)) {
                        queue.add(s1);
                        visited.add(s1);
                    }
                    if (!deads.contains(s2) && !visited.contains(s2)) {
                        queue.add(s2);
                        visited.add(s2);
                    }
                }
                size--;
            }
            level++;
        }
        return -1;
    }


    /**
     * 使用set来存在访问过的密码
     */
    public int openLock1(String[] deadends, String target) {
        Set<String> deads = new HashSet<>(Arrays.asList(deadends));
        Set<String> begin = new HashSet<>();
        Set<String> end = new HashSet<>();
        begin.add("0000");
        end.add(target);
        int level = 0;
        while (!end.isEmpty() && !begin.isEmpty()) {
            Set<String> temp = new HashSet<>();
            for (String s : begin) {
                if (end.contains(s)) {
                    return level;
                }
                if (deads.contains(s)) {
                    continue;
                }
                deads.add(s);
                StringBuilder stringBuilder = new StringBuilder(s);
                for (int i = 0; i < 4; i++) {
                    char c = stringBuilder.charAt(i);
                    String s1 = stringBuilder.substring(0, i) + (c == '9' ? 0 : c - '0' + 1) + stringBuilder.substring(i + 1);
                    String s2 = stringBuilder.substring(0, i) + (c == '0' ? 9 : c - '0' - 1) + stringBuilder.substring(i + 1);
                    if (!deads.contains(s1)) {
                        temp.add(s1);
                    }
                    if (!deads.contains(s2)) {
                        temp.add(s2);
                    }
                }
            }
            level++;
            begin = end;
            end = temp;
        }
        return -1;
    }


    /**
     * 高效率的
     */
    public int openLock2(String[] deadends, String target) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[10000];
        for (String deadend : deadends)
            visited[Integer.parseInt(deadend)] = true;

        int step = 0;
        if (!visited[0]) {
            queue.offer(0);
            visited[0] = true;
        }
        int targetNum = Integer.parseInt(target);

        while (!queue.isEmpty()) {
            for (int i = 0, end = queue.size(); i < end; i++) {
                int num = queue.poll();
                if (num == targetNum) {
                    return step;
                }

                int pow = 1;
                for (int j = 0; j < 4; j++) {
                    addToQueue(queue, visited, num, pow, 1);
                    addToQueue(queue, visited, num, pow, -1);
                    //改变位数
                    pow *= 10;
                }
            }
            step++;
        }
        return -1;
    }

    /**
     * 添加到队列
     */
    public void addToQueue(Queue<Integer> queue, boolean[] visited, int num, int pow, int dir) {
        int nextNum = increment(num, pow, dir);
        if (!visited[nextNum]) {
            queue.offer(nextNum);
            visited[nextNum] = true;
        }
    }

    // consider 9+1, we don't want a 10 as it affects other digits with a carry over, so we do 9-9 instead;
    // also consider 0 - 1, we want a 9 without affect other digits, so we do 0+9;
    // otherwise we should just increment or decrement by 1*pow
    public int increment(int num, int pow, int dir) {
        //获取当前位数字
        int d = (num / pow) % 10;
        int t = 1;
        //处理边界
        if (d + dir >= 10 || d + dir < 0) {
            dir = -dir;
            t = 9;
        }
        return num + pow * t * dir;
    }

}
