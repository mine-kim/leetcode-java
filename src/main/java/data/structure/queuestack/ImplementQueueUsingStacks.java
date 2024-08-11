package data.structure.queuestack;

import java.util.Stack;

/**
 * https://leetcode.com/explore/learn/card/queue-stack/239/conclusion/1386/
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class ImplementQueueUsingStacks {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public ImplementQueueUsingStacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        stack1.add(x);
    }

    public int pop() {
        int i = 0;
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        i = stack2.pop();
        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        return i;
    }

    public int peek() {
        int i = 0;
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        i = stack2.peek();
        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        return i;
    }

    public boolean empty() {
        return stack1.isEmpty();
    }

    public static void main(String[] args) {
        ImplementQueueUsingStacks obj = new ImplementQueueUsingStacks();
        obj.push(1);
        obj.push(2);
        int param_2 = obj.pop();
        int param_3 = obj.peek();
        boolean param_4 = obj.empty();
    }
}
