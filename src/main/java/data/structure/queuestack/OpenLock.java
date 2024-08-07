package data.structure.queuestack;

import java.util.*;

/**
 * https://leetcode.com/explore/learn/card/queue-stack/231/practical-application-queue/1375/
 *
 * Time Complexity: O(1)
 * Space Complexity: O(deadends.length)
 */
public class OpenLock {
    public int openLock(String[] deadends, String target) {
        Set<String> deads = new HashSet<>(Arrays.asList(deadends));
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        queue.offer("0000");
        visited.add("0000");
        int turns = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String node = queue.poll();
                if (deads.contains(node)) continue;
                if (node.equals(target)) return turns;

                for (int j = 0; j < 4; j++) {
                    for (int d = -1; d <= 1; d += 2) {
                        char[] chars = node.toCharArray();
                        chars[j] = (char) (((chars[j] - '0') + d + 10) % 10 + '0');
                        String neighbor = new String(chars);
                        if (!visited.contains(neighbor)) {
                            queue.offer(neighbor);
                            visited.add(neighbor);
                        }
                    }
                }
            }
            turns++;
        }
        return -1;
    }

    public static void main(String[] args) {
        OpenLock solution = new OpenLock();
        int result = solution.openLock(new String[]{"0201","0101","0102","1212","2002"}, "0202");
        System.out.println(result);
    }
}
