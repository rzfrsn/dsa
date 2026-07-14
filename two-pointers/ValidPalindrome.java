/**
 * Pattern : Two pointers - symmetric comparison
 * Time : O(n) | Space : O(n)
 * LeetCode 125 — Valid Palindrome
 */
class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder(s.length());
        for(int i=0; i<s.length(); i++) {
            var c = s.charAt(i);
            if(Character.isLetterOrDigit(c)) sb.append(Character.toLowerCase(c));
        }

        String p = sb.toString();
        for(int i=0, j=p.length()-1; i<j; i++, j--) {
            if(p.charAt(i) != p.charAt(j)) return false;
        }

        return true;
    }
}
