# 1658. Minimum Operations to Reduce X to Zero

## Problem
LeetCode: https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/

## Problem Summary
Given an array `nums` and an integer `x`, remove elements only from the left or right until their total sum is exactly `x`. Return the minimum number of operations, or `-1` if it is impossible.

## Intuition
Instead of thinking about which elements to remove, think about which elements we should keep.

If the total sum of the array is `total`, then the elements we keep must have a sum of:

`total - x`

So the problem becomes finding the **longest subarray with sum `total - x`**.

If that subarray has length `L`, then all elements outside it must be removed. Therefore:

`operations = n - L`

Since all elements are positive, we can use a sliding window to find the longest subarray with the required sum.

## Approach
1. Calculate the total sum of the array.
2. Set:
   `needed = total - x`
3. If `needed < 0`, return `-1`.
4. Use a sliding window to find the longest subarray whose sum is exactly `needed`.
5. If the window sum becomes greater than `needed`, move `left` forward until the sum is valid again.
6. Whenever `windowSum == needed`, update the maximum window length.
7. Return:
   `nums.length - maxLength`
8. If no such subarray exists, return `-1`.

## Complexity
- **Time:** O(n)
- **Space:** O(1)

## Key Takeaways
- Convert a "remove from both ends" problem into a "keep the longest middle subarray" problem.
- `total - x` is the sum of the elements we want to keep.
- Because all elements are positive, sliding window can efficiently find the longest subarray with the required sum.
- Maximizing the kept subarray length directly minimizes the number of removals.