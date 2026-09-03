# 904. Fruit Into Baskets

## Problem
LeetCode: https://leetcode.com/problems/fruit-into-baskets/

## Problem Summary
Given an array where each element represents a type of fruit, find the maximum number of fruits that can be collected from a contiguous section of the array.

You have two baskets, and each basket can hold only one type of fruit. Therefore, the selected section can contain at most two distinct fruit types.

## Intuition
This is a sliding window problem.

We want the longest contiguous subarray containing at most two distinct values.

As we move the right pointer, we add each fruit type to a HashMap and keep track of its frequency. If the window contains more than two different fruit types, it becomes invalid, so we move the left pointer forward and remove fruits from the window until only two types remain.

At every step, the window represents a valid selection, so we keep track of its maximum length.

## Approach
1. Create a HashMap to store the frequency of each fruit type in the current window.
2. Initialize `left = 0` and `maxLength = 0`.
3. Move the `right` pointer through the array.
4. Add `fruits[right]` to the HashMap and increase its frequency.
5. If the HashMap contains more than two distinct fruit types:
   - Remove `fruits[left]` from the window.
   - Decrease its frequency in the HashMap.
   - If its frequency becomes `0`, remove it from the HashMap.
   - Move `left` forward.
6. Calculate the current window length:
   `right - left + 1`
7. Update `maxLength`.
8. Return `maxLength`.

## Example
For:

`fruits = [1,2,1,2,3]`

The longest valid window is:

`[1,2,1,2]`

It contains only two distinct fruit types: `1` and `2`.

Its length is `4`, so the answer is `4`.

When `3` enters the window, there are three distinct fruit types. We then move the left pointer forward until only two types remain.

## Why Sliding Window Works
The condition for a valid window is simple:

`number of distinct fruit types <= 2`

When the condition is satisfied, we try to expand the window.

When it is violated, we shrink the window from the left until it becomes valid again.

Since both pointers only move forward, every element is added and removed at most once.

## Complexity
- **Time:** O(n)
- **Space:** O(1), since the HashMap contains at most three fruit types while processing the window.

## Key Takeaways
- "Longest subarray with at most `k` distinct elements" is a classic sliding window pattern.
- Use a HashMap when you need both the number of distinct values and their frequencies.
- Expand the window when it is valid and shrink it when it becomes invalid.
- Remove a key from the HashMap when its frequency reaches `0`.
- The same pattern can be generalized to many problems involving a maximum number of distinct elements.