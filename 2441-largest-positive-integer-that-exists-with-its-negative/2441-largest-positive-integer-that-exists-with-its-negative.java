class Solution {
    public int findMaxK(int[] nums) {
        int ans = -1;
        
        for (int i : nums) {
            for (int j : nums) {
                // If there exists a number j such that i is the negative of j
                if (i == -j) {
                    // Update the answer to the maximum of current ans and absolute value of i
                    ans = Math.max(ans, Math.abs(i));
                }
            }
        }

        return ans;
    }
}