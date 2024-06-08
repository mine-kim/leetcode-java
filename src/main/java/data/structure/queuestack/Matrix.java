package data.structure.queuestack;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class Matrix {
    public int[][] updateMatrix(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        int[][] dist = new int[rows][cols];
        Queue<int[]> queue = new ArrayDeque<>();

        // 모든 셀의 거리를 초기화하고, 0인 셀을 큐에 추가
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                } else {
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        // BFS를 위한 방향 벡터 (상, 하, 좌, 우)
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        // BFS 수행
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0];
            int col = cell[1];

            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols) {
                    if (dist[newRow][newCol] > dist[row][col] + 1) {
                        dist[newRow][newCol] = dist[row][col] + 1;
                        queue.offer(new int[]{newRow, newCol});
                    }
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        Matrix solution = new Matrix();
        int[][] mat = {
                {0, 0, 0},
                {0, 1, 0},
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };

        int[][] result = solution.updateMatrix(mat);

        // 결과 출력
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
