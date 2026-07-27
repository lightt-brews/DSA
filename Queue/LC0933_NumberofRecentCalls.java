package Queue;
import java.util.*;

class RecentCounter {
    Queue<Integer> queue;
    int x = 0;
    public RecentCounter() {
        queue = new ArrayDeque<>();
    }
    
    public int ping(int t) {

        queue.add(t);
        while(!queue.isEmpty() && queue.peek() < t-3000){
            queue.remove();
        }
        return queue.size();
    }
}


public class LC0933_NumberofRecentCalls {
    public static void main(String[] args){
        RecentCounter obj = new RecentCounter();
        System.out.println(obj.ping(1));
        System.out.println(obj.ping(100));
        System.out.println(obj.ping(3001));
        System.out.println(obj.ping(3002));
    }
}
