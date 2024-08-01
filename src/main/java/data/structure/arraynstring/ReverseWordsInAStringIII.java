package data.structure.arraynstring;

/**
 * https://leetcode.com/explore/learn/card/array-and-string/204/conclusion/1165/
 *
 * Example 1:
 *
 * Input: s = "Let's take LeetCode contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 * Example 2:
 *
 * Input: s = "Mr Ding"
 * Output: "rM gniD"
 *
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */
public class ReverseWordsInAStringIII {
    public String reverseWords(String s) {
        String[] arr = s.split(" ");
        StringBuilder sentence = new StringBuilder();
        for (String str : arr) {
            sentence.append(new StringBuilder(str).reverse().toString());
            sentence.append(" ");
        }
        return sentence.toString().trim();
    }

    public static void main(String[] args) {
        ReverseWordsInAStringIII solution = new ReverseWordsInAStringIII();
        System.out.println("solution = " + solution.reverseWords("Let's take LeetCode contest"));
        System.out.println("solution = " + solution.reverseWords("Mr Ding"));
    }
}
