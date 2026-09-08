package Backtracking.LC0090_SubsetsII;
import java.util.*;

class Solution {

    List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> current = new ArrayList<>();
        Arrays.sort(nums);

        backtrack(0, current, nums);

        return list;
    }

    void backtrack(int index, List<Integer> current, int[] nums){
        list.add(new ArrayList<>(current));

        for(int i = index; i< nums.length; i++){
            if(i != index && nums[i] == nums[i-1]){
                continue;
            }

            current.add(nums[i]);

            backtrack(i+1, current, nums);
            
            current.remove(current.size()-1);
            
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 2};
        List<List<Integer>> result = solution.subsetsWithDup(nums);
        System.out.println(result); // Output: [[], [1], [1, 2], [1, 2, 2], [2], [2, 2]]
    }
}