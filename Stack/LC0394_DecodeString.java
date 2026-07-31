import java.util.Stack;

public class LC0394_DecodeString {

    public static String decodeStringg(String s) {

        Stack<Integer> stack1 = new Stack<>();
        Stack<String> stack2 = new Stack<>();

        int digit = 0;
        String curr ="";

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if(Character.isDigit(ch)){
                digit = digit * 10 + (ch - '0');
            }
            else if(ch == '['){
                stack1.push(digit);
                digit = 0;

                stack2.push(curr);
                curr = "";

            }
            else if(Character.isAlphabetic(ch)){
                curr += ch;
            }
            else if(ch == ']'){
                String prv = stack2.pop();
                int count = stack1.pop();
                curr = prv + curr.repeat(count);
            }
        }

        return curr;
    }

    public static void main(String[] args) {
        String s = "3[a]2[bc]";
        String result = decodeStringg(s);
        System.out.println(result); // Output: aaabcbc
    }
    
}
