import java.util.*;

public class LC1081SmallestSubsequenceofDistinctCharacters {
    public static String smallestSubsequence(String s) {
        int[] freq = new int[26];
        Stack<Character> stack = new Stack<>();
        HashSet<Character> set = new HashSet<>();

        for(char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            freq[ch - 'a']--;

            if(set.contains(ch)){
                continue;
            }

            while(!stack.isEmpty()
                    && stack.peek() > ch
                    && freq[stack.peek() - 'a'] > 0){

                set.remove(stack.pop());
            }

            stack.push(ch);
            set.add(ch);
        }

        StringBuilder ans = new StringBuilder();
        while(!stack.isEmpty()){
            ans.append(stack.pop());
        }
        return ans.reverse().toString();
    }

    public static void main(String[] args){
        String s = "cbacdcbc";
        System.out.println(smallestSubsequence(s));
    }
}
