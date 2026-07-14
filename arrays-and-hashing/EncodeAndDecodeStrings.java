/**
 * Pattern : Length-prefix protocol
 * Time : O(n) | Space : O(n)
 * LeetCode 271 - Encode and Decode Strings
 */
class Solution {
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(var s : strs) {
            sb.append(s.length()).append("#").append(s);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> list = new ArrayList<>();
        int i=0;
        while(i<str.length()) {
            int j = str.indexOf("#",i);
            int len = Integer.parseInt(str.substring(i,j));
            list.add(str.substring(j+1, len+j+1));
            i=len+j+1;
        }

        return list;
    }
}
