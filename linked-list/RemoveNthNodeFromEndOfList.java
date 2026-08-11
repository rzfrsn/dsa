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
     * Pattern : LinkedList - dummy + gap
     * Time : O(n) | Space : O(1)
     * 19. Remove Nth Node From End of List
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode slow = dummy, fast = dummy;

        for(int i=0; i<n; i++) fast = fast.next;

        while(fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return dummy.next;
    }

    /**
     * Pattern : LinkedList - three pointers : nth, tail, previous
     * Time : O(n) | Space : O(1)
     * 19. Remove Nth Node From End of List
     */
    public ListNode removeNthFromEndV0(ListNode head, int n) {
        ListNode nth = head, tail = head, previous = head;
        int i = 1, j = n+1;

        while(tail != null) {
            if(i == n) nth = head;
            if(i > j) previous = previous.next;

            i++;
            tail = tail.next;

            if(tail != null) nth = nth.next;
        }

        previous.next = nth.next;

        return head == nth ? head.next : head;
    }
}
