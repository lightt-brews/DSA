import java.util.*;

public class ContainsDuplicateII {
    public static boolean containsNearbyDuplicate(int[] nums, int k){
        HashSet<Integer> set = new HashSet<>();
        int i = 0;
        int j =0;
        while(j<nums.length){
            if(set.contains(nums[j]) && Math.abs(i-j)<=k){
                return true;
            }
            else if(set.contains(nums[j]) && Math.abs(i-j)>k){
                set.remove(nums[i]);
                i++;
            }
            else{
                set.add(nums[j]);
                j++;
            }
        }
        return false;
    }

    public static void main(String[] args){
        int[] nums = {1,2,3,1,2,3};
        int k = 2;
        System.out.println(containsNearbyDuplicate(nums,k));
    }
}
