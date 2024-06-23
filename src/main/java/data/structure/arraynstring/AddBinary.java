package data.structure.arraynstring;

/**
 * https://leetcode.com/explore/learn/card/array-and-string/203/introduction-to-string/1160/
 *
 * Example 1:
 *
 * Input: a = "11", b = "1"
 * Output: "100"
 *
 * Example 2:
 *
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 *
 *
 * Constraints:
 *
 * 1 <= a.length, b.length <= 104
 * a and b consist only of '0' or '1' characters.
 * Each string does not contain leading zeros except for the zero itself.
 *
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int i = a.length() - 1; // Pointer for string a
        int j = b.length() - 1; // Pointer for string b
        int carry = 0;          // Carry-over value (0 or 1)

        while (i >= 0 || j >= 0 || carry > 0) { // Iterate until both strings are exhausted and carry is 0
            int sum = carry;

            if (i >= 0) {
                sum += a.charAt(i) - '0'; // Get integer value ('0' = 48, '1' = 49)
                i--;
            }

            if (j >= 0) {
                sum += b.charAt(j) - '0';
                j--;
            }

            result.append(sum % 2); // Append the digit (0 or 1) to result
            carry = sum / 2;       // Calculate new carry
        }

        return result.reverse().toString();
    }

    public static void main(String[] args) {
        AddBinary solution = new AddBinary();
        String sum = solution.addBinary("1010", "1011");
        System.out.println(sum); // Output: "10101"
    }
}
