package BinarySearch;

class LC0875_KokoEatingBananas {
    public static int koko(int[] piles, int h){
        int max = 1;
        for(int i =0; i< piles.length;i++){
            max  = Math.max(piles[i] , max);
        }
        int left = 1;
        int right = max;
        while(left<right){
            int mid = left + (right-left) /2;
            int totalHours = 0;
            for(int i=0;i<piles.length;i++){
                totalHours += ((piles[i]+mid-1)/mid);
            }
            if(totalHours<=h){
                right = mid;
            }
            else if(totalHours>h){
                left = mid +1;
            }
        }
        return left;
    }
    
    public static void main(String[] args){
        int[] piles=  {3,6,7,11};
        int h =8;
        System.out.println(koko(piles,h));
    }
}
