import java.util.Stack;

class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                stack.push(0);
            } 
            else {
                int inner = stack.pop();

                if (inner == 0) {
                    inner = 1;
                } else {
                    inner *= 2;
                }

                int outer = stack.pop();
                stack.push(outer + inner);
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "(()(()))";
        int score = solution.scoreOfParentheses(s);
        System.out.println("Score of parentheses: " + score);
    }
}