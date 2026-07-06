# Stack

## Patterns of Problems Solved

    ### 155. Min Stack

        - Two Stacks.
        - `stack` → actual values.
        - `minStack` → minimum till that index.
        - Push `min(value, currentMin)` into `minStack`.
        - Pop from both stacks.
        - `getMin()` → `minStack.peek()`.


    ### 20. Valid Parentheses

        - uses one stack.
        - if we see opening brackets "({[" then store the closing ones in stack.
        - if we see closing ones then check whether stack has that bracket.
        - if stack is empty or stack doesn't have desired bracket then return false.