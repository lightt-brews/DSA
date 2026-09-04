# 3903. Smallest Stable Index I

## Problem
LeetCode: https://leetcode.com/problems/smallest-stable-index-i/

## Problem Summary
For each index `i`, calculate:

`max(nums[0...i]) - min(nums[i...n-1])`

An index is stable if this value is at most `k`. Return the smallest stable index, or `-1` if none exists. :contentReference[oaicite:0]{index=0}

## Intuition
For every index, we need two values:

- The maximum element from the start up to that index.
- The minimum element from that index to the end.

We can maintain the maximum while traversing from left to right, but finding the suffix minimum repeatedly would take O(n²).

So, we precompute a `suffixMin` array from right to left. Then, during the left-to-right traversal, both required values are available in O(1).

## Approach
1. Build `suffixMin`, where `suffixMin[i]` stores the minimum value from `i` to the end.
2. Traverse `nums` from left to right while maintaining the maximum value seen so far.
3. At each index `i`, calculate:
   `max - suffixMin[i]`
4. If the result is `<= k`, return `i`.
5. If no index satisfies the condition, return `-1`.

## Complexity
- **Time:** O(n)
- **Space:** O(n)

## Key Takeaways
- Use a suffix array when information from the right side is repeatedly needed.
- Maintain the prefix maximum while traversing from left to right.
- Prefix/suffix preprocessing can reduce repeated range calculations from O(n²) to O(n).