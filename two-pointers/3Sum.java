/**
 * Pattern : Two Pointers + outer loop — 3Sum reduces to Two Sum II
 * Time : O(n²) | Space : O(1)
 * LeetCode 15 - 3Sum
 */
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> rs = new ArrayList<>();
        Arrays.sort(nums);

        for(int k = 0; k < nums.length; k++) {
            if(k>0 && nums[k] == nums[k-1]) continue;
            int i = k+1, j = nums.length-1;
            while(i<j) {
                int sum = nums[k] + nums[i] + nums[j];
                if(sum == 0) {
                    List<Integer> triplet = new ArrayList<>();
                    triplet.addAll(List.of(nums[k],nums[i],nums[j]));
                    rs.add(triplet);
                    while(i<j && nums[i] == nums[i+1]) i++;
                    while(i<j && nums[j] == nums[j-1]) j--;
                    i++; j--;
                } else if(sum > 0) j--;
                else i++;
            }
        }

        return rs;
    }
}
