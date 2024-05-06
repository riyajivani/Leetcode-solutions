class Solution {
    public int longestSubarray(int[] nums) {
        int previousCount = 0, currentCount = 0, maxCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) 
              currentCount++;
            else {
                maxCount = Math.max(maxCount, currentCount + previousCount);
                previousCount = currentCount;
                currentCount = 0;
            }
        }
        maxCount = Math.max(maxCount, currentCount + previousCount);
        return maxCount == nums.length ? maxCount - 1 : maxCount;
    }
}