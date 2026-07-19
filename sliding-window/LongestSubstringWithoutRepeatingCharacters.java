/**
 * Pattern : Sliding Window | HashSet
 * Time : O(n) | Space : O(1) chars are not infinite 26+specials (128 chars in ASCII)
 * LeetCode 3 — Longest Substring Without Repeating Characters
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max=0, left=0, right=0;
        Set<Character> set = new HashSet<>(s.length());
        while(left<s.length() && right<s.length()) {
            if(!set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                right++;
                continue;
            }
            max = Math.max(max, set.size());
            set.remove(s.charAt(left));
            left++;
        }

        return Math.max(max, set.size());
    }
}
