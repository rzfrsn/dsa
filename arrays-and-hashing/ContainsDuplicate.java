/**
 * Pattern : HashSet
 * Time : O(n) | Space : O(n)
 * LeetCode 217 — Contains Duplicate
 */
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(var num : nums) {
            if(set.contains(num)) return true;
            set.add(num);
        }
        return false;
    }
}
