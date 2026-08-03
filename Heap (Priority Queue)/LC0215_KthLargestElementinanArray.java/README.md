# 215. Kth Largest Element in an Array

## Problem
LeetCode: https://leetcode.com/problems/kth-largest-element-in-an-array/

## Problem Summary
Given an integer array `nums` and an integer `k`, return the kth largest element in the array. The solution should determine the answer efficiently without necessarily sorting the entire array.

## Intuition
Sorting the entire array works but performs unnecessary work since we only need one element. Quickselect uses the partitioning idea from Quicksort to place a pivot in its correct sorted position. After partitioning, we can determine whether the desired index lies to the left or right of the pivot and continue searching only in that half. Using the Lomuto two-way partition scheme makes this process simple and efficient.

## Approach
1. Convert the problem into finding the element at index `nums.length - k` in the sorted order.
2. Choose a pivot (commonly the last element) and partition the array using the Lomuto partition scheme.
3. After partitioning:
   - Elements smaller than the pivot are placed on its left.
   - Elements greater than or equal to the pivot are placed on its right.
4. Compare the pivot's final index with the target index.
   - If they match, return the pivot.
   - If the target lies on the left, recursively (or iteratively) search the left partition.
   - Otherwise, search the right partition.
5. Repeat until the target index is found.

## Complexity
- **Average Time:** O(n)
- **Worst Time:** O(n²)
- **Space:** O(1) (iterative) or O(log n) average recursion stack

## Key Takeaways
- Quickselect finds a specific order statistic without fully sorting the array.
- The Lomuto two-way partition places the pivot in its correct sorted position after each partition.
- After every partition, only one side of the array needs to be processed, making it faster than Quicksort for this problem on average.
- Choosing a random pivot helps avoid the worst-case O(n²) performance on already ordered inputs.