package BinarySearch;

public class Sqrtx_0069 {
    public static int sqrt(int n){
        int left= 1;
        int right = n/2+1;
        while(left<right){
            int mid = left + (right-left)/2;
            if(mid*mid >n){
                right = mid;
            }
            else if((mid == n/mid) || (left==mid)){
                return mid;
            }
            else{
                left = mid;
            }
        }
        return left;
    }

    public static void main(String[] args){
        int n = 225;
        System.out.println(sqrt(n));
    }
}
