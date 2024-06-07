package data.structure.arrays;

/**
 * https://leetcode.com/explore/learn/card/fun-with-arrays/523/conclusion/3231/discuss/983366/java-solution
 *
 * Example 1:
 *
 * Input: nums = [3,2,1]
 * Output: 1
 * Explanation:
 * The first distinct maximum is 3.
 * The second distinct maximum is 2.
 * The third distinct maximum is 1.
 *
 * Example 2:
 *
 * Input: nums = [1,2]
 * Output: 2
 * Explanation:
 * The first distinct maximum is 2.
 * The second distinct maximum is 1.
 * The third distinct maximum does not exist, so the maximum (2) is returned instead.
 *
 * Example 3:
 *
 * Input: nums = [2,2,3,1]
 * Output: 1
 * Explanation:
 * The first distinct maximum is 3.
 * The second distinct maximum is 2 (both 2's are counted together since they have the same value).
 * The third distinct maximum is 1.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 104
 * -231 <= nums[i] <= 231 - 1
 *
 */
public class ThirdMaximumNumber {
    public int thirdMax(int[] nums) {
        long max1 = Long.MIN_VALUE;
        long max2 = Long.MIN_VALUE;
        long max3 = Long.MIN_VALUE;

        for(long i : nums) {
            if(i == max1 || i == max2 || i == max3) continue;
            if(i > max1) {
                max3 = max2;
                max2 = max1;
                max1 = i;
            } else if (i > max2) {
                max3 = max2;
                max2 = i;
            } else if (i > max3) {
                max3 = i;
            }
        }

        if(max3 == Long.MIN_VALUE){
            return (int)max1;
        }
        return (int)max3;
    }

    public static void main(String[] args) {
        ThirdMaximumNumber solution = new ThirdMaximumNumber();
        System.out.println(solution.thirdMax(new int[]{5,1,2,3,4})); // 3
        System.out.println(solution.thirdMax(new int[]{1,2})); // 2
        System.out.println(solution.thirdMax(new int[]{2,2,3,1})); // 1
        System.out.println(solution.thirdMax(new int[]{5,2,2})); // 5
        System.out.println(solution.thirdMax(new int[]{1,1,1})); // 1
        System.out.println(solution.thirdMax(new int[]{3,2,1})); // 1
    }
}
