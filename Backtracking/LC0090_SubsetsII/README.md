# 90. Subsets II

## Problem
LeetCode: https://leetcode.com/problems/subsets-ii/

## Problem Summary
Given an integer array that may contain duplicate values, return all possible subsets without including duplicate subsets.

## Intuition
The approach is similar to generating normal subsets, but duplicates can cause the same subset to be generated multiple times.

Sorting the array puts duplicate values next to each other. During backtracking, if the current element is the same as the previous element, we skip it **when they are at the same recursion level**.

The important condition is:

`i != index && nums[i] == nums[i - 1]`

This skips duplicate choices at the same level while still allowing duplicates to be included in the same subset.

For example, with `[1,2,2]`, we want `[2,2]` to be possible, but we don't want to generate `[2]` twice.

## Approach
1. Sort the array so duplicate values are adjacent.
2. Start backtracking from index `0`.
3. Add the current subset to the result.
4. Iterate through the available elements.
5. If the current element is a duplicate of the previous element **at the same recursion level**, skip it.
6. Add the current element to the subset.
7. Recursively explore elements after it.
8. Remove the element to backtrack and try the next choice.

## Why `i != index` Matters
We only skip duplicates when they occur at the same recursion level.

For `[2,2]`:

- At the first level, the first `2` is chosen.
- At the next level, the second `2` is allowed, producing `[2,2]`.

But at the first level, the second `2` is skipped because choosing it would generate the same subsets as choosing the first `2`.

So:

`[2]` is generated once.

`[2,2]` is still generated.

## Complexity
- **Time:** O(n × 2ⁿ)
- **Space:** O(n) for the recursion stack and current subset, excluding the output.

## Key Takeaways
- Sorting makes duplicate values easy to detect.
- Skip duplicates only when they are choices at the same recursion level.
- `i != index` distinguishes between duplicates at the same level and duplicates used deeper in the recursion.
- Backtracking still follows the same pattern: choose → recurse → undo.