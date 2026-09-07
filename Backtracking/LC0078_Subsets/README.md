# 78. Subsets

## Problem
LeetCode: https://leetcode.com/problems/subsets/

## Problem Summary
Given an array of distinct integers, return all possible subsets of the array. The result must include the empty subset and the full array.

## Intuition
For every element, we have a choice: either include it in the current subset or skip it.

Backtracking explores these choices while building the subset. Whenever we reach a particular state, the current subset is already a valid answer, so we add a copy of it to the result.

The `index` tells us where to start looking for the next element, ensuring that we don't reuse elements or generate duplicate subsets.

## Approach
1. Start with an empty `current` subset at index `0`.
2. Add a copy of `current` to the result because every state represents a valid subset.
3. Loop through the elements starting from `index`.
4. Add the current element to `current`.
5. Recursively generate all subsets using elements after the current element.
6. Remove the last element to undo the choice and try the next element.
7. Continue until all possibilities have been explored.

## Complexity
- **Time:** O(n × 2ⁿ)
- **Space:** O(n) for the recursion stack and current subset, excluding the output.

## Key Takeaways
- Backtracking works by making a choice, exploring it, then undoing the choice.
- Every state of `current` is a valid subset, so it can be added directly to the result.
- Passing `i + 1` prevents elements from being reused and maintains the order of selection.
- An array of `n` elements has `2ⁿ` possible subsets.