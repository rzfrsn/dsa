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
     * Pattern : LinkedList - find mid, reverse second half, merge alternately
     * Time : O(n) | Space : O(1)
     * 143. Reorder List
     */
    public void reorderList(ListNode head) {
        // Find mid
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse half
        ListNode second = reverseList(slow);
        ListNode first = head;

        // Merge alternaly
        while(second.next != null) {
            ListNode temp1 = first.next;
            first.next = second;
            first = temp1;

            ListNode temp2 = second.next;
            second.next = first;
            second = temp2;
        }

    }

    public ListNode reverseList(ListNode head) {
        ListNode current = head, previous = null;

        while(current != null ) {
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        return previous;
    }

    // yeah but without harnessing Linked List knowledge
    public void reorderListV0(ListNode head) {
        List<ListNode> arr = new ArrayList<>();
        var tail = head;
        while(tail != null) {
            arr.add(tail);
            tail = tail.next;
        }

        ListNode dummy = new ListNode();
        tail = dummy;
        for(int i=0, j=arr.size()-1; i<=j; i++, j--) {
            tail.next = arr.get(i);
            tail = tail.next;
            if(i != j) {
                tail.next = arr.get(j);
                tail = tail.next;
            }
        }

        tail.next = null;
        head = dummy.next;
    }
}
