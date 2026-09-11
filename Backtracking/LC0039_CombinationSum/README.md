# 39. Combination Sum

## Problem
LeetCode: https://leetcode.com/problems/combination-sum/

## Problem Summary
Given an array of distinct positive integers and a target value, find all unique combinations of numbers that add up to the target. Each number can be used any number of times.

## Intuition
We can build the combination one element at a time using backtracking.

The important part is allowing the same element to be chosen again. After choosing `candidates[i]`, we call the recursive function with `i` rather than `i + 1`, which means the same element is still available.

We also use `start` to make sure we only consider the current element and elements after it. This prevents generating the same combination in different orders.

For example, `[2,3,2]` and `[2,2,3]` represent the same combination, so we only generate one ordering.

## Approach
1. Start with an empty combination and the full `target`.
2. If `target == 0`, the current combination is valid, so add a copy to the result.
3. Iterate through the candidates starting from `start`.
4. Skip a candidate if it is greater than the remaining target.
5. Add the candidate to the current combination.
6. Recursively call with:
   - `target - candidates[i]`
   - `i` as the new start index, allowing the same number to be reused.
7. Remove the candidate to backtrack and try the next possibility.

## Example
For:

`candidates = [2,3,6,7]`  
`target = 7`

Valid combinations are:

`[2,2,3]`  
`[7]`

The recursive call uses `i` instead of `i + 1`, allowing `2` to be selected multiple times.

## Complexity
- **Time:** O(n^t) in the worst case, where `t` depends on the target and the smallest candidate.
- **Space:** O(t) for the recursion stack and current combination, excluding the output.

## Key Takeaways
- `i` instead of `i + 1` allows the same candidate to be reused.
- `start` prevents generating the same combination in different orders.
- Backtracking follows: choose → recurse → undo.
- The remaining `target` represents how much more is needed to complete the combination.