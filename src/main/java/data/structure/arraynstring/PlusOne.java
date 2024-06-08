package data.structure.arraynstring;

/**
 * https://leetcode.com/explore/learn/card/array-and-string/201/introduction-to-array/1148/
 *
 * Example 1:
 *
 * Input: digits = [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * Incrementing by one gives 123 + 1 = 124.
 * Thus, the result should be [1,2,4].
 *
 * Example 2:
 *
 * Input: digits = [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 * Incrementing by one gives 4321 + 1 = 4322.
 * Thus, the result should be [4,3,2,2].
 *
 * Example 3:
 *
 * Input: digits = [9]
 * Output: [1,0]
 * Explanation: The array represents the integer 9.
 * Incrementing by one gives 9 + 1 = 10.
 * Thus, the result should be [1,0].
 *
 *
 * Constraints:
 *
 * 1 <= digits.length <= 100
 * 0 <= digits[i] <= 9
 * digits does not contain any leading 0's.
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        int total = digits.length == 0 ? 1 : digits.length -1;
        for(int i = total; i >= 0; i--) {
            if(digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    public static void main(String[] args) {
        PlusOne solution = new PlusOne();
        solution.plusOne(new int[]{9,9});
        solution.plusOne(new int[]{1,2,9});
        solution.plusOne(new int[]{1,2,3});
        solution.plusOne(new int[]{9});
    }
}
