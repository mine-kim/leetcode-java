package data.structure.arraynstring;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/explore/learn/card/array-and-string/204/conclusion/1171/
 *
 * Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.
 * In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
 *
 * Time Complexity: O(rowIndex^2)
 * Space Complexity: O(rowIndex)
 */
public class PascalsTriangleII {
    public List<Integer> getRow(int rowIndex) {
        if (rowIndex == 0) return List.of(1);

        List<Integer> prev = new ArrayList<>();
        prev.add(1);

        for (int i = 1; i <= rowIndex; i++) {
            List<Integer> curr = new ArrayList<>();
            curr.add(1);
            for (int j = 1; j < i; j++) {
                curr.add(prev.get(j - 1) + prev.get(j));
            }
            curr.add(1);
            prev = curr;
        }

        return prev;
    }

    public static void main(String[] args) {
        PascalsTriangleII solution = new PascalsTriangleII();
        System.out.println(" solution.getRow(0) = " +  solution.getRow(0));
        System.out.println(" solution.getRow(0) = " +  solution.getRow(1));
        System.out.println(" solution.getRow(0) = " +  solution.getRow(33));
    }
}
