package data.structure.arrays;

import java.sql.SQLOutput;

/**
 * https://leetcode.com/explore/learn/card/fun-with-arrays/521/introduction/3238/
 *
 * Example 1:
 * Input: nums = [1,1,0,1,1,1]
 * Output: 3
 * Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.
 *
 * Example 2:
 * Input: nums = [1,0,1,1,0,1]
 * Output: 2
 *
 * Constraints:
 * 1 <= nums.length <= 105
 * nums[i] is either 0 or 1
 *
 */
public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count=0, max=0;

        for(int i : nums){
            if(i == 1)
                count++;
            else {
                if(max<count)
                    max=count;
                count=0;
            }
        }

        if(max<count)
            max=count;
        return max;
    }

    public static void main(String[] args) {
        MaxConsecutiveOnes solution = new MaxConsecutiveOnes();
        int[] nums1 = {1, 1, 0, 1, 1, 1};
        System.out.println(solution.findMaxConsecutiveOnes(nums1)); // 3
        int[] nums2 = {1, 0, 1, 1, 0, 1};
        System.out.println(solution.findMaxConsecutiveOnes(nums2)); // 2
        int[] nums3 = {1, 1, 0, 1};
        System.out.println(solution.findMaxConsecutiveOnes(nums3)); // 2
    }
}
