import java.util.Stack;

class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minstack;
    public MinStack() {
        stack = new Stack<>();
        minstack = new Stack<>();
    }

    public void push(int value) {
        if (stack.isEmpty()) {
            minstack.push(value);
        } else if(value <= minstack.peek()){
            minstack.push(value);
        }
        else{
            minstack.push(minstack.peek());
        }
        stack.push(value);
    }

    public void pop() {
        stack.pop();
        minstack.pop();

    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minstack.peek();
    }
}

public class LC0155_MinStack{
    public static void main(String[] args){
        MinStack obj = new MinStack();

        obj.push(5);
        obj.push(3);
        obj.push(7);

        System.out.println(obj.top());
        System.out.println(obj.getMin());

        obj.pop();

        System.out.println(obj.top());
        System.out.println(obj.getMin());

        obj.pop();

        System.out.println(obj.top());
        System.out.println(obj.getMin());
    }
}
