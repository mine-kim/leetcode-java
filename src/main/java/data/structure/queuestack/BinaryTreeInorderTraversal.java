package data.structure.queuestack;

import java.util.*;

/**
 * https://leetcode.com/explore/learn/card/queue-stack/232/practical-application-stack/1383/
 *
 * Example 1:
 *
 *
 * Input: root = [1,null,2,3]
 * Output: [1,3,2]
 *
 * Example 2:
 *
 * Input: root = []
 * Output: []
 *
 * Example 3:
 *
 * Input: root = [1]
 * Output: [1]
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 100].
 * -100 <= Node.val <= 100
 *
 */
public class BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    public void helper(TreeNode root, List<Integer> res) {
        if (root != null) {
            helper(root.left, res);
            res.add(root.val);
            helper(root.right, res);
        }
    }

    static public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        BinaryTreeInorderTraversal solution = new BinaryTreeInorderTraversal();

        // 테스트 케이스 1: 빈 트리
        TreeNode root1 = null;
        List<Integer> expected1 = new ArrayList<>();
        List<Integer> result1 = solution.inorderTraversal(root1);
        check(expected1, result1, 1);

        // 테스트 케이스 2: 단일 노드 트리
        TreeNode root2 = new TreeNode(1);
        List<Integer> expected2 = Arrays.asList(1);
        List<Integer> result2 = solution.inorderTraversal(root2);
        check(expected2, result2, 2);

        // 테스트 케이스 3: 일반적인 트리
        TreeNode root3 = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        root3.right.right = new TreeNode(4, new TreeNode(5), new TreeNode(6));
        List<Integer> expected3 = Arrays.asList(1, 3, 2, 5, 4, 6);
        List<Integer> result3 = solution.inorderTraversal(root3);
        check(expected3, result3, 3);
    }

    private static void check(List<Integer> expected, List<Integer> result, int testNumber) {
        if (expected.equals(result)) {
            System.out.println("테스트 케이스 " + testNumber + " 통과!");
        } else {
            System.out.println("테스트 케이스 " + testNumber + " 실패!");
            System.out.println("기대값: " + expected);
            System.out.println("결과값: " + result);
        }
    }
}
