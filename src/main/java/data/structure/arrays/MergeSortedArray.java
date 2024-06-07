package data.structure.arrays;

/**
 * https://leetcode.com/explore/learn/card/fun-with-arrays/525/inserting-items-into-an-array/3253/
 *
 * Example 1:
 *
 * Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * Output: [1,2,2,3,5,6]
 * Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
 * The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
 *
 * Example 2:
 *
 * Input: nums1 = [1], m = 1, nums2 = [], n = 0
 * Output: [1]
 * Explanation: The arrays we are merging are [1] and [].
 * The result of the merge is [1].
 *
 * Example 3:
 *
 * Input: nums1 = [0], m = 0, nums2 = [1], n = 1
 * Output: [1]
 * Explanation: The arrays we are merging are [] and [1].
 * The result of the merge is [1].
 * Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.
 *
 * Constraints:
 *
 * nums1.length == m + n
 * nums2.length == n
 * 0 <= m, n <= 200
 * 1 <= m + n <= 200
 * -109 <= nums1[i], nums2[j] <= 109
 */
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int mm = m - 1, nn = n - 1, pos = m + n - 1;

        while (mm >= 0 && nn >= 0) {
            if(nums1[mm] > nums2[nn]) {
                nums1[pos--] = nums1[mm--];
            } else {
                nums1[pos--] = nums2[nn--];
            }
        }

        //nums1[0] = nums1[mm] < nums2[nn] ? nums1[mm] : nums2[nn];

        while(nn >= 0){
            nums1[pos--] = nums2[nn--];
        }
    }

    public static void main(String[] args) {
        MergeSortedArray solution = new MergeSortedArray();
        int m = 3, n = 3;
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        solution.merge(nums1 ,m ,nums2, n);
    }
}
