# Tress

## Patterns of Problems Solved



### 104. Maximum Depth of Binary Tree

- DFS (Postorder).
- Base case: `root == null` -> return 0.
- Every node asks left & right subtree for their depth.
- Current node returns `max(leftDepth, rightDepth) + 1`.
- Parent waits for children's return values before computing its own.



### 226. Invert Binary Tree

- Pattern: DFS (Preorder)
- Base case: root == null → return null.
- Swap the left and right child of the current node.
- Recursively invert the left subtree.
- Recursively invert the right subtree.
- Return the current root.



### 100. Same Tree

- Pattern: DFS (Preorder) 
- Base case: 
    - Both nodes are `null` -> return `true`. 
    - One node is `null` and the other isn't -> return `false`. 
- Compare the values of the current nodes. 
    - If `p.val != q.val` -> return `false`. 
- Recursively compare: 
    - Left subtree with left subtree. 
    - Right subtree with right subtree. 
- Return: isSameTree(p.left, q.left) && isSameTree(p.right, q.right)