class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = 0;
        int minDiff = Integer.MAX_VALUE;
        int n = nums.length;

        for(int i=0; i<n-2; i++){
            int l = i+1, r= n-1;

            while(l<r){
                int currSum = nums[i] + nums[l] + nums[r];

                if(Math.abs(currSum-target) < minDiff){
                    minDiff = Math.abs(currSum-target);
                    res = currSum;
                }
                else if(Math.abs(currSum-target) == minDiff){
                    res = Math.max(res, currSum);
                }

                if(currSum > target) r--;
                else l++;
            }
        }
        return res;
    }
}