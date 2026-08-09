package PrefixSum.LC0525_ContiguousArray;

import java.util.HashMap;

public class Solution {

    public int findMaxLength(int[] nums) {

        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                nums[i] = -1;
            }
        }

        int[] prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }

        int maxLength = 0;

        for(int j=0; j<nums.length; j++){
            if(map.containsKey(prefixSum[j])){
                maxLength = Math.max(maxLength, j-map.get(prefixSum[j]));
            }
            else{
                map.put(prefixSum[j],j);
            }
        }

        return maxLength;
    }

    public static void main(String[] args){
        int[] nums = {0,1};
        Solution obj = new Solution();
        System.out.println(obj.findMaxLength(nums));
    }
    
}
