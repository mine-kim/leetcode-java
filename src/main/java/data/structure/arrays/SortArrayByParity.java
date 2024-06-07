package data.structure.arrays;

/**
 * https://leetcode.com/explore/learn/card/fun-with-arrays/511/in-place-operations/3260/
 *
 * Example 1:
 *
 * Input: nums = [3,1,2,4]
 * Output: [2,4,3,1]
 * Explanation: The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
 *
 * Example 2:
 *
 * Input: nums = [0]
 * Output: [0]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 5000
 * 0 <= nums[i] <= 5000
 *
 */
public class SortArrayByParity {

    public int[] sortArrayByParity(int[] nums) {
        int pos = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] % 2 == 0){
                int temp = nums[pos];
                nums[pos++] = nums[i];
                nums[i] = temp;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        SortArrayByParity solution = new SortArrayByParity();
        solution.sortArrayByParity(new int[]{3,1,2,4}); //[2,4,3,1]
    }
}
