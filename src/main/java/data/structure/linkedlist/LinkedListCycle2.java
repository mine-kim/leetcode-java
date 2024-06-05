package data.structure.linkedlist;
/**
 * https://leetcode.com/explore/learn/card/linked-list/214/two-pointer-technique/1214/
 *
 * Input: head = [3,2,0,-4], pos = 1
 * Output: tail connects to node index 1
 * Explanation: There is a cycle in the linked list, where tail connects to the second node.
 *
 * Input: head = [1], pos = -1
 * Output: no cycle
 * Explanation: There is no cycle in the linked list.
 *
 */
public class LinkedListCycle2 {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        // Step 1: Determine if there is a cycle in the list
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                // Cycle detected
                break;
            }
        }

        // If there is no cycle
        if (fast == null || fast.next == null) {
            return null;
        }

        // Step 2: Find the start of the cycle
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;  // The start of the cycle
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
          val = x;
          next = null;
        }
    }

    public static void main(String[] args) {
        LinkedListCycle2 solution = new LinkedListCycle2();

        // Test case 1: Cycle exists and starts at node index 1
        ListNode head1 = new ListNode(3);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(0);
        head1.next.next.next = new ListNode(-4);
        head1.next.next.next.next = head1.next;
        System.out.println(solution.detectCycle(head1).val); // Output: 2

        // Test case 2: Cycle exists and starts at node index 0
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = head2;
        System.out.println(solution.detectCycle(head2).val); // Output: 1

        // Test case 3: No cycle
        ListNode head3 = new ListNode(1);
        System.out.println(solution.detectCycle(head3)); // Output: null

        // Test case 4: Cycle exists and starts at node index 5
        ListNode head4 = new ListNode(1);
        head4.next = new ListNode(2);
        head4.next.next = new ListNode(3);
        head4.next.next.next = new ListNode(4);
        head4.next.next.next.next = new ListNode(5);
        head4.next.next.next.next.next = new ListNode(6);
        head4.next.next.next.next.next.next = new ListNode(7);
        head4.next.next.next.next.next.next.next = new ListNode(8);
        head4.next.next.next.next.next.next.next.next = head4.next.next.next.next;
        System.out.println(solution.detectCycle(head4).val); // Output: 5
    }
}
