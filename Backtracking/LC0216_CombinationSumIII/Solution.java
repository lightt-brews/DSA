package Backtracking.LC0216_CombinationSumIII;
import java.util.*;

class Solution {

    List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> current = new ArrayList<>();
        backtrack(k, n, 1, current);
        return list;
    }

    void backtrack(int k, int n, int start, List<Integer> current) {

        if(current.size() == k){
            if(n == 0){
                list.add(new ArrayList<>(current));
            }
            return;
        }

        for(int i = start; i <= Math.min(9, n); i++){
            current.add(i);

            backtrack(k, n - i, i + 1, current);

            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int k = 3;
        int n = 7;
        List<List<Integer>> result = solution.combinationSum3(k, n);
        System.out.println(result);
    }
}