package data.structure.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/explore/learn/card/fun-with-arrays/523/conclusion/3270/
 *
 * Example 1:
 *
 * Input: nums = [4,3,2,7,8,2,3,1]
 * Output: [5,6]
 *
 * Example 2:
 *
 * Input: nums = [1,1]
 * Output: [2]
 *
 *
 * Constraints:
 *
 * n == nums.length
 * 1 <= n <= 105
 * 1 <= nums[i] <= n
 *
 */
public class FindAllNumbersDisappearedinanArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        boolean[] isAvailable = new boolean[nums.length];
        for(int i=0; i<nums.length; i++) {
            isAvailable[nums[i]-1] = true;
        }
        List<Integer> ans = new ArrayList<>();
        for(int i=0; i<isAvailable.length; i++) {
            if(isAvailable[i] == false) {
                ans.add(i+1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        FindAllNumbersDisappearedinanArray solution = new FindAllNumbersDisappearedinanArray();
        solution.findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1}); // [5, 6]
        solution.findDisappearedNumbers(new int[]{10,2,5,10,9,1,1,4,3,7}); // [6,8]
    }
}
