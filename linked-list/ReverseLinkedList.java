/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    /**
     * Pattern : LinkedList - three pointers (prev, curr, next)
     * Time : O(n) | Space : O(1)
     * 206. Reverse Linked List
     */
    public ListNode reverseList(ListNode head) {
        ListNode previous = null;
        ListNode current = head;

        while(current != null) {
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        return previous;
    }

    /**
     * Pattern : LinkedList - rrecursive, propagate new head upward
     * Time : O(n) | Space : O(n)
     * 206. Reverse Linked List
     */
    public ListNode reverseListRecursive(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode newHead = reverseListRecursive(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }
}
