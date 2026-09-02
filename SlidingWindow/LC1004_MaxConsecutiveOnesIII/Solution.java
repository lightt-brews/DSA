class Solution {
    public int longestOnes(int[] nums, int k) {

        int max_length = 0;
        int left =0;
        int zeros=0;
        for(int right = 0; right<nums.length; right++){
            if(nums[right] == 0){
                zeros++;
            }
            while(zeros>k){
                if(nums[left] == 0){
                    zeros--;
                }
                left++;
            }
            max_length = Math.max(max_length, right-left+1);
        }
        return max_length;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
        int k = 2;
        int result = solution.longestOnes(nums, k);
        System.out.println(result); // Output: 6
    }
}