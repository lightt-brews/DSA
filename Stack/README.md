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



### 853. Car Fleet

- can be done without stack too.
- make a 2d array which is sorted based on car closest to target.
- calculate the time for each car. (target-pos/speed = time)
- push the time in stack if the new car is slower than the prv car.
- now return the stack size which is out size of fleet.



### 735. Asteroid Collision

- Uses one stack.
- Collision occurs only when:
  - `stack.peek() > 0`
  - `current < 0`
- Three cases:
  1. Equal size → pop stack, current also dies.
  2. Current is larger → pop stack and continue checking.
  3. Stack top is larger → current dies.
- Use a boolean `alive` to track whether the current asteroid survives.
- Push the current asteroid only if it survives all collisions.



### 1081. Smallest Subsequence of Distinct Characters

- Uses one monotonic stack. (Increasing monotonic stack)
- Use:
  - `HashSet` → check if char is already in stack.
  - `freq[]` → check if char appears again.
- Pop occurs only when:
  - `stack.peek() > current`
  - `freq[stack.peek()] > 0`
- Three cases:
  1. Character already in stack → skip.
  2. Top is bigger and appears again → pop top.
  3. Otherwise → push current.
- Remove bigger chars only if they can be added later.
- Push current char after all possible pops.

- NOTE : THIS QUESTION IS SAME AS 316.



### 143. Reorder List

- Uses one stack.
- Store the second half of linked list in stack.
- Find middle using slow/fast pointer.
- Stack gives reverse order of second half.
- Merge:
  - first half node → stack node → repeat.
- Rearrange nodes by changing `next` pointers.