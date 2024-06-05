package data.structure.arrays;

import java.util.Arrays;

/**
 * https://leetcode.com/explore/learn/card/fun-with-arrays/525/inserting-items-into-an-array/3245/
 *
 * Example 1:
 *
 * Input: arr = [1,0,2,3,0,4,5,0]
 * Output: [1,0,0,2,3,0,0,4]
 * Explanation: After calling your function, the input array is modified to: [1,0,0,2,3,0,0,4]
 *
 * Example 2:
 *
 * Input: arr = [1,2,3]
 * Output: [1,2,3]
 * Explanation: After calling your function, the input array is modified to: [1,2,3]
 *
 *
 * Constraints:
 *
 * 1 <= arr.length <= 104
 * 0 <= arr[i] <= 9
 *
 */
public class DuplicateZeros {
    public int[] duplicateZeros(int[] arr) {
        int[] dupArr = new int[arr.length];

        System.arraycopy(arr, 0, dupArr, 0, arr.length);

        int arrPos = 0;

        for (int i = 0; arrPos < arr.length; i++) {
            arr[arrPos] = dupArr[i];
            arrPos++;
            if(arr.length <= arrPos){
                break;
            }
            if(dupArr[i] == 0) {
                arr[arrPos] = 0;
                arrPos++;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        DuplicateZeros solution = new DuplicateZeros();
        int[] nums = {1,0,2,0,0,4,5,0};
        System.out.println(Arrays.toString(solution.duplicateZeros(nums)));
    }
}
