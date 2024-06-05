package data.structure.linkedlist;

/**
 * https://leetcode.com/explore/learn/card/linked-list/214/two-pointer-technique/1215/
 *
 * Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
 * Output: Intersected at '8'
 *
 * Input: intersectVal = 2, listA = [1,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 * Output: Intersected at '2'
 *
 * Input: intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
 * Output: No intersection
 *
 * https://velog.io/@dlwhsk0/LeetCodePython-160.-Intersection-of-Two-Linked-Lists
 * 두 리스트의 순서를 반대로 이어 붙인 두 리스트를 비교하면 길이를 신경쓰지 않고 단순 반복문으로 교차점을 찾을 수 있다.
 *
 * listA = [4,1,8,4,5], listB = [5,6,1,8,4,5] 가 있는 경우:
 * 4, 1, 8, 4, 5 - 5, 6, 1, 8, 4, 5
 * 5, 6, 1, 8, 4, 5, - 4, 1, 8, 4, 5
 */
public class IntersectionofTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)  return null;
        
        ListNode a = headA;
        ListNode b = headB;
        
        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
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
        IntersectionofTwoLinkedLists solution = new IntersectionofTwoLinkedLists();

        // Test case 1: Intersected at '8'
        ListNode headA1 = new ListNode(4);
        headA1.next = new ListNode(1);
        headA1.next.next = new ListNode(8);
        headA1.next.next.next = new ListNode(4);
        headA1.next.next.next.next = new ListNode(5);

        ListNode headB1 = new ListNode(5);
        headB1.next = new ListNode(6);
        headB1.next.next = new ListNode(1);
        headB1.next.next.next = new ListNode(8);
        headB1.next.next.next.next = new ListNode(4);
        headB1.next.next.next.next.next = new ListNode(5);

        System.out.println(solution.getIntersectionNode(headA1, headB1)); // Output: 8
    }
}
