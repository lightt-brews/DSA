import java.util.Random;

public class DutchNationalFlag {

    private static final Random rand = new Random();

    public static int findKthLargest(int[] nums, int k) {
        int target = nums.length - k;
        return QuickSelect(nums, 0, nums.length-1,target);
    }

    public static int[] partition(int[] nums, int left, int right){

        int lt = left;
        int gt = right;

        int pivot = nums[left + rand.nextInt(right - left + 1)];
        int i =left;

        while(i <= gt){
            if(nums[i] < pivot){
                swap(nums,i,lt);
                lt++;
                i++;
            }
            else if(nums[i] > pivot){
                swap(nums, i, gt);
                gt--;
            }
            else{
                i++;
            }
        }

        return new int[]{lt,gt};
    }

    public static int QuickSelect(int[] nums, int left, int right, int target){
        if (left == right){
           return nums[left];
        }

        int[] part = partition(nums, left, right);
        int lt = part[0];
        int gt = part[1];

        if(target < lt){
            return QuickSelect(nums, left, lt-1, target);
        }
        else if(target >gt){
            return QuickSelect(nums, gt+1, right, target);
        }
        else{
            return nums[target];
        }
    }

    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args){
        int[] nums = {3,2,1,5,6,4};
        int k =2;
        System.out.println(findKthLargest(nums,k));

    }
    
}
