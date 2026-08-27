package LC0567_PermutationinString;
import java.util.*;

public class Solution {

    public static  boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        HashMap<Character,Integer> required = new HashMap<>();
        HashMap<Character,Integer> window = new HashMap<>();

        for(int i=0; i<s1.length(); i++){
            required.put(s1.charAt(i), required.getOrDefault(s1.charAt(i),0)+1);
        }

        int left = 0;
        
        for(int right =0; right< s2.length(); right++){
            
            char ch = s2.charAt(right);
            window.put(ch,window.getOrDefault(ch,0)+1);
            
            if(right-left+1> s1.length()){
                char remove = s2.charAt(left);

                window.put(remove, window.get(remove)-1);

                if(window.get(remove) == 0){
                    window.remove(remove);
                }
                left++;
            }

            if(window.equals(required)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args){
        String s1 = "ab";
        String s2 = "eidbaooo";
        System.out.println(checkInclusion(s1, s2));
    }
}
