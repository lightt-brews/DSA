# 49. Group Anagrams

## Problem
LeetCode: https://leetcode.com/problems/group-anagrams/

## Problem Summary
Given an array of strings, group the strings that are anagrams of each other. Two strings are anagrams if they contain the same characters with the same frequencies, regardless of their order.

## Intuition
Anagrams become identical when their characters are sorted. This sorted string can serve as a unique key representing all of its anagrams. By using a HashMap where the key is the sorted string and the value is a list of original strings, all anagrams can be grouped together efficiently.

## Approach
1. Iterate through each string in the input array.
2. Convert the string into a character array and sort it.
3. Convert the sorted character array back into a string to use as the HashMap key.
4. If the key does not exist in the HashMap, create a new list for it.
5. Add the original string to the corresponding list.
6. Return all the grouped lists stored in the HashMap.

## Complexity
- **Time:** O(n × k log k), where `n` is the number of strings and `k` is the average length of a string.
- **Space:** O(n × k), for storing the grouped strings in the HashMap.

## Key Takeaways
- Sorting each string creates a canonical representation for all of its anagrams.
- A HashMap is useful for grouping elements based on a computed key.
- The original strings are stored as values, while only the sorted version is used as the key.
- This is a classic "transform then group" pattern commonly used with hash-based data structures.