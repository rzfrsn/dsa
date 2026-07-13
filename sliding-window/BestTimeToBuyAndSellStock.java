/**
 * Pattern : Sliding Window — min glissant
 * Time : O(n) | Space : O(1)
 * LeetCode 121 — Best Time to Buy and Sell Stock
  */
class Solution {
    public int maxProfit(int[] prices) {
        int max=0, minPrice=prices[0];
        for(int i=1; i<prices.length; i++) {
            if(minPrice > prices[i]) minPrice = prices[i];
            else max = Math.max(max, prices[i]-minPrice);
        }
        return max;
    }
}
