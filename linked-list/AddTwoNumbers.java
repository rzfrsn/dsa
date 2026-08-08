import java.math.BigInteger;

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
     * Pattern : LinkedList - digit-by-digit addition with carry
     * Time : O(max(n,m)) | Space : O(max(n,m))
     * 2. Add Two Numbers
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        int carry = 0;

        while(l1 != null || l2 != null || carry != 0) {
            int val1 = (l1 != null) ? l1.val : 0;
            int val2 = (l2 != null) ? l2.val : 0;

            int sum = val1 + val2 + carry;
            carry = sum / 10;
            tail.next = new ListNode(sum % 10);
            tail = tail.next;

            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }

        return dummy.next;
    }

    // Resolve but using BigInteger is not the expected solution
    public ListNode addTwoNumbersV0(ListNode l1, ListNode l2) {
        BigInteger n1 = listToInteger(l1);
        BigInteger n2 = listToInteger(l2);

        return integerToList(n1.add(n2));
    }

    public BigInteger listToInteger(ListNode l) {
        BigInteger n = BigInteger.ZERO;
        BigInteger m = BigInteger.ONE;

        while(l != null) {
            BigInteger digit = BigInteger.valueOf(l.val);
            n = n.add(digit.multiply(m));
            l = l.next;
            m = m.multiply(BigInteger.TEN);
        }

        return n;
    }

    public ListNode integerToList(BigInteger n) {
        ListNode dummy = new ListNode();
        ListNode last = dummy;

        if(n.equals(BigInteger.ZERO)) return dummy;

        while(n.compareTo(BigInteger.ZERO) > 0) {
            BigInteger digit = n.mod(BigInteger.TEN);
            last.next = new ListNode(digit.intValue(), null);
            last = last.next;
            n = n.divide(BigInteger.TEN);
        }

        return dummy.next;
    }
}
