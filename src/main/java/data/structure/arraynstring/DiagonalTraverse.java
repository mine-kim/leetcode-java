package data.structure.arraynstring;

/**
 * https://leetcode.com/explore/learn/card/array-and-string/202/introduction-to-2d-array/1167/
 *
 * Example 1:
 *
 * Input: mat = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [1,2,4,7,5,3,6,8,9]
 *
 * Example 2:
 *
 * Input: mat = [[1,2],[3,4]]
 * Output: [1,2,3,4]
 *
 *
 * Constraints:
 *
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n <= 104
 * 1 <= m * n <= 104
 * -105 <= mat[i][j] <= 105
 *
 */
public class DiagonalTraverse {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[] result = new int[m * n];
        int row = 0, col = 0, direction = 1; // 1 for up, -1 for down

        for (int i = 0; i < m * n; i++) {
            result[i] = mat[row][col];

            // Calculate next position based on direction
            int newRow = row - direction, newCol = col + direction;

            // If we go out of bounds, adjust
            if (newRow < 0 || newRow == m || newCol < 0 || newCol == n) {
                if (direction == 1) { // Going up
                    row += (col == n - 1) ? 1 : 0; // Move down if we hit the right edge
                    col += (col < n - 1) ? 1 : 0; // Move right if we haven't hit the right edge
                } else { // Going down
                    col += (row == m - 1) ? 1 : 0; // Move right if we hit the bottom edge
                    row += (row < m - 1) ? 1 : 0; // Move down if we haven't hit the bottom edge
                }

                direction = -direction; // Change direction
            } else {
                row = newRow;
                col = newCol;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        DiagonalTraverse solution = new DiagonalTraverse();
        solution.findDiagonalOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
    }
}
