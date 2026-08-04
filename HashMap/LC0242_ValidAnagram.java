package HashMap;

public class LC0242_ValidAnagram {

    public boolean isAnagram(String s, String t) {
        int[] freq = new int[26];

        if(s.length() != t.length()){
            return false;
        }

        for(int i=0; i<s.length(); i++){
            freq[s.charAt(i) - 'a']++;
        }

        for(int j=0; j<t.length(); j++){
            if(freq[t.charAt(j) - 'a']<1){
                return false;
            }
            freq[t.charAt(j) - 'a']--;
        }

        return true;
    }

    public static void main(String[] args){
        LC0242_ValidAnagram obj = new LC0242_ValidAnagram();
        String s = "anagram";
        String t = "nagaram";
        System.out.println(obj.isAnagram(s,t));
    }
    
}
