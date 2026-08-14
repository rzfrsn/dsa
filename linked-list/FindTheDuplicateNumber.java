class Solution {
    /**
     * Pattern : LinkedList -  Floyd's Cycle Detection on implicit linked list (array as pointers)
     * Time : O(n) | Space : O(1)
     * LeetCode 287 - Find the Duplicate Number
     */
    public int findDuplicate(int[] nums) {
        // process like nums[idx] -> next
        int slow = nums[0];
        int fast = nums[0];

        // detect the loop
        do {
            slow = nums[slow]; // slow = slow.next;
            fast = nums[nums[fast]]; // fast = fast.next.next;
        } while(slow != fast);

        // as the loop detection can stop at a non duplicated item
        // now let's get the duplicated value
        slow = nums[0];
        while(slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }

    // Yeah but space complexity should be O(1)
    public int findDuplicateV0(int[] nums) {
        int[] freq = new int[nums.length];
        for(var n : nums) {
            if(freq[n-1] > 0) return n;
            freq[n-1]++;
        }

        return 0;
    }
}
