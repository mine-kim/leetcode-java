package data.structure.linkedlist;

/**
 * https://leetcode.com/explore/learn/card/linked-list/219/classic-problems/1207/
 *
 * Example 1:
 * Input: head = [1,2,6,3,4,5,6], val = 6
 * Output: [1,2,3,4,5]
 *
 * Example 2:
 * Input: head = [], val = 1
 * Output: []
 *
 * Example 3:
 * Input: head = [7,7,7,7], val = 7
 * Output: []
 *
 */
public class RemoveLinkedListElements {

    public ListNode removeElements(ListNode head, int val) {
        if( head == null) return null;

        ListNode ans = new ListNode();
        ListNode cur = ans;
        ListNode temp = head;

        while (temp != null) {
            if (temp.val != val) {
                cur.next = new ListNode(temp.val);
                cur = cur.next;
            }

            temp = temp.next;
        }

        return ans.next;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        RemoveLinkedListElements solution = new RemoveLinkedListElements();

        // Test case 1
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(6);
        head1.next.next.next = new ListNode(3);
        head1.next.next.next.next = new ListNode(4);
        head1.next.next.next.next.next = new ListNode(5);
        head1.next.next.next.next.next.next = new ListNode(6);
        System.out.println(solution.removeElements(head1, 6)); // Output: [1, 2, 3, 4, 5]

        // Test case 2
        ListNode head2 = null;
        System.out.println(solution.removeElements(head2, 1)); // Output: []

        // Test case 3
        ListNode head3 = new ListNode(7);
        head3.next = new ListNode(7);
        head3.next.next = new ListNode(7);
        head3.next.next.next = new ListNode(7);
        System.out.println(solution.removeElements(head3, 7));// Output: []
    }
}
