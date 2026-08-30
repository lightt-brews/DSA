# 438. Find All Anagrams in a String

## Problem
LeetCode: https://leetcode.com/problems/find-all-anagrams-in-a-string/

## Problem Summary
Given two strings `s` and `p`, find all starting indices in `s` where an anagram of `p` occurs.

An anagram contains the same characters with the same frequencies, but the characters can be arranged in any order.

## Intuition
Every anagram of `p` has two important properties:

- It has the same length as `p`.
- It contains exactly the same frequency of every character.

Therefore, we can use a fixed-size sliding window of length `p.length()` over `s`.

Instead of generating permutations of `p`, we maintain the character frequencies inside the current window. Whenever the window's frequencies match the frequencies of `p`, we have found an anagram.

## Approach
1. Create a frequency array for the characters in `p`.
2. Use a sliding window of size `p.length()` on `s`.
3. As the right pointer moves, add the new character to the window.
4. Once the window becomes larger than `p.length()`, remove the character at the left pointer.
5. Compare the frequency of the current window with the frequency of `p`.
6. If they are equal, add the window's starting index to the answer.
7. Continue until the entire string has been processed.

## Example
For:

`s = "cbaebabacd"`  
`p = "abc"`

The windows of length `3` include:

`"cba"` → anagram of `"abc"` → index `0`

Later:

`"bac"` → anagram of `"abc"` → index `6`

Therefore, the answer is:

`[0, 6]`

## Why Use a Fixed-Size Window?
An anagram must contain exactly the same number of characters as `p`.

For example, if:

`p = "abc"`

then valid anagrams must have length `3`.

So, instead of checking every possible substring length, we only need to examine windows of length `p.length()`.

## Complexity
- **Time:** O(n), where `n` is the length of `s`.
- **Space:** O(1), assuming only lowercase English letters are used.

## Key Takeaways
- Anagrams can be identified by comparing character frequencies.
- A fixed-size sliding window is ideal when the target substring must have a specific length.
- Instead of rebuilding the frequency count for every window, update it as characters enter and leave the window.
- This is closely related to the sliding-window approach used in Problem 567, but here we collect every matching window instead of stopping after finding the first one.