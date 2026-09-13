import java.util.*;

class Solution {

    List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> current = new ArrayList<>();
        Arrays.sort(candidates);

        backtrack(0,target,candidates,list,current);

        return list;
    }

    void backtrack(int start, int target, int[] candidates, List<List<Integer>> list, List<Integer> current){
        if(target == 0){
            list.add(new ArrayList<>(current));
            return;
        }

        for(int i = start; i<candidates.length; i++){
            if(candidates[i] > target){
                continue;
            }
            if(i > start && candidates[i] == candidates[i-1]){
                continue;
            }
            current.add(candidates[i]);
            backtrack(i+1,target - candidates[i], candidates, list, current);
            current.remove(current.size()-1);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        List<List<Integer>> result = s.combinationSum2(candidates, target);
        System.out.println(result);
    }
}