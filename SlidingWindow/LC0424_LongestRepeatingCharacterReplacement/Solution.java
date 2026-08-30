package LC0424_LongestRepeatingCharacterReplacement;

public class Solution {
    public static int characterReplacement(String s, int k) {
        int[] freq = new int[26];

        int max_length = 0;
        int left = 0;
        int max_freq = 0;

        for(int right = 0; right <s.length(); right++){
            char ch = s.charAt(right);

            freq[ch - 'A']++;
            max_freq = Math.max(max_freq, freq[ch-'A']);

            while((right-left+1)-max_freq >k){
                left++;
                freq[s.charAt(left) - 'A']--;
            }

            max_length = Math.max(max_length,right-left+1);
        }

        return max_length;
    }

    public static void main(String[] args){
        String s = "ABAABA";
        int k = 2;
        System.out.println(characterReplacement(s, k));
    }
}
