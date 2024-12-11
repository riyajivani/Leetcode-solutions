class Solution {
    public int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);

        // Sliding window
        int maxCount = 0;
        int winCount = 0;
        int left = 0, right = 0;
        int n = nums.length;

        while (right < n) {
            // Find valid window of max size
            while (right < n && (nums[right] - nums[left]) <= 2 * k) {
                winCount++;
                right++;
            }

            maxCount = Math.max(maxCount, winCount);
            if (right == n) break;

            // Skip left to again make window valid
            while (left <= right && (nums[right] - nums[left]) > 2 * k) {
                winCount--;
                left++;
            }
        }
        return maxCount;
    }
}