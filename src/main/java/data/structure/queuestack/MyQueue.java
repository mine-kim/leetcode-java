package data.structure.queuestack;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/explore/learn/card/queue-stack/239/conclusion/1386/
 *
 */
public class MyQueue {
    private List<Integer> list;
    public MyQueue() {
        list = new ArrayList<>();
    }

    public void push(int x) {
        list.add(x);
    }

    public int pop() {
        int i = list.get(0);
        list.remove(0);
        return i;
    }

    public int peek() {
        return list.get(0);
    }

    public boolean empty() {
        return list.isEmpty();
    }
}
