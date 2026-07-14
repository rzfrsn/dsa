/**
 * Pattern : Heap (PriorityQueue) - min Heap
 * Time : O(n log k) | Space : O(n)
 * LeetCode 347 - Top K Frequent Elements
 */
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(var num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> map.get(a) - map.get(b));
        for(var key : map.keySet()) {
            pq.offer(key);
            if(pq.size() > k) pq.poll();
        }

        int[] result = new int[k];
        for(int i=0; i<k; i++) {
            result[i] = pq.poll();
        }

        return result;
    }
}
