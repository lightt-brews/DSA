# 703. Kth Largest Element in a Stream

## Problem
LeetCode: https://leetcode.com/problems/kth-largest-element-in-a-stream/

## Problem Summary
Design a class that continuously receives integers from a stream and returns the kth largest element after each new insertion. The class is initialized with an integer `k` and an array of initial numbers.

## Intuition
Instead of storing and sorting every element after each insertion, we only need to keep track of the `k` largest elements seen so far. A min-heap of size `k` is ideal because its root always represents the kth largest element. If a new value is larger than the smallest element in the heap, it replaces it; otherwise, it is ignored.

## Approach
1. Create a min-heap to store at most `k` elements.
2. Insert each initial number using the same logic as the `add()` method.
3. For every new value:
   - If the heap contains fewer than `k` elements, insert it.
   - Otherwise, compare it with the heap's root.
   - If it is larger, remove the root and insert the new value.
4. Return the root of the min-heap, which is always the kth largest element.

## Complexity
- **Time:** O(log k) per `add()` operation.
- **Space:** O(k)

## Key Takeaways
- A fixed-size min-heap efficiently maintains the `k` largest elements.
- The root of the min-heap always represents the kth largest element.
- Heap operations (`offer` and `poll`) take O(log k) time, making the solution efficient for continuous updates.
- This problem is a classic application of priority queues for streaming data.