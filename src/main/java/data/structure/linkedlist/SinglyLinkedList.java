package data.structure.linkedlist;

/**
 * https://leetcode.com/explore/learn/card/linked-list/209/singly-linked-list/1290/
 *
 * Input
 * ["MyLinkedList", "addAtHead", "addAtTail", "addAtIndex", "get", "deleteAtIndex", "get"]
 * [[], [1], [3], [1, 2], [1], [1], [1]]
 * Output
 * [null, null, null, null, 2, null, 3]
 *
 * Explanation
 * MyLinkedList myLinkedList = new MyLinkedList();
 * myLinkedList.addAtHead(1);
 * myLinkedList.addAtTail(3);
 * myLinkedList.addAtIndex(1, 2);    // linked list becomes 1->2->3
 * myLinkedList.get(1);              // return 2
 * myLinkedList.deleteAtIndex(1);    // now the linked list is 1->3
 * myLinkedList.get(1);              // return 3
 */
class SinglyLinkedList {

    private int size;
    private Node head;

    class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    public SinglyLinkedList() {
    }

    public int get(int index) {
        if(index < 0 || index >= size) return -1;
        Node cur = head;
        for(int i = 0; i < index; i++) {
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
        if(index > size) return;
        size++;
        if(index <= 0) {
            Node prev = head; //헤드에 있던값을 저장해둠
            head = new Node(val);
            head.next = prev;
        } else {
            Node cur = head;
            for(int i = 0; i < index - 1; i++) {
                cur = cur.next;
            }
            Node node = new Node(val);
            node.next = cur.next;
            cur.next = node;
        }
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) return;
        size--;

        //head 없애기
        if(index == 0) {
            head = head.next;
            return;
        }

        Node cur = head;
        for(int i = 0; i < index - 1; i++){
            cur = cur.next;
        }
        cur.next = cur.next.next;
    }

    public static void main(String[] args) {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.addAtHead(1);
        singlyLinkedList.addAtTail(3);
        singlyLinkedList.addAtIndex(1, 2);    // linked list becomes 1->2->3
        singlyLinkedList.get(1);              // return 2
        singlyLinkedList.deleteAtIndex(1);    // now the linked list is 1->3
        singlyLinkedList.get(1);              // return 3
    }
}