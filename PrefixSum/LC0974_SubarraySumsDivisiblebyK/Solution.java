package PrefixSum.LC0974_SubarraySumsDivisiblebyK;

import java.util.HashMap;

public class Solution {

    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);

        int prefixSum = 0;
        int count = 0;

        for(int i=0; i<nums.length; i++){
            prefixSum += nums[i];
            int rem = (prefixSum % k + k) % k;
            if(map.containsKey(rem)){
                count += map.get(rem);
            }
            map.put(rem , map.getOrDefault(rem, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = {4,5,0,-2,-3,1};
        int k = 5;
        Solution obj = new Solution();
        System.out.println(obj.subarraysDivByK(nums, k));
    }
    
}
