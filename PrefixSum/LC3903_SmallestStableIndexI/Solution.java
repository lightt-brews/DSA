class Solution {
    public int firstStableIndex(int[] nums, int k) {

        int[] suffixMin = new int[nums.length];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i =nums.length-1; i>=0; i--){
            if(nums[i]<min){
                min = nums[i];
            }
            suffixMin[i] = min; 
        }

        for(int n = 0; n<nums.length; n++){
            if(nums[n] > max){
                max = nums[n];
            }
            if(max - suffixMin[n] <= k){
                return n;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 3, 2, 4, 5};
        int k = 2;
        int result = solution.firstStableIndex(nums, k);
        System.out.println("First stable index: " + result); // Output: First stable index: 1
    }
}