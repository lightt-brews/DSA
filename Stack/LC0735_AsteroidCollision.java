import java.util.*;

public class LC0735_AsteroidCollision {
    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<asteroids.length;i++){
            boolean alive = true;
            while(alive && !stack.isEmpty() && stack.peek()>0 && asteroids[i]<0){
                if(Math.abs(asteroids[i])>stack.peek()){
                    stack.pop();
                }
                else if(Math.abs(asteroids[i]) == stack.peek()) {
                    stack.pop();
                    alive = false;
                }
                else{
                    alive = false;
                }
            }
            if(alive){
                stack.push(asteroids[i]);
            }
        }

        int[] ans = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            ans[i] = stack.pop();
        }
        return ans;
    }

    public static void main(String[] args){
        int[] asteroids = {5,10,-5};

        int[] result = asteroidCollision(asteroids);
        for(int i : result){
            System.out.print(i + " ");
        }
    }
}
