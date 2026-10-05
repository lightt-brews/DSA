# 856. Score of Parentheses

## Problem
LeetCode: https://leetcode.com/problems/score-of-parentheses/

## Problem Summary
Given a balanced parentheses string, calculate its score using these rules:

- `"()"` has a score of `1`.
- Concatenated strings have a score equal to their individual scores added together.
- A balanced string inside parentheses has its score doubled.

## Intuition
A stack can be used to keep track of the score at each level of nested parentheses.

Whenever we encounter `(`, we start a new level with score `0`. When we encounter `)`, we finish the current level:

- If the current level has score `0`, it represents `"()"`, so its score is `1`.
- Otherwise, it represents `(A)`, so its score becomes `2 * A`.

We then add this score to the previous level.

## Approach
1. Initialize a stack with `0` to represent the outermost level.
2. For every character:
   - If it is `(`, push `0` onto the stack for the new nested level.
   - If it is `)`:
     - Pop the score of the current level.
     - If it is `0`, its score is `1`.
     - Otherwise, its score is doubled.
     - Add the resulting score to the previous level.
3. The value remaining at the bottom of the stack is the total score.

## Example
For:

`(()(()))`

The nested structure is evaluated from the inside out.

- `()` → `1`
- `(())` → `2`
- `(()(()))` → `6`

Therefore, the answer is `6`.

## Complexity
- **Time:** O(n)
- **Space:** O(n)

## Key Takeaways
- A stack is useful for keeping track of scores at different nesting levels.
- `0` at a newly opened level represents that no score has been generated inside it yet.
- An empty level when `)` is encountered means we found `"()"`, which has score `1`.
- A non-empty level represents `(A)`, so its score is doubled before being added to the outer level.