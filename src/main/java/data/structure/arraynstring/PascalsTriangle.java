package data.structure.arraynstring;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/explore/learn/card/array-and-string/202/introduction-to-2d-array/1170/
 *
 * Example 1:
 *
 * Input: numRows = 5
 * Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 * Example 2:
 *
 * Input: numRows = 1
 * Output: [[1]]
 *
 *
 * Constraints:
 *
 * 1 <= numRows <= 30
 */
public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        for(int i=0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) { // 첫 번째 또는 마지막 값은 1
                    row.add(1);
                } else { // 중간 값은 위 행의 왼쪽과 오른쪽 값의 합
                    row.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
                }
            }
            result.add(row);
        }
        return result;
    }

    public static void main(String[] args) {
        PascalsTriangle solution = new PascalsTriangle();
        solution.generate(10);
    }
}
