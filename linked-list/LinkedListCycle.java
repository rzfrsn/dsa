/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    /**
     * Pattern : LinkedList
     * - Floyd's Cycle Detection
     * - Tortoise and hare
     * - Two pointers with different moving speed
     * Time : O(n) | Space : O(1)
     * 141. Linked List Cycle
     */
    public boolean hasCycle(ListNode head) {
        var slow = head, fast = head;
        while(fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) return true;
        }

        return false;
    }

    // Time : O(n) | Space : O(1)
    // Issue : modify given data
    public boolean hasCycleV1(ListNode head) {
        ListNode dummy = new ListNode();

        while(head != null && head.next != null) {
            if(head.next == dummy) return true;
            ListNode current = head;
            head = head.next;
            current.next = dummy;
        }

        return false;
    }

    // Time : O(n) | Space : O(n)
    // Follow up : Space complexity could be 0(1)
    public boolean hasCycleV0(ListNode head) {
        Set<ListNode> set = new HashSet<>();

        while(head != null && head.next != null) {
            if(set.contains(head)) return true;
            set.add(head);
            head = head.next;
        }

        return false;
    }
}
