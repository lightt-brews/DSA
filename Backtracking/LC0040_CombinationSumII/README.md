# 40. Combination Sum II

## Problem
LeetCode: https://leetcode.com/problems/combination-sum-ii/

## Problem Summary
Given an array of integers that may contain duplicates and a target value, find all unique combinations whose elements add up to the target. Each element can be used at most once.

## Intuition
This is similar to Combination Sum, but there are two important differences:

- Each element can only be used once.
- Duplicate combinations are not allowed.

We sort the array so that duplicate values are next to each other. During backtracking, if the current value is the same as the previous value **at the same recursion level**, we skip it.

To make sure an element is used only once, the recursive call starts from `i + 1`.

## Approach
1. Sort the `candidates` array.
2. Start backtracking with `start = 0`.
3. If `target == 0`, add the current combination to the result.
4. Iterate from `start` through the remaining elements.
5. Skip duplicate values when:
   `i > start && candidates[i] == candidates[i - 1]`
6. If the current value is greater than the remaining target, skip it.
7. Add the current value to the combination.
8. Recursively call with `i + 1` so the same element cannot be reused.
9. Remove the element to backtrack and try the next choice.

## Why `i > start`?
We only want to skip duplicates at the **same recursion level**.

For example:

`[1,1,2]`

At the same level, choosing the first `1` and choosing the second `1` would generate duplicate combinations, so the second one is skipped.

But after choosing the first `1`, we are allowed to choose the second `1` at the next recursion level. This allows combinations such as `[1,1]`.

## Complexity
- **Time:** O(2ⁿ) in the worst case.
- **Space:** O(n) for the recursion stack and current combination, excluding the output.

## Key Takeaways
- Sorting makes it possible to detect duplicate values easily.
- `i > start` ensures duplicates are skipped only at the same recursion level.
- `i + 1` ensures every array element is used at most once.
- Combination Sum uses `i` because elements can be reused; Combination Sum II uses `i + 1` because they cannot.
- Backtracking follows: choose → recurse → undo.