/**
 * Pattern : HashSet - sequence start filter
 * Time : O(n) | Space : O(n)
 * LeetCode 128 - Longest Consecutive Sequence
 */
class Solution {
    public int longestConsecutive(int[] nums) {
        int max = 0;
        Set<Integer> set = new HashSet<>(nums.length);
        for(var n : nums) set.add(n);

        for(var n : set) {
            if(!set.contains(n-1)) {
                int cnt=1;
                int current = n;
                while(set.contains(++current)) cnt++;
                if(cnt>max) max = cnt;
            }
        }

        return max;
    }
}
