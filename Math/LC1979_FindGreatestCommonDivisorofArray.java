package Math;

public class LC1979_FindGreatestCommonDivisorofArray {
    public static int findGCD(int[] nums) {
        int min =Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int num: nums){
            min = Math.min(min,num);
            max = Math.max(max,num);
        }
        return gcd(min,max);
    }

    public static int gcd(int a,int b){
        if(b==0){
            return a;
        }
        return gcd(b, a%b);
    }

    public static void main(String[] args){
        int[] nums = {2,4,6,10,3};
        System.out.println(findGCD(nums));
    }
}
