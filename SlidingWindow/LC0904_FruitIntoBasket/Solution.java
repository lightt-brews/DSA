import java.util.HashMap;

class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int max_length = 0;
        int left = 0;

        for(int right =0; right<fruits.length; right++){
            map.put(fruits[right], map.getOrDefault(fruits[right],0)+1);

            while(map.size()>2){
                map.put(fruits[left], map.get(fruits[left]) - 1);

                if(map.get(fruits[left]) == 0){
                    map.remove(fruits[left]);
                }

                left++;
            }
            
            max_length= Math.max(max_length, right-left+1);
        }

        return max_length;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] fruits = {1, 2, 1};
        System.out.println(solution.totalFruit(fruits)); // Output: 3
    }
}