# 1001. Grid Illumination

## Problem
LeetCode: https://leetcode.com/problems/shortest-beautiful-substring/

## Problem Summary
Given a binary string `s` and an integer `k`, find the shortest substring containing exactly `k` occurrences of `1`. If multiple substrings have the same minimum length, return the lexicographically smallest one. If no such substring exists, return an empty string.

## Intuition
Only the positions of the `1`s matter.

If we choose `k` consecutive `1`s in the string, the shortest substring containing those `k` `1`s must start at the first selected `1` and end at the last selected `1`. Any extra characters outside these positions would only make the substring longer.

So, we first store the indices of every `1`. Then, for every group of `k` consecutive `1`s, we construct the substring between the first and last `1` and compare it with the best candidate found so far.

## Approach
1. Store the indices of every `1` in an `ArrayList`.
2. If there are fewer than `k` ones, return an empty string.
3. Consider every group of `k` consecutive `1`s.
4. For each group:
   - Use the first `1` as the starting index.
   - Use the kth `1` as the ending index.
   - Create the substring between these two positions.
5. Compare the candidate with the current best substring:
   - Choose it if it is shorter.
   - If both have the same length, choose the lexicographically smaller one.
6. Return the best substring.

## Why Do We Only Check Groups of Consecutive `1`s?
A valid substring containing exactly `k` ones must contain some `k` consecutive ones from the list of all ones.

For example, if the positions of the ones are:

`[2, 5, 6, 10]`

and `k = 2`, the possible groups are:

- `(2, 5)`
- `(5, 6)`
- `(6, 10)`

Checking these groups is enough because any substring containing exactly `k` ones must have its first and last `1` represented by one of these groups.

## Complexity
- **Time:** O(n + m × k), where `n` is the length of the string and `m` is the number of possible groups of `k` ones.
- **Space:** O(n), for storing the positions of the `1`s.

## Key Takeaways
- When a problem asks for a substring containing exactly `k` occurrences of a particular character, storing the positions of that character can simplify the problem.
- For a fixed group of `k` consecutive ones, the shortest valid substring starts at the first one and ends at the kth one.
- After finding the minimum length, lexicographical comparison is used to break ties.
- `i <= ones.size() - k` ensures that there are still at least `k` ones available starting from index `i`.
```