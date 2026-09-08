# 46. Permutations

## Problem
LeetCode: https://leetcode.com/problems/permutations/

## Problem Summary
Given an array of distinct integers, return all possible permutations of the array. A permutation is an arrangement where every element appears exactly once, but the order can be different.

## Intuition
At every position in the permutation, we can choose any element that has not been used yet.

We maintain a `used` array to keep track of which elements are already in the current permutation. When the current permutation reaches the same length as the input, it is complete and can be added to the result.

After exploring a choice, we undo it so that the element can be used in a different position.

## Approach
1. Create a `used` array to track which elements are already in the current permutation.
2. Start backtracking with an empty `current` list.
3. If `current` contains all elements, add a copy of it to the result.
4. Otherwise, try every element:
   - Skip it if it is already used.
   - Add it to `current` and mark it as used.
   - Recursively build the rest of the permutation.
   - Undo the choice by removing it and marking it unused.
5. Continue until all possible arrangements are generated.

## Complexity
- **Time:** O(n × n!), since there are `n!` permutations and copying each completed permutation takes O(n).
- **Space:** O(n) for the `used` array, current permutation, and recursion stack, excluding the output.

## Key Takeaways
- Permutations require every element to be used exactly once.
- A `used` array prevents an element from appearing more than once in the same permutation.
- Backtracking follows the pattern: choose → recurse → undo.
- For `n` distinct elements, there are `n!` possible permutations.