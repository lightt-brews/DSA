package PrefixSum.LC0724_FindPivotIndex;

public class Solution {
    public int pivotIndex(int[] nums) {
        int len = nums.length;
        int[] prefixSum = nums;
        for(int i=1; i<len; i++){
            prefixSum[i] = prefixSum[i-1] + nums[i];
        }
        int total_sum = prefixSum[len-1];

        if(total_sum-nums[0] == 0){
            return 0;
        }

        for(int j =1; j<nums.length; j++){
            if(total_sum-prefixSum[j] == prefixSum[j-1]){
                return j;
            }
        }

        return -1;
    }

    public static void main(String[] args){
        int[] nums = {1,7,3,6,5,6};
        Solution obj = new Solution();
        System.out.println(obj.pivotIndex(nums));
    }
}
