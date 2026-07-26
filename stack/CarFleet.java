/**
 * Pattern : Monotonic Stack - increasing (fleet arrival times)
 * Time : O(n log n) | Space : O(n)
 * LeetCode 853 - Car Fleet
 */
class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;

        int[][] cars = new int[n][2];
        for(int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }
        Arrays.sort(cars, (a,b) -> b[0] - a[0]);

        double[] times = new double[n];
        for(int i = 0; i < n; i++) {
            times[i] = (double)(target - cars[i][0]) / cars[i][1];
        }

        Deque<Double> stack = new ArrayDeque<>(n);
        for(int i = 0; i < n; i++) {
            if(stack.isEmpty() || times[i] > stack.peek()) {
                stack.push(times[i]);
            }
        }

        return stack.size();
    }
}
