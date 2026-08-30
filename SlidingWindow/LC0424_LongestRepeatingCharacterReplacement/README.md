# 424. Longest Repeating Character Replacement

## Problem
LeetCode: https://leetcode.com/problems/longest-repeating-character-replacement/

## Problem Summary
Given a string `s` containing uppercase English letters and an integer `k`, find the length of the longest substring that can be turned into a string containing only one distinct character by replacing at most `k` characters.

## Intuition
For any window, we can choose the character that appears most frequently and replace all the other characters with it.

If the window has length `windowSize` and the most frequent character appears `maxFreq` times, then the number of replacements needed is:

`windowSize - maxFreq`

If this value is at most `k`, the window is valid.

We use a sliding window to find the longest valid substring. When the window becomes invalid, we move the left pointer forward until it becomes valid again.

## Approach
1. Create an array of size `26` to store the frequency of each uppercase character.
2. Use two pointers, `left` and `right`, to represent the current window.
3. Move `right` through the string and increase the frequency of the current character.
4. Keep track of `maxFreq`, the highest frequency of any character in the current window.
5. Calculate the number of replacements needed:
   `windowSize - maxFreq`
6. If the required replacements are greater than `k`, move `left` forward and decrease the frequency of the character leaving the window.
7. Keep track of the maximum valid window length.
8. Return the maximum length.

## Why Does `windowSize - maxFreq` Give the Number of Replacements?
Suppose the current window is:

`A A B A C`

The window contains `5` characters, and `A` is the most frequent character with a frequency of `3`.

If we want the entire window to contain only `A`, we need to replace the other `2` characters:

`5 - 3 = 2`

So the number of replacements required is:

`windowSize - maxFreq`

If that value is `<= k`, the window can be made valid.

## Important Observation
When the window becomes invalid, we do not need to decrease `maxFreq` when moving the left pointer.

`maxFreq` is only used to determine whether we can potentially extend the window. Keeping the maximum frequency from earlier windows does not affect the final answer because we only increase the answer when a window appears valid.

This allows the solution to remain O(n) without recalculating the maximum frequency after every window change.

## Complexity
- **Time:** O(n)
- **Space:** O(1), since the frequency array always contains only 26 characters.

## Key Takeaways
- Fixed or condition-based sliding windows are useful for substring problems.
- `windowSize - maxFreq` represents how many characters need to be replaced.
- Use a frequency array when the character set is small and fixed.
- The key condition for a valid window is:
  `windowSize - maxFreq <= k`
- Keeping `maxFreq` instead of recalculating it after every left-pointer movement keeps the solution linear.