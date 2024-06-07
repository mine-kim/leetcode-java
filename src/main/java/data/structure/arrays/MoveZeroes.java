package data.structure.arrays;

import java.util.Arrays;

/**
 * https://leetcode.com/explore/learn/card/fun-with-arrays/511/in-place-operations/3157/
 *
 * xample 1:
 *
 * Input: nums = [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * Example 2:
 *
 * Input: nums = [0]
 * Output: [0]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 104
 * -231 <= nums[i] <= 231 - 1
 *
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int pos = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0){
                int temp = nums[pos];
                nums[pos++] = nums[i];
                nums[i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        MoveZeroes solution = new MoveZeroes();
        int[] nums = {0,1,0,3,12};
        solution.moveZeroes(nums);
        System.out.println(Arrays.toString(nums)); //[1,3,12,0,0]
    }
}
