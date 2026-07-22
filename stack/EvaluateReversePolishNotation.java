/**
 * Pattern : Stack - push operands, pop two on operator, push result back
 * Time : O(n) | Space : O(n)
 * LeetCode 150 - Evaluate Reverse Polish Notation
 */
class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> numbers = new ArrayDeque<>();
        for(var s : tokens) {
            if(isOperation(s)) {
                int b = numbers.pop();
                int a = numbers.pop();
                int result = makeOperation(a, b, s);
                numbers.push(result);
            } else {
                numbers.push(Integer.valueOf(s));
            }
        }

        return numbers.pop();
    }

    protected boolean isOperation(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }

    protected int makeOperation(int a, int b, String op) {
        return switch(op) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> a / b;
            default -> throw new IllegalArgumentException("Unhandled operator : " + op);
        };
    }
}
