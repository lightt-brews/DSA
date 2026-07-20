# Linked List

## Patterns of Problems Solved 



### 19. Remove nth Node from the End of the List

- using two pointer fast and slow.
- keep fast n nodes ahead
- then run both slow and fast 1 step at a time.
- slow stops before the node to remove. skip the node.
- Edge Case : if `fast == null`, remove the head (`return head.next`).



### 143. Reorder List

- Optimal: O(1) space.
- Pattern: Find Middle + Reverse Second Half + Merge.
- Find middle using slow/fast pointer.
- Reverse second half of linked list.
- Merge first half and reversed second half alternately.
- Use prev, curr, next pointers for reversing.