package Queue;

import java.util.Stack;

class MyQueue {
    
    Stack <Integer> stack;
    Stack <Integer> hstack;

    public MyQueue() {
        stack = new Stack<>();
        hstack = new Stack<>();
    }
    
    public void push(int x) { 
        stack.push(x);
    }
    
    public int pop() {

        if(hstack.isEmpty()){
            while(!stack.isEmpty()){
                hstack.push(stack.pop());
            }
        }
        return hstack.pop();
    }
    
    public int peek() {
        if(hstack.isEmpty()){
            while(!stack.isEmpty()){
                hstack.push(stack.pop());
            }
        }
        return hstack.peek();
    }
    
    public boolean empty() {
        return stack.isEmpty() && hstack.isEmpty();
    }
}

public class LC0232_QueueUsingStack {
    
    public static void main(String[] args){
        MyQueue obj = new MyQueue();
        obj.push(1);
        obj.push(2);
        System.out.println(obj.peek());
        System.out.println(obj.pop());
        System.out.println(obj.empty());
    }
}
