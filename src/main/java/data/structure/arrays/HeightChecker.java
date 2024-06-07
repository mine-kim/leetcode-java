package data.structure.arrays;

import java.util.Arrays;

/**
 * https://leetcode.com/explore/learn/card/fun-with-arrays/523/conclusion/3228/
 *
 * Example 1:
 *
 * Input: heights = [1,1,4,2,1,3]
 * Output: 3
 * Explanation:
 * heights:  [1,1,4,2,1,3]
 * expected: [1,1,1,2,3,4]
 * Indices 2, 4, and 5 do not match.
 *
 * Example 2:
 *
 * Input: heights = [5,1,2,3,4]
 * Output: 5
 * Explanation:
 * heights:  [5,1,2,3,4]
 * expected: [1,2,3,4,5]
 * All indices do not match.
 *
 * Example 3:
 *
 * Input: heights = [1,2,3,4,5]
 * Output: 0
 * Explanation:
 * heights:  [1,2,3,4,5]
 * expected: [1,2,3,4,5]
 * All indices match.
 *
 *
 * Constraints:
 *
 * 1 <= heights.length <= 100
 * 1 <= heights[i] <= 100
 *
 *
 */
public class HeightChecker {
    public int heightChecker(int[] heights) {
        int[] expected = heights.clone();
        Arrays.sort(expected);
        int count = 0;
        for(int i = 0; i < expected.length; i++){
            if(heights[i]!=expected[i]) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        HeightChecker solution = new HeightChecker();
        solution.heightChecker(new int[]{5,1,2,3,4}); // 3
    }
}
