# 1004. Max Consecutive Ones III

## Problem
LeetCode: https://leetcode.com/problems/max-consecutive-ones-iii/

## Problem Summary
Given a binary array `nums` and an integer `k`, find the maximum length of a contiguous subarray that can be turned into all `1`s by flipping at most `k` zeros.

## Intuition
We can use a sliding window to maintain a range that contains at most `k` zeros.

As we expand the window using the right pointer, every `0` requires one flip. If the window contains more than `k` zeros, it is no longer valid, so we move the left pointer forward until the window contains at most `k` zeros again.

At every step, the current window represents a valid subarray, so we can use its length to keep track of the maximum answer.

## Approach
1. Initialize `left = 0`, `zeros = 0`, and `maxLength = 0`.
2. Move the `right` pointer through the array.
3. If `nums[right]` is `0`, increase `zeros`.
4. If `zeros > k`, move `left` forward:
   - If `nums[left]` is `0`, decrease `zeros`.
   - Continue until the window contains at most `k` zeros.
5. Calculate the current window length:
   `right - left + 1`
6. Update `maxLength`.
7. Return `maxLength`.

## Example
For:

`nums = [1,1,1,0,0,0,1,1,1,1,0]`  
`k = 2`

The window can contain at most two zeros.

A longest valid window is:

`[1,1,1,0,0,1,1,1,1]`

The two zeros can be flipped to `1`, giving a length of `9`.

## Why Sliding Window Works
The only thing that makes a window invalid is having more than `k` zeros.

When the window has too many zeros, moving the left pointer removes elements until the number of zeros becomes valid again.

This means we never need to restart the window from scratch. Both pointers only move forward, giving a linear-time solution.

## Complexity
- **Time:** O(n)
- **Space:** O(1)

## Key Takeaways
- A sliding window is useful when a subarray must satisfy a condition such as containing at most `k` zeros.
- The number of zeros in the current window tells us how many flips are required.
- When the number of zeros exceeds `k`, shrink the window from the left.
- The window is always kept valid before calculating its maximum length.
- Both `left` and `right` move only forward, so the overall time complexity is O(n).