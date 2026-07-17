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

### 735. Asteroid Collection

- uses one stack.
- indetify the three conditions i.e.:
    i) both asteroids moving towards each other and both are equal.
    ii) both asteroids are moving towards each other but are not equal. 
    iii) both asteroids are moving away from each other.
- make a boolean alive variable to keep the track of which asteroid is not destroyed.
- if cond i then pop the stack and change alive to false.
- if cond ii then push the one with greater abs value.
- if cond iii then just push if it is alive. 