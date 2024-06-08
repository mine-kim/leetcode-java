package data.structure.queuestack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode.com/explore/learn/card/queue-stack/239/conclusion/1379/discuss/210284/Java-Recursive
 *
 * Example 1:
 *
 * Input: s = "3[a]2[bc]"
 * Output: "aaabcbc"
 *
 * Example 2:
 *
 * Input: s = "3[a2[c]]"
 * Output: "accaccacc"
 *
 * Example 3:
 *
 * Input: s = "2[abc]3[cd]ef"
 * Output: "abcabccdcdcdef"
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 30
 * s consists of lowercase English letters, digits, and square brackets '[]'.
 * s is guaranteed to be a valid input.
 * All the integers in s are in the range [1, 300].
 *
 */
public class DecodeString {
    int i = 0;
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        String temp = "";
        while (i < s.length()) {
            char c = s.charAt(i);
            i++;
            if (c == '[') {
                temp = decodeString(s);
                int j = 0;
                while (j < count) {
                 sb.append(temp);
                 j++;
                }
            count = 0;
            } else if (c == ']')    break;
                else if (Character.isAlphabetic(c)) sb.append(c);
                else    count = count * 10 + c - '0';
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        DecodeString solution = new DecodeString();
        solution.decodeString("2[abc]3[cd]ef");
    }
}
