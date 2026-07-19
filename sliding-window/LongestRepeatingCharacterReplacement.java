/**
 * Pattern : Sliding Window — max letter frequency
 * Time : O(n) | Space : O(1)
 * LeetCode 424 — Longest Repeating Character Replacement
 */
class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int max=0, left=0, maxFreq=0;
        for(int right=0; right<s.length(); right++) {
            count[s.charAt(right) - 'A']++;
            maxFreq = Math.max(maxFreq, count[s.charAt(right) - 'A']);

            while((right - left + 1) - maxFreq > k) {
                count[s.charAt(left) - 'A']--;
                left++;
            }

            max = Math.max(max, right - left + 1);
        }

        return max;
    }
}
