# 1732. Find the Highest Altitude

## Problem
LeetCode: https://leetcode.com/problems/find-the-highest-altitude/

## Problem Summary
A cyclist starts at altitude `0` and is given an array `gain`, where each element represents the net altitude change between consecutive points. Return the highest altitude reached during the trip.

## Intuition
The altitude at any point is simply the cumulative sum of all altitude changes up to that point. As we compute this running sum, we can simultaneously keep track of the maximum altitude encountered, eliminating the need to store all intermediate altitudes.

## Approach
1. Initialize the current altitude to `0`, since the cyclist starts at sea level.
2. Initialize a variable to store the maximum altitude, also starting at `0`.
3. Traverse the `gain` array.
4. Add each altitude change to the current altitude.
5. Update the maximum altitude if the current altitude is greater than the previous maximum.
6. Return the maximum altitude after processing the entire array.

## Complexity
- **Time:** O(n)
- **Space:** O(1)

## Key Takeaways
- A running sum can be used to compute cumulative values efficiently.
- It is often unnecessary to store intermediate results when only the current state is required.
- Tracking the answer during traversal avoids an additional pass through the data.
- This problem is a straightforward application of prefix sums using constant extra space.