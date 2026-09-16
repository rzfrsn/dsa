/**
 * Pattern : Heap - max-heap, simulate repeated max extraction and reinsertion
 * Time : O(n log n) | Space : O(n)
 * 1046. Last Stone Weight
 */
class Solution {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for(var s : stones) maxHeap.offer(s);

        while(!maxHeap.isEmpty() && maxHeap.size() > 1) {
            int y = maxHeap.poll(), x = maxHeap.poll();
            if(y != x) maxHeap.offer(y - x);
        }

        return maxHeap.isEmpty() ? 0 : maxHeap.poll();
    }
}
