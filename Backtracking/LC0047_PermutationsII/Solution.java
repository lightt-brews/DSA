import java.util.*;

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> current = new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(used, nums, current, list);
        return list;
    }

    void backtrack(boolean[] used, int[] nums, List<Integer> current, List<List<Integer>> list){
        if(current.size() == nums.length){
            list.add(new ArrayList<>(current));
        }

        for(int i =0; i<nums.length; i++){
            if(used[i]){
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])
                continue;

            current.add(nums[i]);
            used[i] = true;
            backtrack(used,nums,current,list);
            used[i] = false;
            current.remove(current.size()-1);
        }
        
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 1, 2};
        List<List<Integer>> result = solution.permuteUnique(nums);
        System.out.println(result);
    }
}