package PrefixSum.LC0560_SubarraySumEqualsK;

import java.util.HashMap;

public class Solution {
    
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        map.put(0, 1);

        int prefix = 0;

        for (int i = 0; i < nums.length; i++) {
            prefix += nums[i];

            int prvSum = prefix - k;

            if (map.containsKey(prvSum)) {
                count += map.get(prvSum);
            }

            map.put(prefix, map.getOrDefault(prefix, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1};
        int k = 2;
        Solution obj = new Solution();
        System.out.println(obj.subarraySum(nums, k));
    }

}
