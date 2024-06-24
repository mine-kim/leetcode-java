package data.structure.arraynstring;

/**
 * https://leetcode.com/explore/learn/card/array-and-string/203/introduction-to-string/1161/
 *
 * Example 1:
 *
 * Input: haystack = "sadbutsad", needle = "sad"
 * Output: 0
 * Explanation: "sad" occurs at index 0 and 6.
 * The first occurrence is at index 0, so we return 0.
 *
 * Example 2:
 *
 * Input: haystack = "leetcode", needle = "leeto"
 * Output: -1
 * Explanation: "leeto" did not occur in "leetcode", so we return -1.
 *
 *
 * Constraints:
 *
 * 1 <= haystack.length, needle.length <= 104
 * haystack and needle consist of only lowercase English characters.
 */
public class ImplementStr {
    public int strStr(String haystack, String needle) {
        int haystackLen = haystack.length();
        int needleLen = needle.length();

        for(int i = 0; i < haystackLen; i++) {
            int endIndex = i+needleLen;
            if(endIndex > haystackLen) return -1;
            String copy = haystack.substring(i, endIndex);
            if(copy.equals(needle))
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        ImplementStr solution = new ImplementStr();
        solution.strStr("sadbutsad", "sad");
        solution.strStr("a", "a");
        solution.strStr("abc", "c");

    }
}
