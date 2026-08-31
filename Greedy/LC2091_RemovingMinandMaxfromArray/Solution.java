package Greedy.LC2091_RemovingMinandMaxfromArray;

public class Solution {
    public static int minimumDeletions(int[] nums) {

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int maxind = 0;
        int minind = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxind = i;
            }

            if (nums[i] < min) {
                min = nums[i];
                minind = i;
            }
        }

        int left = Math.min(maxind, minind);
        int right = Math.max(maxind, minind);

        int front = right + 1;
        int back = nums.length - left;
        int both = left + 1 + nums.length - right;

        int res = Math.min(front, Math.min(back, both));

        return res;
    }

    public static void main(String[] args){
        int[] nums = {2,10,7,5,4,1,8,6};
        System.out.println(minimumDeletions(nums));
    }
}
