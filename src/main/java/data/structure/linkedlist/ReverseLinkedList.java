package data.structure.linkedlist;

/**
 * https://leetcode.com/explore/learn/card/linked-list/219/classic-problems/1205/
 *
 * Input: head = [1,2,3,4,5]
 * Output: [5,4,3,2,1]
 *
 * Input: head = [1,2]
 * Output: [2,1]
 *
 * Input: head = []
 * Output: []
 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode cur = head, prev = null, temp;

        while (cur != null) {
            temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }

        return prev;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        ReverseLinkedList solution = new ReverseLinkedList();

        // Test case 1
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);
        System.out.println(solution.reverseList(head1)); // Output: [5, 4, 3, 2, 1]

        // Test case 2
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        System.out.println(solution.reverseList(head2)); // Output: [2, 1]

        // Test case 3
        ListNode head3 = null;
        System.out.println(solution.reverseList(head3)); // Output: []
    }
}
