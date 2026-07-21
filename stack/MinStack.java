/**
 * Pattern : Deque as Stack (LIFO) - Min Stack
 * Time : O(1) per operation | Space : O(n)
 * LeetCode 155 - Min Stack
 */
class MinStack {
    Integer min;
    Deque<Integer> stack = new ArrayDeque<>();
    Deque<Integer> minStore = new ArrayDeque<>();
    public MinStack() {
        min = null;
    }

    public void push(int value) {
        stack.push(value);
        if(min == null || value <= min) {
            min = value;
            minStore.push(min);
        }
    }

    public void pop() {
        var popped = stack.pop();
        if(min.equals(popped)) {
            minStore.pop();
            if(!minStore.isEmpty()) min = minStore.peek();
            else min = null;
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
