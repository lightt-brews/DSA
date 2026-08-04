# 215. Kth Largest Element in an Array

## Problem
LeetCode: https://leetcode.com/problems/kth-largest-element-in-an-array/

## Problem Summary
Given an integer array `nums` and an integer `k`, return the kth largest element in the array. The solution should determine the answer efficiently without sorting the entire array.

## Solution 1: Quickselect (Lomuto Two-Way Partition)

### Intuition
Instead of sorting the entire array, Quickselect repeatedly places a pivot in its correct sorted position. After partitioning, only one side of the array can contain the target element, allowing us to discard the other half. The Lomuto partition scheme divides the array into two regions based on the pivot.

### Approach
1. Convert the problem into finding the element at index `nums.length - k`.
2. Choose a pivot (typically the last element).
3. Partition the array using the Lomuto partition scheme:
   - Elements smaller than the pivot go to the left.
   - Elements greater than or equal to the pivot remain on the right.
4. Compare the pivot's final position with the target index.
5. Continue searching only in the relevant partition until the target is found.

### Complexity
- **Average Time:** O(n)
- **Worst Time:** O(n²)
- **Space:** O(1) (iterative) or O(log n) average recursion stack

---

## Solution 2: Quickselect (Dutch National Flag / Three-Way Partition)

### Intuition
When the array contains many duplicate values, the standard two-way partition repeatedly processes equal elements. The Dutch National Flag partition solves this by dividing the array into three regions:
- Elements less than the pivot
- Elements equal to the pivot
- Elements greater than the pivot

If the target index falls within the equal region, the answer is found immediately without further recursion.

### Approach
1. Convert the problem into finding the element at index `nums.length - k`.
2. Choose a pivot (preferably random).
3. Partition the array into three sections:
   - `< pivot`
   - `== pivot`
   - `> pivot`
4. Compare the target index with the boundaries of the equal region.
   - If it lies before the equal region, search the left partition.
   - If it lies inside the equal region, return the pivot.
   - Otherwise, search the right partition.
5. Repeat until the answer is found.

### Complexity
- **Average Time:** O(n)
- **Worst Time:** O(n²)
- **Space:** O(1) (iterative) or O(log n) average recursion stack

---

## Comparison

| Feature | Lomuto (2-Way) | Dutch National Flag (3-Way) |
|---------|----------------|-----------------------------|
| Partitions | `< pivot`, `>= pivot` | `< pivot`, `== pivot`, `> pivot` |
| Handles Duplicates | Less efficient | More efficient |
| Recursive Calls | May revisit equal elements | Skips equal elements entirely |
| Average Time | O(n) | O(n) |
| Best Use Case | Arrays with distinct values | Arrays with many duplicate values |

## Key Takeaways
- Quickselect finds the kth largest element without fully sorting the array.
- Lomuto partition is simpler and works well for most cases.
- Dutch National Flag partition is more efficient when duplicate values are frequent.
- Random pivot selection significantly reduces the chance of worst-case performance.
- Both approaches have an average time complexity of O(n), but the three-way partition often performs better in practice on arrays with duplicates.