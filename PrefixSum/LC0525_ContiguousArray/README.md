# 525. Contiguous Array

## Problem
LeetCode: https://leetcode.com/problems/contiguous-array/

## Problem Summary
Given a binary array containing only `0` and `1`, find the maximum length of a contiguous subarray that contains the same number of `0`s and `1`s.

## Intuition
The main difficulty is keeping track of the number of `0`s and `1`s in a subarray efficiently.

We can convert every `0` into `-1` while keeping every `1` as `1`.

Now, a subarray has an equal number of `0`s and `1`s exactly when its sum is `0`.

For example:

`[0, 1, 0, 1]`

becomes:

`[-1, 1, -1, 1]`

The total sum is `0`, meaning there are two `0`s and two `1`s.

We can use prefix sums to find these zero-sum subarrays. If the same prefix sum occurs at two different positions, the elements between those positions must have a sum of `0`.

To get the longest possible subarray, we store only the first index where each prefix sum appears. When the same prefix sum appears again, we calculate the distance between the current index and its first occurrence.

## Approach
1. Replace every `0` in the array with `-1`.
2. Create a prefix sum array.
3. Use a HashMap to store the first index where each prefix sum appears.
4. Initially store:
   `0 → -1`
   
   The `-1` represents the position before the array starts. This allows us to correctly calculate the length of a valid subarray that begins at index `0`.
5. Traverse the prefix sum array:
   - If the current prefix sum has appeared before, the elements between the first occurrence and the current index have a sum of `0`.
   - Calculate the length using:
     `currentIndex - firstIndex`
   - Update the maximum length.
   - If the prefix sum has not appeared before, store its current index.
6. Return the maximum length found.

## Complexity
- **Time:** O(n)
- **Space:** O(n)

## Key Takeaways
- Converting `0` to `-1` turns "equal number of `0`s and `1`s" into a zero-sum subarray problem.
- If the same prefix sum appears twice, the elements between those positions have a sum of `0`.
- Store only the first occurrence of each prefix sum because an earlier index always produces a longer subarray.
- `map.put(0, -1)` handles valid subarrays that start at index `0`.
- This is another useful combination of prefix sums and HashMap.