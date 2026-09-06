package LC1658_MinimumOperationstoReduceXtoZero;

class Solution {
    public int minOperations(int[] nums, int x) {
        int total = 0;

        for (int num : nums) {
            total += num;
        }

        int needed = total - x;

        if (needed < 0) {
            return -1;
        }

        int left = 0;
        int windowSum = 0;
        int maxLength = -1;

        for (int right = 0; right < nums.length; right++) {
            windowSum += nums[right];

            while (windowSum > needed) {
                windowSum -= nums[left];
                left++;
            }

            if (windowSum == needed) {
                maxLength = Math.max(maxLength, right - left + 1);
            }
        }

        return maxLength == -1 ? -1 : nums.length - maxLength;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 1, 4, 2, 3};
        int x = 5;
        int result = solution.minOperations(nums, x);
        System.out.println(result); // Output: 2
    }
}