package PrefixSum.LC0523_ContinuousSubarraySum;

import java.util.HashMap;

public class Solution {
    
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);

        int prefixSum = 0;

        for(int i=0; i<nums.length; i++){
            prefixSum += nums[i];
            int rem = (prefixSum % k + k) % k;
            if(map.containsKey(rem)){
                if( i-map.get(rem) >1){
                    return true;
                }
            }
            else{
                map.put(rem , i);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = {23,2,4,6,7};
        int k = 6;
        Solution obj = new Solution();
        System.out.println(obj.checkSubarraySum(nums, k));
    }
}
