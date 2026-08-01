import java.util.Stack;

public class LC0071_SimplifyPath {

    public static String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String curr = "";

        path += "/";

        for (char ch : path.toCharArray()) {
            if (ch == '/') {
                if (curr.equals("..") && !stack.isEmpty()) {
                    stack.pop();
                } else if (!curr.equals("") && !curr.equals(".") && !curr.equals("..")) {
                    stack.push(curr);
                }
                curr = "";
            } else {
                curr += ch;
            }
        }

        if (stack.isEmpty()) {
            return "/";
        }

        StringBuilder ans = new StringBuilder();

        for (String dir : stack) {
            ans.append("/").append(dir);
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        String path = "/a/./b/../../c/";
        System.out.println(simplifyPath(path));
    }
}