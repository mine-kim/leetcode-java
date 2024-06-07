package data.structure.queuestack;

/**
 * https://leetcode.com/explore/learn/card/queue-stack/232/practical-application-stack/1389/
 *
 * Example 1:
 *
 * Input: nums = [1,1,1,1,1], target = 3
 * Output: 5
 * Explanation: There are 5 ways to assign symbols to make the sum of nums be target 3.
 * -1 + 1 + 1 + 1 + 1 = 3
 * +1 - 1 + 1 + 1 + 1 = 3
 * +1 + 1 - 1 + 1 + 1 = 3
 * +1 + 1 + 1 - 1 + 1 = 3
 * +1 + 1 + 1 + 1 - 1 = 3
 *
 * Example 2:
 *
 * Input: nums = [1], target = 1
 * Output: 1
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 20
 * 0 <= nums[i] <= 1000
 * 0 <= sum(nums[i]) <= 1000
 * -1000 <= target <= 1000
 *
 */
public class TargetSum {

    /**
       start
    /         \
    +1(11)     ...
     *   /        \
     *  +1+1(1)    +1-1(1)
     *    /  \        /   \
     * +1+1+1 +1+1-1 +1-1+1 +1-1-1
     */
    public int findTargetSumWays(int[] nums, int S) {
        return backtrack(nums, 0, 0, S);
    }

    private int backtrack(int[] nums, int index, int curSum, int target) {
        if (index == nums.length) {
            if (curSum == target) return 1;
            else return 0;
        }

        int plus = backtrack(nums, index + 1, curSum + nums[index], target);
        int minus = backtrack(nums, index + 1, curSum - nums[index], target);
        return plus + minus;
    }

    public static void main(String[] args) {
        TargetSum solution = new TargetSum();
        int[] nums = {1,1,1,1,1};
        System.out.println(solution.findTargetSumWays(nums, 3));
    }
}
