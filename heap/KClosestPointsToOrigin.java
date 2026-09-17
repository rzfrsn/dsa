/**
 * Pattern : Heap - Top K pattern (max-heap of size k)
 * Idea : compare by squared distance to avoid Math.sqrt() and floating point precision issues
 * Time : O(n log k) | Space : O(k)
 * 973. K Closest Points to Origin
 */
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Queue<int[]> maxHeap = new PriorityQueue<>((a, b) -> (b[0]*b[0] + b[1]*b[1]) - (a[0]*a[0] + a[1]*a[1]));

        for(var p : points) {
            maxHeap.offer(p);
            if(maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        return maxHeap.toArray(new int[k][]);
    }
}
