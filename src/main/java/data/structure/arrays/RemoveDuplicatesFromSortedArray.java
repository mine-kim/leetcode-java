package data.structure.arrays;

/**
 * https://leetcode.com/explore/learn/card/fun-with-arrays/526/deleting-items-from-an-array/3248/
 *
 * Example 1:
 *
 * Input: nums = [1,1,2]
 * Output: 2, nums = [1,2,_]
 * Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 *
 * Example 2:
 *
 * Input: nums = [0,0,1,1,1,2,2,3,3,4]
 * Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
 * Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 3 * 104
 * -100 <= nums[i] <= 100
 * nums is sorted in non-decreasing order.
 */
public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int index = 0;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] != nums[index])
                nums[++index] = nums[i];
        }
        return index + 1;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray solution = new RemoveDuplicatesFromSortedArray();
        solution.removeDuplicates(new int[]{1,1,2}); //[1,2,_]
        solution.removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}); //[0,1,2,3,4,_,_,_,_,_]
    }
}
