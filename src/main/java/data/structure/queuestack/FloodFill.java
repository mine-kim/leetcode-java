package data.structure.queuestack;

/**
 * https://leetcode.com/explore/learn/card/queue-stack/239/conclusion/1393/discuss/3185874/Easiest-solution-oror-DFS-oror-JAVA
 *
 * Example 1:
 *
 * Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, color = 2
 * Output: [[2,2,2],[2,2,0],[2,0,1]]
 * Explanation: From the center of the image with position (sr, sc) = (1, 1) (i.e., the red pixel), all pixels connected by a path of the same color as the starting pixel (i.e., the blue pixels) are colored with the new color.
 * Note the bottom corner is not colored 2, because it is not 4-directionally connected to the starting pixel.
 *
 * Example 2:
 *
 * Input: image = [[0,0,0],[0,0,0]], sr = 0, sc = 0, color = 0
 * Output: [[0,0,0],[0,0,0]]
 * Explanation: The starting pixel is already colored 0, so no changes are made to the image.
 *
 *
 * Constraints:
 *
 * m == image.length
 * n == image[i].length
 * 1 <= m, n <= 50
 * 0 <= image[i][j], color < 216
 * 0 <= sr < m
 * 0 <= sc < n
 *
 */
public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        fill(image, sr, sc, image[sr][sc], color);
        return image;
    }

    public int[][] fill(int[][] image, int sr, int sc, int prevColor, int color) {
        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || image[sr][sc] == color || image[sr][sc] != prevColor) {
            return image;
        }

        image[sr][sc] = color;
        fill(image, sr, sc + 1, prevColor, color);
        fill(image, sr, sc - 1, prevColor, color);
        fill(image, sr + 1, sc, prevColor, color);
        fill(image, sr - 1, sc, prevColor, color);

        return image;
    }

    public static void main(String[] args) {
        FloodFill solution = new FloodFill();
        int[][] image = {{1,1,1}, {1,1,0},{1,0,1}};
        int[][] result = solution.floodFill(image, 1, 1,2);
    }

}
