package BinarySearch;

public class CapacityToShipPackagesWithinDdays_1011 {
    public static int ship(int[] weights, int days){
        int sum = 0;
        int max = 0;
        for (int num : weights) {
            sum += num;
            max = Math.max(max, num);
        }
        int left= max;
        int right = sum;
        while(left<right){
            int mid = left + (right-left) /2;
            int load =0;
            int d =1;
            for(int i : weights){
                if(load +i<=mid) {
                    load += i;
                }
                else{
                    d++;
                    load = i;
                }
            }
            if(d<=days){
                right = mid;
            }
            else{
                left = mid+1;
            }
        }
        return left;
    }

    public static void main(String[] args){
        int[] weight = {1,2,3,4,5,6,7,8,9,10};
        int days = 5;
        System.out.println(ship(weight,days));
    }
}
