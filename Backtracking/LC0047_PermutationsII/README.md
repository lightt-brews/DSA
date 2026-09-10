# 47. Permutations II

## Problem
LeetCode: https://leetcode.com/problems/permutations-ii/

## Problem Summary
Given an array that may contain duplicate integers, return all unique permutations of the array. Duplicate permutations should not appear in the result.

## Intuition
The approach is similar to generating normal permutations, but duplicate values can cause the same permutation to be generated multiple times.

First, sort the array so that equal values are next to each other. During backtracking, if the current element is the same as the previous element, we skip it when the previous duplicate has not been used in the current permutation.

The condition:

`nums[i] == nums[i - 1] && !used[i - 1]`

ensures that duplicate values are chosen in a fixed order, preventing duplicate permutations while still allowing duplicates to appear in the same permutation.

## Approach
1. Sort the array so duplicate values are adjacent.
2. Use a `used` array to track elements already included in the current permutation.
3. If the current permutation reaches the length of the array, add it to the result.
4. For every element:
   - Skip it if it is already used.
   - Skip it if it is a duplicate of the previous element and the previous duplicate has not been used.
5. Add the element and mark it as used.
6. Recursively build the remaining permutation.
7. Undo the choice by removing the element and marking it unused.

## Why `!used[i - 1]`?
Consider:

`[1, 1, 2]`

At the same recursion level, choosing the second `1` before the first `1` would produce the same permutations.

So, if the previous `1` has not been used yet, we skip the current `1`.

However, if the previous `1` **is already being used**, we are allowed to choose the second `1`. This is what allows permutations such as:

`[1, 1, 2]`

to be generated.

## Complexity
- **Time:** O(n × n!), in the worst case.
- **Space:** O(n) for the `used` array, current permutation, and recursion stack, excluding the output.

## Key Takeaways
- Sorting is necessary to place duplicates next to each other.
- `used[i]` prevents the same array element from being used twice in one permutation.
- `!used[i - 1]` prevents duplicate permutations at the same recursion level.
- Unlike Subsets II, duplicates are controlled using whether the previous duplicate is currently being used.
- Backtracking follows the pattern: choose → recurse → undo.