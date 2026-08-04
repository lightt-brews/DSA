package HashMap;

import java.util.HashMap;

public class LC0001_TwoSum {
    
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[2];

        for(int i = 0; i<nums.length; i++){
            if(map.containsKey(target-nums[i])){
                ans[0] = i;
                ans[1] = map.get(target-nums[i]);
                return ans;
            }
            else{
                map.put(nums[i], i);
            }
        }
        return ans;
    }

    public static void main(String[] args){
        int[] nums = {2,7,11,15};
        int target = 9;
        int[] result = twoSum(nums,target);
        for(int i : result){
            System.out.print(i + " ");
        }
    }
}
