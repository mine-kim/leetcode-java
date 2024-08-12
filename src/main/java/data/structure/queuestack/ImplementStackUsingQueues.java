package data.structure.queuestack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/explore/learn/card/queue-stack/239/conclusion/1387/
 *
 */
public class ImplementStackUsingQueues {

    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    public ImplementStackUsingQueues() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int x) {
        queue2.add(x);
        while (!queue1.isEmpty()) {
            queue2.add(queue1.poll());
        }
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    public int pop() {
        return queue1.poll();
    }

    public int top() {
        return queue1.peek();
    }

    public boolean empty() {
        return queue1.isEmpty();
    }

    public static void main(String[] args) {
        ImplementStackUsingQueues obj = new ImplementStackUsingQueues();
        obj.push(1);
        obj.push(2);
        int param_2 = obj.pop();
        int param_3 = obj.top();
        int param_5 = obj.pop();
        boolean param_4 = obj.empty();
    }
}
