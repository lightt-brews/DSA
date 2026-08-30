package LC0438_FindAllAnagramsinaString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();

        int[] required = new int[26];
        int[] current = new int[26];

        for (int i = 0; i < p.length(); i++) {
            required[p.charAt(i) - 'a']++;
        }

        int left = 0;

        for (int right = 0; right < s.length(); right++) {

            current[s.charAt(right) - 'a']++;

            if (right - left + 1 == p.length()) {

                if (Arrays.equals(required, current)) {
                    list.add(left);
                }

                current[s.charAt(left) - 'a']--;
                left++;
            }
        }

        return list;
    }
    

    public static void main(String[] args){
        String s = "cbaebabacd";
        String p = "abc";

        List<Integer> result = findAnagrams(s, p);

        System.out.println(result);
    }
}
