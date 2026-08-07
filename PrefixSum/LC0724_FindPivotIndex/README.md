# 724. Find Pivot Index

## Problem
LeetCode: https://leetcode.com/problems/find-pivot-index/

## Problem Summary
Given an integer array `nums`, return the pivot index where the sum of all elements to the left is equal to the sum of all elements to the right. If no such index exists, return `-1`. If multiple pivot indices exist, return the leftmost one.

## Intuition
Instead of repeatedly calculating the left and right sums for every index, we can precompute prefix sums. Once the prefix sum array is built, the left sum and right sum for any index can be obtained in constant time, allowing us to efficiently check whether an index is a pivot.

## Approach
1. Build a prefix sum array where each element stores the sum of all elements from the beginning up to that index.
2. Store the total sum using the last element of the prefix sum array.
3. Check the first index separately since it has no left side.
4. For every remaining index:
   - The left sum is `prefixSum[i - 1]`.
   - The right sum is `totalSum - prefixSum[i]`.
5. Return the first index where the left and right sums are equal.
6. If no such index exists, return `-1`.

## Complexity
- **Time:** O(n)
- **Space:** O(1) extra space (the prefix sum is built in-place by modifying the input array).

## Key Takeaways
- Prefix sums allow range sum queries to be answered in constant time after preprocessing.
- The left sum and right sum can both be derived from the prefix sum array without additional loops.
- Building the prefix sum in-place reduces extra memory usage.
- Always handle boundary cases, such as the first index having no left-side elements.