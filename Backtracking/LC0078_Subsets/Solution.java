package Backtracking.LC0078_Subsets;
import java.util.ArrayList;
import java.util.List;

class Solution {

    List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {

        List<Integer> current = new ArrayList<>();

        backtrack(0, current, nums);
        return list;
    }

    void backtrack(int index, List<Integer> current, int[] nums){

        list.add(new ArrayList<>(current));

        for(int i= index; i<nums.length; i++){
            current.add(nums[i]);

            backtrack(i+1 , current, nums);

            current.remove(current.size()-1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = solution.subsets(nums);
        System.out.println(result); // Output: [[], [1], [1, 2], [1, 2, 3], [1, 3], [2], [2, 3], [3]]
    }
}