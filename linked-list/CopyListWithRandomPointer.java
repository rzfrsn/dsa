/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
class Solution {
    /**
     * Pattern : Linked List - HashMap mapping old node to new node (two-pass)
     * Time : O(n) | Space : O(n)
     * LeetCode 138 - Copy List with Random Pointer
     */
    public Node copyRandomList(Node head) {
        Node dummy = new Node(0);
        Node copy = dummy, tail = head;
        Map<Node, Node> map = new HashMap<>();

        while(tail != null) {
            copy.next = new Node(tail.val);
            copy = copy.next;
            map.put(tail, copy);
            tail = tail.next;
        }

        tail = head;
        copy = dummy.next;
        while(tail != null) {
            copy.random = map.getOrDefault(tail.random, null);
            tail = tail.next;
            copy = copy.next;
        }

        return dummy.next;
    }
}
