# 2091. Removing Minimum and Maximum From Array

## Problem
LeetCode: https://leetcode.com/problems/removing-minimum-and-maximum-from-array/

## Problem Summary
Given an array of distinct integers, remove both the minimum and maximum elements. In one deletion, we can remove an element from either the front or the back of the array. Return the minimum number of deletions required to remove both elements.

## Intuition
Only the positions of the minimum and maximum elements matter.

Suppose the minimum and maximum are at indices `minIndex` and `maxIndex`. There are three possible ways to remove both elements:

1. Remove both from the front.
2. Remove both from the back.
3. Remove one from the front and the other from the back.

We calculate the number of deletions required for all three possibilities and take the minimum.

Since we only need the positions of the minimum and maximum, we can find them in a single traversal of the array.

## Approach
1. Traverse the array and find:
   - The minimum element and its index.
   - The maximum element and its index.
2. Let `left` be the smaller of the two indices and `right` be the larger one.
3. Calculate the deletions needed for each strategy:
   - **Both from the front:** `right + 1`
   - **Both from the back:** `n - left`
   - **One from each side:** `(left + 1) + (n - right)`
4. Take the minimum of these three values.
5. Return the result.

## Example
For:

`nums = [2, 10, 7, 5, 4, 1, 8, 6]`

The minimum `1` is at index `5` and the maximum `10` is at index `1`.

Let:

`left = 1`  
`right = 5`

The three possibilities are:

- Both from front: `5 + 1 = 6`
- Both from back: `8 - 1 = 7`
- One from each side: `(1 + 1) + (8 - 5) = 5`

Therefore, the minimum number of deletions is `5`.

## Complexity
- **Time:** O(n)
- **Space:** O(1)

## Key Takeaways
- When deletions are allowed only from the ends of an array, the positions of the required elements are important.
- There are only three possible strategies for removing both the minimum and maximum.
- Taking the smaller index as `left` and the larger index as `right` makes the calculations simpler.
- Instead of actually performing deletions, calculate how many elements each strategy would remove.