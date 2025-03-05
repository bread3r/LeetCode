public class Solution {
    
    public static int[] twoSum(int[] nums, int target) {
        int res[] = new int[2];
        boolean founded = false;
        for(int i = 0 ; i < nums.length - 1 && !founded; ++ i)
            for(int j = i+1; j < nums.length && !founded; ++j)
                if(nums[i] + nums[j] == target){
                    res[0] = i;
                    res[1] = j;
                    founded = true;
                }
        return res;
    }
}