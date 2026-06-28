import java.util.Hashtable;

class LC0594_LongestHarmoniousSubsequence {
    public static int findLHS(int[] nums) {
        Hashtable<Integer,Integer> table = new Hashtable<>();
        int t = 0;
        for(int k= 0;k<nums.length;k++){
            if(table.containsKey(nums[k])){
                table.put(nums[k],table.get(nums[k])+1);
            }
            else{
                table.put(nums[k],1);
            }
        }
        for (Integer key : table.keySet()){
            if (table.containsKey(key+1)){
                t = Math.max(table.get(key+1)+ table.get(key),t);
            }
            else if(table.containsKey(key-1)){
                t = Math.max(table.get(key-1)+ table.get(key),t);
            }
        }
        return t;
    }

    public static void main(String[]args){
        int[] nums = {1,3,2,2,5,2,3,7};
        System.out.println(findLHS(nums));
    }
}
