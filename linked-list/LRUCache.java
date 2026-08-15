/**
 * Pattern : Double Linked List - LRU Cache (this one was 🥵)
 * Time : O(1) per operation | Space : O(n)
 * LeetCode 146 - LRU Cache
 */
class LRUCache {
    private int capacity;
    private Map<Integer, Node> map;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>(capacity);
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.previous = head;
    }

    public int get(int key) {
        if(!map.containsKey(key)) return -1;

        var node = map.get(key);
        remove(node);
        insertAtTail(node);

        return node.value;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)) {
            var node = map.get(key);
            node.value = value;
            remove(node);
            insertAtTail(node);

            return;
        }

        if(map.size() == capacity) {
            var lru = head.next;
            remove(lru);
            map.remove(lru.key);
        }

        var node = new Node(key, value);
        insertAtTail(node);
        map.put(key, node);
    }

    private void remove(Node node) {
        node.previous.next = node.next;
        node.next.previous = node.previous;
    }

    private void insertAtTail(Node node) {
        node.previous = tail.previous;
        node.next = tail;
        tail.previous.next = node;
        tail.previous = node;
    }

    private class Node {
        int key;
        int value;
        Node previous;
        Node next;

        Node() {
            key = 0;
            value = 0;
            previous = null;
            next = null;
        }

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            previous = null;
            next = null;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
