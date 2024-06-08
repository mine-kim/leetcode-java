package data.structure.arraynstring;

/**
 * https://leetcode.com/explore/learn/card/array-and-string/201/introduction-to-array/1147/
 *
 * Example 1:
 *
 * Input: nums = [3,6,1,0]
 * Output: 1
 * Explanation: 6 is the largest integer.
 * For every other number in the array x, 6 is at least twice as big as x.
 * The index of value 6 is 1, so we return 1.
 *
 * Example 2:
 *
 * Input: nums = [1,2,3,4]
 * Output: -1
 * Explanation: 4 is less than twice the value of 3, so we return -1.
 *
 *
 * Constraints:
 *
 * 2 <= nums.length <= 50
 * 0 <= nums[i] <= 100
 * The largest element in nums is unique.
 *
 */
public class LargestNumberAtLeastTwiceOfOthers {
    public int dominantIndex(int[] nums) {
        int max = 0;
        int secondMax = 0;
        int maxIndex = 0;
        for(int i = 0; i < nums.length; i++) {
            if(max < nums[i]) {
                secondMax = max;
                max = nums[i];
                maxIndex = i;
            } else if(secondMax < nums[i]){
                secondMax = nums[i];
            }
        }
        if(max >= secondMax*2) return maxIndex;

        return -1;
    }

    public static void main(String[] args) {
        LargestNumberAtLeastTwiceOfOthers solution = new LargestNumberAtLeastTwiceOfOthers();
        int[] nums = {0,2,3,0};
        solution.dominantIndex(nums);

    }
}
