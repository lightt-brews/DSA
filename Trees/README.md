# Tress

## Patterns of Problems Solved



### 104. Maximum Depth of Binary Tree

- DFS (Postorder).
- Base case: `root == null` → return 0.
- Every node asks left & right subtree for their depth.
- Current node returns `max(leftDepth, rightDepth) + 1`.
- Parent waits for children's return values before computing its own.