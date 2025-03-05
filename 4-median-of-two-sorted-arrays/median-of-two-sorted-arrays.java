class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalLength = nums1.length + nums2.length;
        int midIndex1 = (totalLength - 1) / 2;
        int midIndex2 = totalLength / 2;
        
        int i = 0, j = 0, current = 0;
        int median1 = 0, median2 = 0;
        
        while (i + j <= midIndex2) {
            int value;
            if (i < nums1.length && (j >= nums2.length || nums1[i] <= nums2[j])) {
                value = nums1[i++];
            } else {
                value = nums2[j++];
            }
            
            if (i + j - 1 == midIndex1) median1 = value;
            if (i + j - 1 == midIndex2) median2 = value;
        }
        
        return (median1 + median2) / 2.0;
    }
}