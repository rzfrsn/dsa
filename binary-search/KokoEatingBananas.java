/**
 * Pattern : Binary Search on answer space - monotonic predicate
 * Time : O(n log m) | Space : O(1)
 * LeetCode 875 - Koko Eating Bananas
 */
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = max(piles);

        while(left <= right) {
            int mid = left + (right - left) / 2;

            if(canFinish(piles, mid, h)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean canFinish(int[] piles, int k, int h) {
        long totalHours = 0;
        for (int p : piles) {
            totalHours += (p + k - 1) / k;
            if (totalHours > h) {
                return false;
            }
        }

        return totalHours <= h;
    }

    int max(int[] piles) {
        int m = 0;
        for(var p : piles) {
            m = Math.max(m, p);
        }

        return m;
    }
}
