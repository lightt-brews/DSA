import java.util.Stack;

public class LC0150_EvaluateRPN {
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String i:tokens){
            if (i.equals("+") || i.equals("-") || i.equals("/") || i.equals("*")){
                int b = stack.pop();
                int a = stack.pop();
                if(i.equals("+")){
                    a += b;
                }
                else if(i.equals("-")){
                    a -= b;
                }
                else if(i.equals("/")){
                    a /= b;
                }
                else{
                    a *= b;
                }
                stack.push(a);
            }
            else{
                int num = Integer.parseInt(i);
                stack.push(num);
            }
        }
        return stack.pop();
    }


    public static void main(String[] args){
        String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(evalRPN(tokens));
    }
}
