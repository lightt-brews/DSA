# 216. Combination Sum III

## Problem
LeetCode: https://leetcode.com/problems/combination-sum-iii/

## Problem Summary
Find all combinations of exactly `k` distinct numbers from `1` to `9` whose sum is equal to `n`. Each number can be used at most once.

## Intuition
We can build the combination using backtracking, choosing numbers from `1` to `9`.

The `start` value ensures that every next number is larger than the previous one, so numbers cannot be reused and the same combination cannot be generated in a different order.

We stop when `k` numbers have been chosen. If their remaining sum is `0`, the combination is valid.

## Approach
1. Start with an empty combination, target sum `n`, and `start = 1`.
2. If `k` numbers have been selected:
   - Add the combination if the remaining sum is `0`.
   - Otherwise, return.
3. Try every number from `start` to `min(9, n)`.
4. Add the number to the current combination.
5. Recursively continue with:
   - `n - i` as the remaining sum.
   - `i + 1` as the next starting number.
6. Remove the number to backtrack and try the next choice.

## Why `i + 1`?
Each number from `1` to `9` can only be used once.

After choosing `i`, starting the next recursion from `i + 1` means `i` cannot be selected again.

It also keeps the numbers in increasing order, so `[1,2,4]` is generated but `[2,1,4]` is never considered separately.

## Complexity
- **Time:** O(C(9, k) × k), since there are at most `C(9, k)` possible combinations and copying a valid combination takes O(k).
- **Space:** O(k) for the recursion stack and current combination, excluding the output.

## Key Takeaways
- Backtracking can efficiently explore combinations when the available set is small.
- `i + 1` prevents number reuse and duplicate orderings.
- The combination must satisfy two conditions: exactly `k` numbers and sum equal to `n`.
- Limiting the loop to `Math.min(9, n)` avoids choosing numbers larger than the remaining sum.