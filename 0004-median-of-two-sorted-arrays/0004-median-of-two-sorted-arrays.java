class Solution {

    private int p1 = 0, p2 = 0;

    private int findmin(int[] nums1, int[] nums2) {
        if (p1 < nums1.length && p2 < nums2.length) {
            return nums1[p1] < nums2[p2] ? nums1[p1++] : nums2[p2++];
        } else if (p1 < nums1.length) {
            return nums1[p1++];
        } else {
            return nums2[p2++];
        }
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;

        if((len1 + len2) % 2 == 0)
        {
            for(int i = 0; i < (len1 + len2) / 2 - 1; ++i){
                int tmp = findmin(nums1, nums2);
            }
            return (double) (findmin(nums1,nums2) + findmin(nums1,nums2)) / 2;
        }else
        {
            for(int i = 0; i < (len1 + len2) / 2; ++i){
                int tmp = findmin(nums1, nums2);
            }
            return findmin(nums1,nums2);
        }
    }
}