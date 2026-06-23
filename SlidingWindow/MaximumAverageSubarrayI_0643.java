public class MaximumAverageSubarrayI_0643 {
    public static double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        double max = (double) sum / k;
        for (int j = k; j < nums.length; j++) {
            sum += nums[j];
            sum -= nums[j - k];
            max = Math.max(max, (double) sum / k);
        }
        return max;
    }
    
    public static void main(String[]args){
        int[] nums = {1,12,-5,-6,50,3};
        int k = 4;
        System.out.println(findMaxAverage(nums,k));
    }
}
