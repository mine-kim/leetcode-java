package data.structure.arraynstring;

/**
 *
 * https://leetcode.com/explore/learn/card/array-and-string/201/introduction-to-array/1144/
 *
 * Example 1:
 *
 * Input: nums = [1,7,3,6,5,6]
 * Output: 3
 * Explanation:
 * The pivot index is 3.
 * Left sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11
 * Right sum = nums[4] + nums[5] = 5 + 6 = 11
 *
 * Example 2:
 *
 * Input: nums = [1,2,3]
 * Output: -1
 * Explanation:
 * There is no index that satisfies the conditions in the problem statement.
 *
 * Example 3:
 *
 * Input: nums = [2,1,-1]
 * Output: 0
 * Explanation:
 * The pivot index is 0.
 * Left sum = 0 (no elements to the left of index 0)
 * Right sum = nums[1] + nums[2] = 1 + -1 = 0
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 104
 * -1000 <= nums[i] <= 1000
 *
 */
public class FindPivotIndex {
    public int pivotIndex(int[] nums) {
        int totalSum = 0;
        int leftsum = 0;

        for (int ele : nums)
            totalSum += ele;

        for (int i = 0; i < nums.length; leftsum += nums[i++])
            // sum to the left == leftsum.
            // sum to the right === totalSum - leftsum - nums[i]..
            // check if leftsum == totalSum - leftsum - nums[i]...
            if (leftsum * 2 == totalSum - nums[i])
                return i;       // Return the pivot index...
        return -1;
    }

    public static void main(String[] args) {
        FindPivotIndex solution = new FindPivotIndex();
        int[] nums = {1,7,3,6,5,6};
        solution.pivotIndex(nums);
    }
}
