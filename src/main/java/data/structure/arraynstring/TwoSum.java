package data.structure.arraynstring;

/**
 * https://leetcode.com/explore/learn/card/array-and-string/205/array-two-pointer-technique/1153/
 *
 * Example 1:
 *
 * Input: numbers = [2,7,11,15], target = 9
 * Output: [1,2]
 * Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].
 *
 * Example 2:
 *
 * Input: numbers = [2,3,4], target = 6
 * Output: [1,3]
 * Explanation: The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We return [1, 3].
 *
 * Example 3:
 *
 * Input: numbers = [-1,0], target = -1
 * Output: [1,2]
 * Explanation: The sum of -1 and 0 is -1. Therefore index1 = 1, index2 = 2. We return [1, 2].
 *
 *
 * Constraints:
 *
 * 2 <= numbers.length <= 3 * 104
 * -1000 <= numbers[i] <= 1000
 * numbers is sorted in non-decreasing order.
 * -1000 <= target <= 1000
 * The tests are generated such that there is exactly one solution.
 *
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 *
 */
public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length -1;
        while(left < right) {
            int sum = numbers[left] + numbers[right];
            if(sum == target) {
                return new int[]{++left, ++right};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        TwoSum solution= new TwoSum();
        solution.twoSum(new int[]{1,2,4,7,8,10}, 9);
    }
}
