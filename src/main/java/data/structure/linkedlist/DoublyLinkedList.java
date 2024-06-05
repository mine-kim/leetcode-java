package data.structure.linkedlist;

/**
 * https://leetcode.com/explore/learn/card/linked-list/210/doubly-linked-list/1294/
 *
 * Input
 * ["MyLinkedList", "addAtHead", "addAtTail", "addAtIndex", "get", "deleteAtIndex", "get"]
 * [[], [1], [3], [1, 2], [1], [1], [1]]
 * Output
 * [null, null, null, null, 2, null, 3]
 *
 */
public class DoublyLinkedList {

    private int size;
    private Node head;

    class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    public DoublyLinkedList() {
    }

    public int get(int index) {
        if(index >= size || index <=0) return -1;
        Node cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) return;
        size++;
        if (index == 0) {
            // 1 > 2   ====> 0 > 1 > 2
            Node prev = head;
            head = new Node(val);
            head.next = prev;
        } else {
            // 1 > 3 ====> 1 > 2 > 3 (1만 찾으면 값셋팅 가능)
            Node prev = head;
            for (int i=0; i < index - 1; i++) {
                prev = prev.next;
            }
            Node node = new Node(val);
            node.next = prev.next;
            prev.next = node;
        }
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) return;
        size--;

        if(index == 0) {
            head = head.next;
            return;
        }

        Node cur = head;
        for (int i =0; i < index - 1; i++) {
            cur = cur.next;
        }
        // 1 > 2 > 3 ====> 1 > 3
        cur.next = cur.next.next;
    }

    public static void main(String[] args) {
        DoublyLinkedList myLinkedList = new DoublyLinkedList();
        myLinkedList.addAtHead(1);
        myLinkedList.addAtTail(3);
        myLinkedList.addAtIndex(1, 2);    // linked list becomes 1->2->3
        myLinkedList.get(1);              // return 2
        myLinkedList.deleteAtIndex(1);    // now the linked list is 1->3
        myLinkedList.get(1);              // return 3
    }
}
