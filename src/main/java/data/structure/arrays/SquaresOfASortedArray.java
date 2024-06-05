package data.structure.arrays;

import java.util.Arrays;

/**
 * Example 1:
 *
 * Input: nums = [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 * Explanation: After squaring, the array becomes [16,1,0,9,100].
 * After sorting, it becomes [0,1,9,16,100].
 * Example 2:
 *
 * Input: nums = [-7,-3,2,3,11]
 * Output: [4,9,9,49,121]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums is sorted in non-decreasing order.
 */
public class SquaresOfASortedArray {
    public int[] sortedSquares(int[] nums) {
        int[] sort = new int[nums.length];
        int start = 0, end = nums.length - 1;
        for (int i = nums.length - 1; i > 0; i--) {
            if(Math.abs(nums[start]) > Math.abs(nums[end])){
                sort[i] = nums[start]*nums[start];
                start++;
            } else {
                sort[i] = nums[end]*nums[end];
                end--;
            }
        }
        return sort;
    }

    public static void main(String[] args) {
        SquaresOfASortedArray solution = new SquaresOfASortedArray();
        int[] nums = {-4,-1,0,3,10};
        System.out.println(Arrays.toString(solution.sortedSquares(nums)));
    }
}
