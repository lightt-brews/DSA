# 394. Decode String

## Problem
LeetCode: https://leetcode.com/problems/decode-string/

## Problem Summary
Given an encoded string where patterns of the form `k[encoded_string]` indicate that the enclosed substring should be repeated `k` times, decode and return the fully expanded string. The encoding may contain nested patterns, and all repeat counts are positive integers.

## Intuition
Whenever an opening bracket `[` is encountered, we need to remember the current string and its corresponding repeat count before processing the nested substring. Since nested encodings follow a last-in, first-out order, a stack is the ideal data structure for storing previous states. When a closing bracket `]` is reached, the most recent state is restored, and the decoded substring is repeated the required number of times.

## Approach
1. Traverse the string character by character.
2. Build multi-digit numbers when digits are encountered.
3. When `[` is found, push the current repeat count and current string onto separate stacks, then reset them.
4. Append characters directly to the current string while processing the substring.
5. When `]` is encountered, pop the previous string and repeat count, append the current decoded substring the required number of times, and continue.
6. Return the final decoded string after the traversal is complete.

## Complexity
- **Time:** O(n × k), where `n` is the length of the input and `k` represents the total length of the decoded output.
- **Space:** O(n), excluding the space required for the output string.

## Key Takeaways
- Stacks are useful for handling nested structures.
- Store the current state before entering a nested level and restore it when exiting.
- Be careful to handle multi-digit repeat counts correctly.
- This problem demonstrates how stacks can simulate recursive behavior iteratively.