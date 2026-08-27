# 567. Permutation in String

## Problem
LeetCode: https://leetcode.com/problems/permutation-in-string/

## Problem Summary
Given two strings `s1` and `s2`, determine whether `s2` contains a substring that is a permutation of `s1`.

A permutation contains exactly the same characters with the same frequencies, but the characters can appear in any order.

## Intuition
A permutation of `s1` must have exactly the same character frequencies as `s1` and must have the same length.

So, instead of generating every possible permutation, we can use a sliding window of size `s1.length()` over `s2`.

For every window, we compare its character frequencies with the frequencies of `s1`. If they are equal, that window is a permutation of `s1`.

As the window moves, we only need to remove the character leaving the window and add the new character entering it.

## Approach
1. Count the frequency of every character in `s1`.
2. Create a sliding window in `s2` with the same length as `s1`.
3. Maintain the frequency of characters inside the current window.
4. Move the right pointer through `s2`.
5. When the window becomes larger than `s1.length()`:
   - Remove the character at the left pointer.
   - Move the left pointer forward.
6. Compare the frequency of the current window with the frequency of `s1`.
7. If both frequency maps are equal, return `true`.
8. If no window matches, return `false`.

## Why Does the Window Have to Be the Same Size?
A permutation of `s1` must contain exactly the same number of characters as `s1`.

For example, if:

`s1 = "ab"`

then the only valid permutations have length `2`, such as:

`"ab"` or `"ba"`

Therefore, while checking `s2`, we only need to consider windows of length `s1.length()`.

## Example
For:

`s1 = "ab"`  
`s2 = "eidbaooo"`

The window eventually becomes:

`"ba"`

The character frequencies are:

`a → 1`  
`b → 1`

which matches the frequency of `s1`, so `"ba"` is a permutation of `"ab"`.

Therefore, the answer is `true`.

## Complexity
- **Time:** O(n), where `n` is the length of `s2`.
- **Space:** O(1), assuming the input contains only lowercase English letters.

## Key Takeaways
- A permutation problem can often be converted into a character-frequency problem.
- Since the required substring has a fixed length, a fixed-size sliding window is a natural fit.
- Instead of creating permutations, compare character frequencies.
- When using a sliding window, update only the characters entering and leaving the window rather than rebuilding the frequency count.