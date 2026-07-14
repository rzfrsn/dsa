/**
 * Pattern : HashMap
 * Time : O(n) | Space : O(n)
 * LeetCode 1 — Two Sum
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            int expect = target - nums[i];
            if(map.containsKey(expect)) {
                return new int[]{map.get(expect), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }
}
