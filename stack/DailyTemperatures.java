/**
 * Pattern : Monotonic Stack — decreasing
 * Time : O(n) | Space : O(n)
 * LeetCode 739 - Daily Temperatures
 */
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        Deque<Integer> dq = new ArrayDeque<>();

        for(int i = 0; i < temperatures.length; i++) {
            while(!dq.isEmpty() && temperatures[dq.peek()] < temperatures[i]) {
                int idx = dq.pop();
                answer[idx] = i - idx;
            }
            dq.push(i);
        }

        return answer;
    }
}
