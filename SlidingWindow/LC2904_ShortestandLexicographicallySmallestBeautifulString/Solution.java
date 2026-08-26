package LC2904_ShortestandLexicographicallySmallestBeautifulString;

import java.util.*;

public class Solution {

    public static String shortestBeautifulSubstring(String s, int k){
        ArrayList<Integer> ones = new ArrayList<>();

        for(int i = 0; i<s.length() ; i++){
            if(s.charAt(i) == '1'){
                ones.add(i);
            }
        }

        if(ones.size()<k){
            return "";
        }

        String best = null;

        for(int i=0; i<=ones.size() -k; i++){
            int start = ones.get(i);
            int end = ones.get(i+k-1);

            String candidate = s.substring(start,end+1);

            if(best == null || candidate.length() < best.length() || (candidate.length() == best.length() && candidate.compareTo(best) <0)){
                best = candidate;
            }

        }

        return best;
    }
    public static void main(String[] args){
        String s = "100011001";
        int k = 3;
        System.out.println("answer : " + shortestBeautifulSubstring(s, k));
    }
    
}
