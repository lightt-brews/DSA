import java.util.HashSet;

public class LengthOfLongestSubstring_0003 {
    public static int lengthoflongestsubstring(String s){
        HashSet<Character> set = new HashSet<>();
        int left = 0;
        int right = 0;
        int max = 0;
        while(right<s.length()){
            if(left>s.length()){
                break;
            }
            else if(set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }
            else{
                set.add(s.charAt(right));
                right++;
                max = (Math.max(set.size(),max));
            }
        }
        System.out.println(set);
        return max;
    }

    public static void main(String[] args){
        String s = "pwwkew";
        System.out.println("length: " + lengthoflongestsubstring(s));
    }
}
