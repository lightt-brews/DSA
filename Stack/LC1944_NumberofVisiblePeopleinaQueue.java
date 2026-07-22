import java.util.*;
public class LC1944_NumberofVisiblePeopleinaQueue {
    public static int[] canSeePersonsCount(int[] heights) {
        int[] ans = new int[heights.length];
        Stack<Integer> stack = new Stack<>();
        for(int i = heights.length-1; i>=0 ; i--){

            while(!stack.isEmpty() && stack.peek()<heights[i]){
                stack.pop();
                ans[i]++;
            }
            if(!stack.isEmpty()) {
                ans[i]++;
            }
            stack.push(heights[i]);
        }
        return ans;
    }


    public static void main(String[] args){
        int[] heights = {10,6,8,5,11,9};
        int[] result = canSeePersonsCount(heights);
        for(int num: result){
            System.out.print(num + " ");
        }
    }
}
