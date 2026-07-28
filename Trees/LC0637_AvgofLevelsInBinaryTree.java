package Trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LC0637_AvgofLevelsInBinaryTree {

    public List<Double> averageOfLevels(TreeNode root) {
        
        Queue<TreeNode> queue = new ArrayDeque<>();
        List<Double> list = new ArrayList<>();

        if(root != null){
            queue.add(root);
        }

        while(!queue.isEmpty()){
            int size = queue.size();
            double avg = 0;
            double sum = 0;

            for(int i =0; i< size; i++){
                TreeNode curr = queue.remove();
                sum += curr.val;

                if(curr.left != null){
                    queue.add(curr.left);
                }
                if(curr.right != null){
                    queue.add(curr.right);
                }

                if(i == size-1){
                    avg = sum / size; 
                }
            }
            list.add(avg);
        }
        return list;
    }


    public static void main(String[] args){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        LC0637_AvgofLevelsInBinaryTree obj = new LC0637_AvgofLevelsInBinaryTree();
        List<Double> result = obj.averageOfLevels(root);

        System.out.println(result);
    }
    
}
