package PrefixSum.LC1732_FindtheHighestAltitude;

public class Solution {
    public int largestAltitude(int[] gain) {
    int currentAltitude = 0;
    int max = 0;

    for (int i = 0; i < gain.length; i++) {
        currentAltitude += gain[i];
        max = Math.max(max, currentAltitude);
    }

    return max;
}
    public static void main(String[] args){
        int[] gain = {-5,1,5,0,-7};
        Solution obj = new Solution();
        System.out.println(obj.largestAltitude(gain));
    }
}
