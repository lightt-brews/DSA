import java.util.*;

public class LC0853_CarFleet {
    public static int carFleet(int target, int[] position, int[] speed) {
        int[][] cars = new int[position.length][2];
        Stack<Double> stack= new Stack<>();

        for (int i = 0; i < position.length; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        Arrays.sort(cars, (a, b) -> Integer.compare(a[0], b[0]));

        for (int i = cars.length - 1; i >= 0; i--) {
            double time = (target - cars[i][0]) / (double) cars[i][1];

            if(stack.isEmpty() || time>stack.peek()){
                stack.push(time);
            }
        }

        return stack.size();
    }

    public static void main(String[] args){
        int target = 12;
        int[] position = {10,8,0,5,3};
        int[] speed = {2,4,1,1,3};

        System.out.println(carFleet(target,position,speed));
    }
}
