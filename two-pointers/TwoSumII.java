/**
 * Pattern : Two pointers - sorted arrays
 * Time : O(n) | Space : O(1)
 * LeetCode 167 - Two Sum II - Input Array Is Sorted
 */
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        int i=0, j=numbers.length-1;
        while(i<j) {
            int t = numbers[i] + numbers[j];
            if(t==target) {
                res[0]=i+1;
                res[1]=j+1;
                return res;
            }
            if(t>target)j--;
            else i++;
        }

        return res;
    }
}
