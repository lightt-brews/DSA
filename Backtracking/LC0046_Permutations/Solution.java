package Backtracking.LC0046_Permutations;
import java.util.*;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(list, new ArrayList<>(), nums, used);
        
        return list;
    }

    void backtrack(List<List<Integer>> list, List<Integer> current, int[] nums, boolean[] used){
        if(current.size()==nums.length){
            list.add(new ArrayList<>(current));
        }
        else{
            for(int i=0;i<nums.length;i++){
                if(used[i]) continue;
                current.add(nums[i]);
                used[i] = true;
                backtrack(list,current,nums, used);
                used[i] = false;
                current.remove(current.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = solution.permute(nums);
        System.out.println(result); // Output: [[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], [3, 2, 1]]
    }
}