# 17. Letter Combinations of a Phone Number

## Problem
LeetCode: https://leetcode.com/problems/letter-combinations-of-a-phone-number/

## Problem Summary
Given a string containing digits from `2` to `9`, return all possible letter combinations that the digits can represent using the letters assigned to each digit on a phone keypad.

## Intuition
Each digit represents a set of possible letters. For every digit, we choose one of its letters and move to the next digit.

Backtracking naturally fits this because we make one choice for each digit, and once a letter has been chosen, we recursively build the rest of the combination.

For example, for `"23"`:

- `2` → `a, b, c`
- `3` → `d, e, f`

Choosing `a` gives `ad`, `ae`, `af`, then we backtrack and try `b`, and so on.

## Approach
1. Store the letters corresponding to each digit in a string array.
2. Start backtracking from index `0` with an empty string.
3. Get the letters corresponding to the current digit.
4. Try each available letter:
   - Add it to the current combination.
   - Recursively move to the next digit.
5. When `index` reaches the length of `digits`, the combination is complete, so add it to the result.
6. Return all generated combinations.

## Complexity
- **Time:** O(4ⁿ × n), where `n` is the number of digits. Each digit has at most 4 possible letters, and storing each combination takes O(n).
- **Space:** O(n) for the recursion depth and current combination, excluding the output.

## Key Takeaways
- Backtracking is useful when each position has multiple choices and we need all possible combinations.
- Each recursion level represents one digit.
- The `index` determines which digit we are currently processing.
- The recursion stops when every digit has been assigned a letter.