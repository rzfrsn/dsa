/**
 * Pattern : Deque as Stack (LIFO) - matching pairs
 * Time : O(n) | Space : O(n)
 * LeetCode 20 - Valid Parentheses
 */
class Solution {
    public boolean isValid(String s) {
        if(s.length() % 2 != 0) return false;

        Deque<Character> stack = new ArrayDeque<>();
        for(char c : s.toCharArray()) {
            if(c == '(' || c == '{' || c == '[') {
                stack.push(c);
                continue;
            }
            if(stack.isEmpty()) return false;

            char top = stack.pop();
            if(c == ')' && top != '(') return false;
            if(c == ']' && top != '[') return false;
            if(c == '}' && top != '{') return false;
        }

        return stack.isEmpty();
    }
}
