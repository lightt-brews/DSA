import java.util.*;

public class LC0739_DailyTemperatures {
    public static int[] dailytemp(int[] temp){
        int [] ans = new int[temp.length];

        Stack<Integer> stack = new Stack<>();

        for(int i =0; i<temp.length ; i++){
            while((!stack.isEmpty() && temp[i]> temp[stack.peek()])){
                int index = stack.pop();
                ans[index] = i - index;
            }
            stack.push(i);
        }
        return ans;
    }

    public static void main(String[] args){
        int[] temperatures = {30,40,50,60};

        int[] result = dailytemp(temperatures);

        for(int i : result){
            System.out.print(i + " ");
        }
    }
}
