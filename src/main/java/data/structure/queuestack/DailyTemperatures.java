package data.structure.queuestack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode.com/explore/learn/card/queue-stack/230/usage-stack/1363/
 *
 * Example 1:
 *
 * Input: temperatures = [73,74,75,71,69,72,76,73]
 * Output: [1,1,4,2,1,1,0,0]
 *
 * Example 2:
 *
 * Input: temperatures = [30,40,50,60]
 * Output: [1,1,1,0]
 *
 * Example 3:
 *
 * Input: temperatures = [30,60,90]
 * Output: [1,1,0]
 *
 *
 * Constraints:
 *
 * 1 <= temperatures.length <= 105
 * 30 <= temperatures[i] <= 100
 */
public class DailyTemperatures {

    public int[] dailyTemperatures(int[] temperatures) {
        //Stack<Integer> stack = new Stack<>();
        Deque<Integer> stack = new ArrayDeque<>();
        int[] answer = new int[temperatures.length];
        for(int i = 0; i < temperatures.length; i++) {
            //while(!stack.empty() && temperatures[i] > temperatures[stack.peek()]){
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                int index = stack.pop();
                answer[index] = i - index;
            }
            stack.push(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        DailyTemperatures solution = new DailyTemperatures();
        int[] temperatures = {73,74,75,71,69,72,76,73};
        solution.dailyTemperatures(temperatures);
    }
}
