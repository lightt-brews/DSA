package Trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LC0515_FindLargestinEachTreeRow {

    public List<Integer> largestValues(TreeNode root) {
        
        Queue<TreeNode> queue = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        
        if(root != null){
            queue.add(root);
        }

        while(!queue.isEmpty()){
            int size = queue.size();
            int max = Integer.MIN_VALUE;

            for(int i=0; i< size ; i++){

                TreeNode curr = queue.remove();

                if(curr.left != null){
                    queue.add(curr.left);
                }
                if(curr.right != null){
                    queue.add(curr.right);
                }
                if(max < curr.val){
                    max = curr.val;
                }
            }
            list.add(max);
        }
        return list;
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(9);

        LC0515_FindLargestinEachTreeRow obj = new LC0515_FindLargestinEachTreeRow();
        List<Integer> result = obj.largestValues(root);

        System.out.println(result);
    }
}