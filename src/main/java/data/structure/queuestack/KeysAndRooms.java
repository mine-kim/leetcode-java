package data.structure.queuestack;

import java.util.*;

/**
 * https://leetcode.com/explore/learn/card/queue-stack/239/conclusion/1391/
 *
 * Example 1:
 *
 * Input: rooms = [[1],[2],[3],[]]
 * Output: true
 * Explanation:
 * We visit room 0 and pick up key 1.
 * We then visit room 1 and pick up key 2.
 * We then visit room 2 and pick up key 3.
 * We then visit room 3.
 * Since we were able to visit every room, we return true.
 *
 * Example 2:
 *
 * Input: rooms = [[1,3],[3,0,1],[2],[0]]
 * Output: false
 * Explanation: We can not enter room number 2 since the only key that unlocks it is in that room.
 *
 *
 * Constraints:
 *
 * n == rooms.length
 * 2 <= n <= 1000
 * 0 <= rooms[i].length <= 1000
 * 1 <= sum(rooms[i].length) <= 3000
 * 0 <= rooms[i][j] < n
 * All the values of rooms[i] are unique.
 *
 */
public class KeysAndRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(0);
        visited[0]=true;

        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size-->0) {
                int v=queue.poll();
                for(int edge:rooms.get(v)) {
                    if(!visited[edge]) {
                        visited[edge]=true;
                        queue.add(edge);
                    }
                }
            }
        }
        //check if any vertex not visited
        while(--n>0) {
            if(!visited[n])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        KeysAndRooms solution = new KeysAndRooms();

        List<List<Integer>> edges1 = Arrays.asList(
                Arrays.asList(1), Arrays.asList(2), Arrays.asList(3), Arrays.asList()
        );
        boolean expected1 = true;
        boolean result1 = solution.canVisitAllRooms(edges1);
        check(expected1, result1, 1);

        // Test Case 2: All rooms connected
        List<List<Integer>> edges2 = Arrays.asList(
                Arrays.asList(1, 2), Arrays.asList(0, 1), Arrays.asList(0, 2)
        );
        boolean expected2 = true;
        boolean result2 = solution.canVisitAllRooms(edges2);
        check(expected2, result2, 2);

        // Test Case 3: Disconnected room
        List<List<Integer>> edges3 = Arrays.asList(
                Arrays.asList(1), Arrays.asList(2)
        );
        boolean expected3 = false;
        boolean result3 = solution.canVisitAllRooms(edges3);
        check(expected3, result3, 3);
    }

    private static void check(boolean expected, boolean result, int testNumber) {
        if (expected == result) {
            System.out.println("Test Case " + testNumber + " passed!");
        } else {
            System.out.println("Test Case " + testNumber + " failed!");
            System.out.println("Expected: " + expected);
            System.out.println("Result: " + result);
        }
    }
}
