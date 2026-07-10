import java.util.*;

public class LC0496_NextGreaterElementI {
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        int[] target = new int[nums1.length];

        for(int num : nums2){
            while(!stack.isEmpty() && num>stack.peek()){
                map.put(stack.pop(),num);
            }
            stack.push(num);
        }
        while(!stack.isEmpty()){
            map.put(stack.pop(),-1);
        }
        for(int j=0;j<nums1.length;j++){
            target[j] = map.get(nums1[j]);
        }
        return target;
    }

    public static void main(String[] args){
        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};
        int[] result = nextGreaterElement(nums1,nums2);
        for(int i: result){
            System.out.print(i + " ");
        }
    }
}
