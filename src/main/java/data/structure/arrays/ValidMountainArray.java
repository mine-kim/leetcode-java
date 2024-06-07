package data.structure.arrays;

/**
 * https://leetcode.com/explore/learn/card/fun-with-arrays/527/searching-for-items-in-an-array/3251/
 *
 * Example 1:
 *
 * Input: arr = [2,1]
 * Output: false
 *
 * Example 2:
 *
 * Input: arr = [3,5,5]
 * Output: false
 *
 * Example 3:
 *
 * Input: arr = [0,3,2,1]
 * Output: true
 *
 *
 * Constraints:
 *
 * 1 <= arr.length <= 104
 * 0 <= arr[i] <= 104
 *
 */
public class ValidMountainArray {
    public boolean validMountainArray(int[] arr) {
        int length = arr.length, up = 0, down = length - 1;
        while (up + 1 < length && arr[up] < arr[up + 1]) up++;
        while (down > 0 && arr[down - 1] > arr[down]) down--;
        return up > 0 && up == down && down < length- 1;
    }

    public static void main(String[] args) {
        ValidMountainArray solution = new ValidMountainArray();
        solution.validMountainArray(new int[]{0,3,2,1}); //[2,2,_,_]
    }
}
