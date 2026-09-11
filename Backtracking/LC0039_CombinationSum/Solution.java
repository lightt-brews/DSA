package Backtracking.LC0039_CombinationSum;
import java.util.*;

class Solution {

    List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<Integer> current = new ArrayList<>();
        backtrack(candidates,target,0,list,current);
        return list;
        
    }
    
    void backtrack(int[] candidates, int target, int start, List<List<Integer>> list, List<Integer> current){
        if(target == 0){
            list.add(new ArrayList<>(current));
            return;
        }

        for(int i =start;i<candidates.length;i++){
            if(candidates[i]>target){
                continue;
            }
            current.add(candidates[i]);
            backtrack(candidates,target-candidates[i], i, list, current);
            current.remove(current.size()-1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] candidates = {2,3,6,7};
        int target = 7;
        List<List<Integer>> result = solution.combinationSum(candidates, target);
        System.out.println(result);
    }
}