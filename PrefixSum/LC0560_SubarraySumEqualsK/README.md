# 560. Subarray Sum Equals K

## Problem
LeetCode: https://leetcode.com/problems/subarray-sum-equals-k/

## Problem Summary
Given an integer array `nums` and an integer `k`, find the number of continuous subarrays whose elements add up to `k`.

## Intuition
We can keep track of the sum of all elements from the beginning of the array up to the current position. This is called the prefix sum.

Suppose the current prefix sum is `prefix`. If we want a subarray ending at the current position to have sum `k`, then there must have been an earlier prefix sum equal to:

`prefix - k`

Why?

If the sum up to an earlier position was `prefix - k`, then adding the remaining elements gives:

`prefix - (prefix - k) = k`

So, while traversing the array, we store how many times each prefix sum has appeared in a HashMap. Whenever `prefix - k` is already in the map, every occurrence of that prefix sum represents a valid subarray ending at the current position.

## Approach
1. Initialize a HashMap to store the frequency of each prefix sum.
2. Add `0` to the map with a frequency of `1`. This handles subarrays that start from index `0`.
3. Maintain a running `prefix` sum while traversing the array.
4. For every element:
   - Add the element to `prefix`.
   - Calculate `prefix - k`.
   - Check if `prefix - k` exists in the HashMap.
   - If it exists, add its frequency to `count`.
   - Store the current `prefix` in the HashMap and increase its frequency.
5. Return `count`.

## Complexity
- **Time:** O(n)
- **Space:** O(n)

## Key Takeaways
- A prefix sum represents the sum of all elements seen so far.
- To find a subarray with sum `k`, look for a previous prefix sum equal to `currentPrefix - k`.
- Store the frequency of prefix sums because the same prefix sum can occur multiple times.
- `map.put(0, 1)` is necessary to detect valid subarrays that start at index `0`.
- This prefix sum + HashMap pattern works even when the array contains negative numbers.