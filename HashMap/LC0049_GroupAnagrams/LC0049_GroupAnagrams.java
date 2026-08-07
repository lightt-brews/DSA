package HashMap.LC0049_GroupAnagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LC0049_GroupAnagrams {

    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();

        for(int i=0;i<strs.length;i++){
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);

            if(!map.containsKey(sorted)){
                map.put(sorted,new ArrayList<>());
            }    
            map.get(sorted).add(strs[i]);       
        }

        return new ArrayList<>(map.values());
    }
    

    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> result = groupAnagrams(strs);
        System.out.println(result);
    }
}
