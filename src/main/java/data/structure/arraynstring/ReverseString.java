package data.structure.arraynstring;

import java.util.Arrays;

/**
 * https://leetcode.com/explore/learn/card/array-and-string/205/array-two-pointer-technique/1183/
 *
 * Example 1:
 *
 * Input: s = ["h","e","l","l","o"]
 * Output: ["o","l","l","e","h"]
 *
 * Example 2:
 *
 * Input: s = ["H","a","n","n","a","h"]
 * Output: ["h","a","n","n","a","H"]
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 105
 * s[i] is a printable ascii character.
 *
 * Time Complexity: O(N/2) -> O(N)
 * Space Complexity: O(1)
 */
public class ReverseString {
    public void reverseString(char[] s) {
        int i = 0;
        int j = s.length - 1;
        while(i < j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        ReverseString solution = new ReverseString();
        solution.reverseString(new char[]{'h','e','l','l','o'});
    }
}
