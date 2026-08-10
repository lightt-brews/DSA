# 974. Subarray Sums Divisible by K

## Problem
LeetCode: https://leetcode.com/problems/subarray-sums-divisible-by-k/

## Problem Summary
Given an integer array `nums` and an integer `k`, find the number of continuous subarrays whose sum is divisible by `k`.

## Intuition
We can use prefix sums to represent the sum of all elements from the beginning of the array up to the current position.

Suppose the current prefix sum has remainder `r` when divided by `k`.

If an earlier prefix sum also had the same remainder `r`, then the difference between the two prefix sums must be divisible by `k`.

For example, if two prefix sums have remainders `2` when divided by `k`:

- Earlier prefix sum = `... + 2`
- Current prefix sum = `... + 2`

When we subtract them, the remainders cancel out, so their difference is divisible by `k`. That difference represents the sum of the subarray between those two positions.

Therefore, instead of storing every prefix sum, we only need to store how many times each remainder has appeared.

Whenever the current remainder has appeared before, every previous occurrence forms a valid subarray ending at the current index.

## Approach
1. Create a HashMap to store the frequency of each prefix sum remainder.
2. Put remainder `0` into the map with frequency `1`.
   This handles subarrays whose sum from index `0` is already divisible by `k`.
3. Maintain a running `prefixSum`.
4. For every element:
   - Add the element to `prefixSum`.
   - Calculate its remainder when divided by `k`.
   - Normalize the remainder using:
     `((prefixSum % k) + k) % k`
5. If the remainder already exists in the HashMap, add its frequency to `count`.
6. Increase the frequency of the current remainder in the HashMap.
7. Return `count`.

## Why Normalize the Remainder?
In Java, the `%` operator can return a negative remainder when `prefixSum` is negative.

For example:

`-2 % 5 = -2`

But for this problem, `-2` and `3` represent the same remainder class because both are equivalent modulo `5`.

So we use:

`((prefixSum % k) + k) % k`

This always gives a remainder between `0` and `k - 1`.

## Complexity
- **Time:** O(n)
- **Space:** O(k)

## Key Takeaways
- Equal prefix sum remainders mean the difference between those prefix sums is divisible by `k`.
- Therefore, we only need to track the frequency of each remainder rather than every prefix sum.
- `map.put(0, 1)` handles subarrays starting from index `0`.
- Negative numbers require remainder normalization in Java.
- This is a useful variation of the prefix sum + HashMap pattern: instead of looking for an exact previous prefix sum, we look for a previous prefix sum with the same remainder.