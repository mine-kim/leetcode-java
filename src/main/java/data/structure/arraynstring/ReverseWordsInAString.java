package data.structure.arraynstring;

import java.util.Stack;

/**
 * https://leetcode.com/explore/learn/card/array-and-string/204/conclusion/1164/
 *
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */
public class ReverseWordsInAString {
    public String reverseWords(String s) {
        StringBuilder word = new StringBuilder();
        String[] arr = s.split(" ");
        for (int i = arr.length-1; i >= 0; i--) {
            if (!arr[i].isEmpty())
                    word.append(arr[i]).append(" ");
        }
        return word.toString().trim();
    }

    public static void main(String[] args) {
        ReverseWordsInAString solution = new ReverseWordsInAString();
        System.out.println("solution = " + solution.reverseWords("the sky is blue"));
        System.out.println("solution = " + solution.reverseWords("  hello world  "));
        System.out.println("solution = " + solution.reverseWords("a good   example"));
    }
}
