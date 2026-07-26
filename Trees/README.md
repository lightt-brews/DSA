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



### 101. Symmetric Tree

- Pattern: DFS (Preorder)
- Use two recursive methods:
  - `isSymmetric(root)` → starts the recursion.
  - `isMirror(left, right)` → checks if two subtrees are mirror images.
- Base case:
  - Both nodes are `null` → return `true`.
  - One node is `null` and the other isn't → return `false`.
- Compare the values of the current nodes.
  - If `left.val != right.val` → return `false`.
- Recursively compare:
  - `left.left` with `right.right`
  - `left.right` with `right.left`
- Return:
  isMirror(left.left, right.right) && isMirror(left.right, right.left)



### 572. Subtree of Another Tree

- uses 2 recursive functions:
  - `isSubtree()` → searches.
  - `isSameTree()` → verifies.

#### `isSubtree()`

- if `root == null` return `false`.
- check current node using `isSameTree(root, subRoot)`.
- if not found, search left and right.
- return `true` if any check is `true`.

#### `isSameTree()`

- handle `null` cases.
- if values differ, return `false`.
- recursively compare left and right.
- both must be `true`.



### 543. Diameter of Binary Tree

- Pattern: DFS (Postorder)
- Use 2 methods:
  - diameterOfBinaryTree(root) -> initializes recursion and returns answer.
  - height(root) -> returns height while updating the diameter.

#### `height()`

- Base case:
  - if `root == null` -> return `0`.
- Recursively find:
  - left height.
  - right height.
- Update diameter:
  - `diameter = Math.max(diameter, left + right)`.
- Return height:
  - `1 + Math.max(left, right)`.

#### `diameterOfBinaryTree()`

- Initialize `diameter = 0`.
- Call `height(root)`.
- Return `diameter`.



### 230. Kth Smallest Element in a BST

- Pattern: DFS (Inorder)
- BST property:
  - Inorder traversal visits nodes in **ascending order**.
- Use class variables:
  - `count` → keeps track of how many nodes have been visited.
  - `ans` → stores the kth smallest value.
- Base case:
  - if `root == null` or `count >= k` → return `ans`.
- Traverse left subtree.
- Visit current node:
  - `count++`.
  - if `count == k`:
    - `ans = root.val`.
- Traverse right subtree.
- Return `ans`.