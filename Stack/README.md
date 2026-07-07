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

### 150. Evaluate Reverse Polish Notation

- uses one stack.
- store the numbers in stack.
- when we see an operand, store the top two values of stack {`b=stack.pop() and a=stack.pop()`} .
- then do the operation accordingly. (a*b, a-b, a/b, a+b).
- at last return stack.pop().