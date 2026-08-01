# 71. Simplify Path

## Problem
LeetCode: https://leetcode.com/problems/simplify-path/

## Problem Summary
Given an absolute Unix-style file path, simplify it by resolving special directory references. A single dot (`.`) represents the current directory, a double dot (`..`) represents moving to the parent directory, and multiple consecutive slashes should be treated as a single slash. Return the canonical simplified path.

## Intuition
The path should be processed one directory at a time. Whenever a valid directory name is encountered, it is added to the path. If `..` is encountered, the most recently added directory should be removed. Since directories are revisited in reverse order when moving to the parent, a stack naturally models this behavior.

## Approach
1. Traverse the path and extract directory names between slashes.
2. Ignore empty directory names and `.` since they do not change the path.
3. If `..` is encountered, remove the last directory from the stack if one exists.
4. Otherwise, push the directory name onto the stack.
5. After processing the entire path, join all directories in the stack with `/` to form the canonical path.
6. If the stack is empty, return `/`.

## Complexity
- **Time:** O(n), where `n` is the length of the path.
- **Space:** O(n), in the worst case when every directory is stored in the stack.

## Key Takeaways
- A stack is well-suited for problems involving "undo" operations like moving to a parent directory.
- Ignore empty strings created by consecutive slashes.
- Handle `.` by doing nothing and `..` by popping only when the stack is not empty.
- Building the final path from the stack ensures the canonical Unix path format.