/**
 * Pattern : Heap - Top K pattern (min-heap of size k)
 * Time : O(n log k) | Space : O(k)
 * 215. Kth Largest Element in an Array
 */
class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> minHeap = new PriorityQueue<>();

        for(var n : nums) {
            minHeap.offer(n);
            if(minHeap.size() > k) minHeap.poll();
        }

        return minHeap.peek();
    }
}
