# 523. Continuous Subarray Sum

## Problem
LeetCode: https://leetcode.com/problems/continuous-subarray-sum/

## Problem Summary
Given an integer array `nums` and an integer `k`, determine whether there exists a continuous subarray of length at least `2` whose sum is a multiple of `k`.

## Intuition
We can use prefix sums and remainders to avoid calculating the sum of every possible subarray.

Suppose two prefix sums have the same remainder when divided by `k`.

For example, if:

- Earlier prefix sum % k = `r`
- Current prefix sum % k = `r`

Then their difference is divisible by `k`.

That difference represents the sum of the subarray between those two positions, so that subarray has a sum that is a multiple of `k`.

The important part is that the subarray must contain at least two elements. Therefore, when we find the same remainder again, we check whether the distance between the current index and the first occurrence of that remainder is greater than `1`.

We store only the first occurrence of each remainder because an earlier occurrence gives us the longest possible subarray.

## Approach
1. Create a HashMap to store the first index at which each remainder appears.
2. Store `0 → -1` initially.
   - `0` represents a prefix sum with remainder `0`.
   - `-1` represents the position before the array starts.
   - This allows subarrays starting from index `0` to be handled correctly.
3. Maintain a running `prefixSum`.
4. For every element:
   - Add the element to `prefixSum`.
   - Calculate the normalized remainder:
     `((prefixSum % k) + k) % k`
5. If the remainder has appeared before:
   - Calculate the length of the subarray using:
     `currentIndex - firstIndex`
   - If the length is at least `2`, return `true`.
6. If the remainder has not appeared before, store its current index.
7. Return `false` if no valid subarray is found.

## Why Store Only the First Occurrence?
Suppose a remainder first appears at index `2` and appears again at index `7`.

The subarray length is:

`7 - 2 = 5`

If the same remainder appears again at index `10`, using the first occurrence gives:

`10 - 2 = 8`

which is longer.

Therefore, once a remainder has been stored, we never replace its index.

## Why Does the Same Remainder Work?
Suppose two prefix sums are:

`prefix1 = 14`  
`prefix2 = 24`

and `k = 5`.

Both have the same remainder:

`14 % 5 = 4`  
`24 % 5 = 4`

Their difference is:

`24 - 14 = 10`

and `10` is divisible by `5`.

That difference represents the sum of the subarray between the two prefix sums.

## Complexity
- **Time:** O(n)
- **Space:** O(k)

## Key Takeaways
- Equal prefix sum remainders indicate that the subarray between them has a sum divisible by `k`.
- Store the first occurrence of each remainder to maximize the subarray length.
- `map.put(0, -1)` handles subarrays that begin at index `0`.
- The index difference must be greater than `1` because the subarray must contain at least two elements.
- Negative numbers require remainder normalization in Java.
- This is another variation of the prefix sum + HashMap pattern, where the exact prefix sum is not important; only its remainder modulo `k` matters.