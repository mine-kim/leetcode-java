package data.structure.arraynstring;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/explore/learn/card/array-and-string/202/introduction-to-2d-array/1168/
 *
 * Example 1:
 *
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [1,2,3,6,9,8,7,4,5]
 *
 * Example 2:
 *
 * Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 *
 *
 * Constraints:
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 10
 * -100 <= matrix[i][j] <= 100
 *
 * Time Complexity: O(m * n)
 * Space Complexity: O(m * n)
 */
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix.length == 0) return result; // 빈 행렬 처리

        int rows = matrix.length;
        int cols = matrix[0].length;
        int top = 0, bottom = rows - 1, left = 0, right = cols - 1;
        int direction = 0; // 0: 우, 1: 하, 2: 좌, 3: 상

        while (top <= bottom && left <= right) {
            if (direction == 0) { // 우
                for (int i = left; i <= right; i++) {
                    result.add(matrix[top][i]);
                }
                top++;
            } else if (direction == 1) { // 하
                for (int i = top; i <= bottom; i++) {
                    result.add(matrix[i][right]);
                }
                right--;
            } else if (direction == 2) { // 좌
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            } else { // 상
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
            direction = (direction + 1) % 4; // 방향 전환
        }
        return result;
    }

    public static void main(String[] args) {
        SpiralMatrix solution = new SpiralMatrix();
        //solution.spiralOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
        solution.spiralOrder(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}});
    }

}
